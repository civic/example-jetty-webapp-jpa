package jetty_webapp.websocket;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * WebSocket Endpoint
 */
@ServerEndpoint(value="/websocket")
public class SampleWSEndpoint {

    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
    }


    @OnMessage
    public String onMessage(String message) {
        return message.toUpperCase();
    }
    
}
