/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jetty_webapp;

import com.google.inject.Singleton;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * EntityManagerをリクエストオブジェクトに設定するフィルタ
 */
@Singleton
public class MyEntityManagerFilter implements Filter{
    private EntityManagerFactory emf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        emf = Persistence.createEntityManagerFactory("webapp-jpa-pu");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        request.setAttribute("_entity.manager", em);

        try {
            chain.doFilter(request, response);

            tx.commit();
        } catch (IOException | ServletException th){
            tx.rollback();
            throw th;
        } finally {
            em.close();
        }
    }

    @Override
    public void destroy() {
        emf.close();
    }
    
}
