package nl.topicus.cambo.stubsis.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import nl.topicus.cambo.stubsis.model.AccessTokenResponse;

@ApplicationScoped
public class StubSISCamboClient
{
	private static final GenericType<Map<String, Object>> ANY_TYPE = new GenericType<>()
	{
	};

	private Client client;

	private ObjectMapper mapper;

	private String accessToken;

	private Instant accessTokenExpiresAt = Instant.now();

	private static final MediaType CAMBO_JSON_TYPE =
		MediaType.valueOf("application/vnd.topicus.cambo+json");

	public StubSISCamboClient()
	{
	}

	private static ObjectMapper createMapper()
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.setTimeZone(TimeZone.getDefault());
		mapper.registerModule(new JavaTimeModule());
		return mapper;
	}

	@PostConstruct
	private void init()
	{
		mapper = createMapper();

		client = ClientBuilder.newBuilder()
			.connectTimeout(10, TimeUnit.SECONDS)
			.keyStore(readStubSISKeyStore(), "password")
			.register(JacksonJaxbJsonProvider.class)
			.register(new JacksonObjectMapperProvider(mapper))
			.build();
	}

	private KeyStore readStubSISKeyStore()
	{
		try (FileInputStream fis = new FileInputStream(System.getProperty("stubsis/tlscertbundle")))
		{
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(fis, System.getProperty("stubsis/tlscertpassword").toCharArray());
			return ks;
		}
		catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e)
		{
			throw new RuntimeException(e);
		}
	}

	private String getCamboUrl()
	{
		return "https://" + System.getProperty("cambo/hostname");
	}

	public String ensureToken()
	{
		if (accessTokenExpiresAt.isAfter(Instant.now().plus(5, ChronoUnit.MINUTES)))
			return accessToken;

		Response response = null;
		URI uri = UriBuilder.fromUri(getCamboUrl()).path("/login/oauth2/token").build();
		MultivaluedMap<String, String> form = new MultivaluedHashMap<>();
		form.putSingle("client_id", "99999999999999999999");
		form.putSingle("grant_type", "client_credentials");

		try
		{
			response = client.target(uri)
				.request()
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
			if (response.getStatus() != Status.OK.getStatusCode())
			{
				throw new RuntimeException(toJsonString(response.readEntity(ANY_TYPE)));
			}
			AccessTokenResponse tokenResponse = response.readEntity(AccessTokenResponse.class);
			accessToken = tokenResponse.getAccessToken().toString();
			accessTokenExpiresAt =
				Instant.now().plus(tokenResponse.getExpiresIn(), ChronoUnit.SECONDS);
			return accessToken;
		}
		finally
		{
			close(response);
		}
	}

	protected void close(Response response)
	{
		if (response != null)
			response.close();
	}

	public URI me()
	{
		return UriBuilder.fromUri(getCamboUrl()).path("/cambo/rest/v1/party/me").build();
	}

	public URI endpoints()
	{
		return UriBuilder.fromUri(getCamboUrl()).path("/cambo/rest/v1/koppelpunt").build();
	}

	public URI nieuweAanmeldingen(String endpoint)
	{
		return UriBuilder.fromUri(getCamboUrl())
			.path("/cambo/rest/v1/koppelpunt")
			.path(endpoint)
			.path("aanmelding/nieuw")
			.build();
	}

	public URI aanmeldingen(String endpoint)
	{
		return UriBuilder.fromUri(getCamboUrl())
			.path("/cambo/rest/v1/koppelpunt")
			.path(endpoint)
			.path("aanmelding")
			.build();
	}

	public Object read(URI uri, Class< ? > responseType)
	{
		Response response = null;
		try
		{
			response = client.target(uri)
				.request(CAMBO_JSON_TYPE)
				.header("Authorization", "Bearer " + ensureToken())
				.get();
			if (responseType == null)
				return response.readEntity(ANY_TYPE);
			else
				return response.readEntity(responseType);
		}
		finally
		{
			close(response);
		}
	}

	public String toJsonString(Object obj)
	{
		try
		{
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		}
		catch (JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
	}
}
