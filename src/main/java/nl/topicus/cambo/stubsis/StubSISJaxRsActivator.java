package nl.topicus.cambo.stubsis;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class StubSISJaxRsActivator extends Application
{
	@Override
	public Set<Class< ? >> getClasses()
	{
		return Set.of(StubSISEndPoint.class);
	}
}
