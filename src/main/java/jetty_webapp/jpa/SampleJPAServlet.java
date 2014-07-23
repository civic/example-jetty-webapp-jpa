package jetty_webapp.jpa;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
import jetty_webapp.jpa.service.MyService;

/**
 * jetty上のwebappからJPAを使用したサーブレット
 */
@WebServlet("/jpa-servlet")
public class SampleJPAServlet extends HttpServlet {
    @Inject
    private MyService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        service.addCustomer("hoge");

        //Customerの一覧取得
        for (Customer c : service.list()){
            resp.getWriter().println(c);
        }

    }
    
}
