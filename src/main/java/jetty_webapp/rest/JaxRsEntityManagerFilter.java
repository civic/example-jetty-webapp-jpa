package jetty_webapp.rest;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 */
@Provider
public class JaxRsEntityManagerFilter implements ContainerRequestFilter, ContainerResponseFilter
{
    private EntityManagerFactory emf;

    public JaxRsEntityManagerFilter() {
        emf = Persistence.createEntityManagerFactory("webapp-jpa-pu");
    }

    @Override
    public void filter(ContainerRequestContext crc) throws IOException {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        crc.setProperty("_entity.manager", em);
        crc.setProperty("_entity.transaction", tx);


    }

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
        EntityTransaction tx = (EntityTransaction) crc.getProperty("_entity.transaction");
        EntityManager em = (EntityManager) crc.getProperty("_entity.manager");

        tx.commit();
        em.close();

    }
    
}
