package jetty_webapp.rest;

import com.google.inject.Singleton;
import org.glassfish.jersey.servlet.ServletContainer;


/**
 * Guice化にJerseyのServletContainerを置くために、Singletonアノテーションを付けたただけ
 */
@Singleton
public class SingletonServletContainer extends ServletContainer{
    
}
