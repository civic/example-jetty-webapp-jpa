package jetty_webapp.jpa;

import java.io.IOException;
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
import jetty_webapp.jpa.entity.Customer;

/**
 * jetty上のwebappからJPAを使用したサーブレット
 */
@WebServlet("/jpa-servlet")
public class SampleJPAServlet extends HttpServlet {
    @PersistenceUnit(unitName = "webapp-jpa-pu")
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        //アノテーションからは取れないのでコードで取得
        //emf = Persistence.createEntityManagerFactory("webapp-jpa-pu");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();

            //Customerの追加
            Customer customer = new Customer();
            customer.setCustomerName("c-"+ System.currentTimeMillis());

            em.persist(customer);


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
