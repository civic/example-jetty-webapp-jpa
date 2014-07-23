package jetty_webapp;

import jetty_webapp.rest.SingletonServletContainer;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebListener;

/**
 * GuiceServlet用のContextListener
 */
@WebListener
public class MyGuiceServletContextListener extends GuiceServletContextListener{
    public static Injector injector;

    @Override
    protected Injector getInjector() {
        injector = Guice.createInjector(new ServletModule(){

            @Override
            protected void configureServlets() {
                filter("/rest/*", "/websocket").through(MyEntityManagerFilter.class);

                Map params = new HashMap();
                params.put("javax.ws.rs.Application", "jetty_webapp.rest.SampleResourceConfig");

                serve("/rest/*").with(SingletonServletContainer.class, params);

                bind(EntityManager.class).toProvider(EntityManagerProvider.class);
            }
            
        });
        return injector;
    }
    
}
