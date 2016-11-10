package dk.mortangoda.service.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * Filter that set Accept header to application/json. This is just to make it easy to use in a browser.
 *
 * @author mortena@gmail.com
 */
@Provider
public class AlwaysAcceptApplicationJsonFilter implements ContainerRequestFilter {
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("Accept", MediaType.APPLICATION_JSON);
    }
}
