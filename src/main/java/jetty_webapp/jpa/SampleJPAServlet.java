package jetty_webapp.jpa;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jetty_webapp.jpa.entity.Customer;

/**
 * jetty上のwebappからJPAを使用したサーブレット
 */
@Singleton
public class SampleJPAServlet extends HttpServlet {
    @Inject
    private Injector injector;

    @Override
    public void init() throws ServletException {
        //アノテーションからは取れないのでコードで取得
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = injector.getInstance(EntityManager.class);

        //Customerの追加
        Customer customer = new Customer();
        customer.setCustomerName("c-"+ System.currentTimeMillis());

        em.persist(customer);

        //Customerの検索
        for (Customer c : em.createNamedQuery("Customer.findAll", Customer.class).getResultList()){
            resp.getWriter().println(c);
        }
    }
    
}
