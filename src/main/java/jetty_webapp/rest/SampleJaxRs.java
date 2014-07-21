
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
    @Produces("application/json")
    public String getJson() {
        return Json.createObjectBuilder().add("foobar", "123").build().toString();
    }

}
