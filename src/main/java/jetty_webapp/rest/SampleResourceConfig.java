package jetty_webapp.rest;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * REST Resourceの探索用 App
 */
public class SampleResourceConfig extends ResourceConfig{

    public SampleResourceConfig() {
        packages(false, "jetty_webapp.rest");
    }
    

}
