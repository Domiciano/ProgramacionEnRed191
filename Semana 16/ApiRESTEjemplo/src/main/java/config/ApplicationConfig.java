package config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("web")
public class ApplicationConfig extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> recursos = new HashSet<Class<?>>();
		recursos.add(services.First.class);
		recursos.add(services.ActoresResources.class);
		recursos.add(services.PeliculasResources.class);
		return recursos;
	}

	
	
}
