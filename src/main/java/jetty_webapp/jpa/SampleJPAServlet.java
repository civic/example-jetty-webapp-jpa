package jetty_webapp.jpa;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import jetty_webapp.jpa.entity.Customer;

/**
 * jetty上のwebappからJPAを使用したサーブレット
 */
@WebServlet("/jpa-servlet")
public class SampleJPAServlet extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = null;
        try {
            //Customerの追加
            em = emf.createEntityManager();
            Customer customer = new Customer();
            customer.setCustomerName("c-"+ System.currentTimeMillis());
            
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(customer);
            
            tx.commit();

            //Customerの検索
            for (Customer c : em.createNamedQuery("Customer.findAll", Customer.class).getResultList()){
                resp.getWriter().println(c);
            }
        } finally {
            if (em != null){
                em.close();
            }
        }
    }
    
}
