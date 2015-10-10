package solutions.egen.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
public class RESTDB extends ResourceConfig {
	
	public RESTDB(){
		packages("solutions.egen.rest");// could be ...rest.controller
		
		//swagger
		register(io.swagger.jaxrs.listing.ApiListingResource.class);
        register (io.swagger.jaxrs.listing.SwaggerSerializers.class);

		
		BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("/RESTDB/api");
        beanConfig.setResourcePackage("solutions.egen");// could be ...rest.controller
        beanConfig.setTitle("RESTApi Documentation");
        beanConfig.setDescription("RESTApi for RESTDB");
        beanConfig.setScan(true);
	}
}
