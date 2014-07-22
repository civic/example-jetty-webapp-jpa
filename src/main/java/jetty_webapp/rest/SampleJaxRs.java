
package jetty_webapp.rest;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Date;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import jetty_webapp.jpa.entity.Customer;

/**
 * REST Web Service
 */
@Path("sample-jaxrs")
public class SampleJaxRs {
    @Context private HttpServletRequest request;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getText() {

        return Json.createObjectBuilder().add("foo", 100).build();//new Customer(123);
    }

    @GET
    @Path("cust")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomer() {
        EntityManager em = getInjector().getInstance(EntityManager.class);
        {
            Customer c = new Customer();
            c.setCustomerName(new Date().toString());

            em.persist(c);

        }

        List<Customer> list = em.createNamedQuery("Customer.findAll").getResultList();

        /*
        {
            Customer c = new Customer();
            c.setCustomerName(new Date().toString());
            c.setCustomerId(1);
            em.persist(c);
        }
        */
        return list;
    }

    public Injector getInjector(){
        return (Injector)request.getServletContext().getAttribute(Injector.class.getName());

    }
}
