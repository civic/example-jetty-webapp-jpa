
package jetty_webapp.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import jetty_webapp.jpa.entity.Customer;
import jetty_webapp.jpa.service.MyService;

/**
 * REST Web Service
 */
@Path("sample-jaxrs")
@RequestScoped
public class SampleJaxRs {
    @Inject
    private MyService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getText() {
        return Json.createObjectBuilder().add("foo", 100).build();
    }
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getList() {

        return service.list();
    }
    @GET
    @Path("cust/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addCustomer(@PathParam("name") String n) {

        service.addCustomer(n);

        return "{}";
    }
}
