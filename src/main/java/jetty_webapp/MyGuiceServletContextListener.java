/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jetty_webapp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebListener;
import jetty_webapp.jpa.SampleJPAServlet;
import jetty_webapp.rest.JaxRsEntityManagerFilter;
import jetty_webapp.rest.SampleJaxRs;
import jetty_webapp.servlet.SampleServlet;

/**
 *
 * @author tsasaki
 */
@WebListener
public class MyGuiceServletContextListener extends GuiceServletContextListener{

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyServletModule(){

            @Override
            protected void configureServlets() {
                //filter("/*").through(MyFilter.class);

                serve("/jpa-servlet").with(SampleJPAServlet.class);
                serve("/sample").with(SampleServlet.class);
                serve("/rest/*").with(GuiceContainer.class);
 
                bind(SampleJaxRs.class);
                bind(JaxRsEntityManagerFilter.class);
                bind(ServletContainer.class);

                bind(EntityManager.class).toProvider(EntityManagerProvider.class);

            }

            
       });
    }
    
}
