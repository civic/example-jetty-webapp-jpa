package jetty_webapp.jpa.service;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import jetty_webapp.jpa.entity.Customer;

/**
 *
 */
@RequestScoped
public class MyService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addCustomer(String name){
        Customer c = new Customer();
        c.setCustomerName(name);

        em.persist(c);

    }

    public List<Customer> list(){
        return em.createNamedQuery("Customer.findAll").getResultList();
    }
}
