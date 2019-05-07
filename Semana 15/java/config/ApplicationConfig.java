package config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("web")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> recursos = new HashSet<Class<?>>();
		recursos.add(services.FileResources.class);
		return recursos;
	}

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("jersey.config.server.provider.classnames","org.glassfish.jersey.media.multipart.MultiPartFeature");
		return props;
	}

	
	
	
}
