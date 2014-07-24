package jetty_webapp.websocket;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;
import jetty_webapp.jpa.service.CustomerService;

/**
 * WebSocket Endpoint
 */
@ServerEndpoint("/websocket")
public class SampleWSEndpoint {
    @Inject CustomerService service;

    @OnMessage
    public String onMessage(String message) {
        return message.toUpperCase() + service.all().get(0).getCustomerName();
    }
    
}
