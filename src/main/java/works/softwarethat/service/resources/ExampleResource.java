package works.softwarethat.service.resources;

import works.softwarethat.service.persistence.DatabaseInitializer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Example resource.
 *
 * @author mortena@gmail.com
 */
@Path("/example")
@ApplicationScoped
public class ExampleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok(new HelloWorld()).build();
    }

    private class HelloWorld {
        private String hello = "world";
    }
}
