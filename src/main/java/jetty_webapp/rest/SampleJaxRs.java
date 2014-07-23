
package jetty_webapp.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import jetty_webapp.jpa.entity.Customer;
import jetty_webapp.jpa.service.MyService;

/**
 * REST Web Service
 */
@Path("sample-jaxrs")
public class SampleJaxRs {
    @Inject
    private MyService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getText() {
        return Json.createObjectBuilder().add("foo", 100).build();
    }
    /*
    @GET
    @Path("cust")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomer() {
        service.addCustomer("hoge");

        return service.list();
    }
    */
}
