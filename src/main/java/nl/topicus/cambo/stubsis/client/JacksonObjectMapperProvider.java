package nl.topicus.cambo.stubsis.client;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper>
{
	private ObjectMapper mapper;

	public JacksonObjectMapperProvider(ObjectMapper mapper)
	{
		this.mapper = mapper;
	}

	@Override
	public ObjectMapper getContext(Class< ? > type)
	{
		return mapper;
	}
}
