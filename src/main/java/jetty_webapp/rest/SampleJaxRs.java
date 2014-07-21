
package jetty_webapp.rest;

import javax.json.Json;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * REST Web Service
 */
@Path("sample-jaxrs")
public class SampleJaxRs {

    @GET
    @Produces("text/plain")
    public String getText() {
        return "Hello JAX-RS";
    }

}
