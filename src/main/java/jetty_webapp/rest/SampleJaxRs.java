
package jetty_webapp.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import jetty_webapp.jpa.entity.Customer;
import jetty_webapp.jpa.service.CustomerService;

/**
 * REST Web Service
 */
@Path("customers")
@RequestScoped
public class SampleJaxRs {
    @Inject
    private CustomerService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getList() {

        List<Customer> list = service.all();
        return list;
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getOneCustomer(@PathParam("id") Integer id) {

        return service.getById(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer addCustomer(@FormParam("name") String customerName) {

        Customer c = service.addNewCustomer(customerName);

        return c;
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject deleteCustomers() {

        int count = service.deleteAllCustomers();

        return Json.createObjectBuilder().add("count", count).build();
    }
}
