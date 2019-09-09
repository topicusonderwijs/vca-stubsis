package nl.topicus.cambo.stubsis;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import nl.topicus.cambo.stubsis.client.StubSISCamboClient;
import nl.topicus.cambo.stubsis.model.Aanmeldingen;

@ApplicationScoped
@Path("/")
public class StubSISEndPoint
{
	private Configuration freemarkerCfg;

	@Inject
	private StubSISCamboClient client;

	@PostConstruct
	public void init()
	{
		freemarkerCfg = new Configuration(Configuration.VERSION_2_3_28);
		freemarkerCfg.setClassForTemplateLoading(StubSISEndPoint.class, "");
		freemarkerCfg.setDefaultEncoding("UTF-8");
	}

	@GET
	@Path("ui")
	public Response inspect()
	{
		return query("SIS", null, null);
	}

	@POST
	@Path("ui")
	public Response query(@FormParam("action") String action,
			@FormParam("endpoint") String endpoint, @FormParam("uri") String uriStr)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("accesstoken", client.ensureToken());

		URI uri;
		Class< ? > responseType = null;
		switch (action)
		{
			default:
			case "SIS":
				uri = client.me();
				break;
			case "Koppelpunten":
				uri = client.endpoints();
				break;
			case "Nieuwe aanmeldingen":
				uri = client.nieuweAanmeldingen(endpoint);
				responseType = Aanmeldingen.class;
				break;
			case "Aanmeldingen":
				uri = client.aanmeldingen(endpoint);
				responseType = Aanmeldingen.class;
				break;
			case "Query":
				uri = UriBuilder.fromUri(uriStr).build();
				break;
		}

		Object response = client.read(uri, responseType);
		params.put("test", client.toJsonString(response));
		params.put("uri", uri);
		String html = renderHtml("stubsis.ftl", params);
		return Response.ok(html, MediaType.TEXT_HTML_TYPE).build();
	}

	private String renderHtml(String template, Map<String, Object> params)
	{
		try
		{
			Template temp = freemarkerCfg.getTemplate(template);
			StringWriter out = new StringWriter();
			temp.process(params, out);
			return out.toString();
		}
		catch (IOException | TemplateException e)
		{
			throw new RuntimeException(e);
		}
	}
}
