
package jetty_webapp.rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 */
@Path("sample-jaxrs")
public class SampleJaxRs {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getText() {
        return Json.createObjectBuilder().add("foo", 100).build();
    }

}
