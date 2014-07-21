package jetty_webapp.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 * WebSocket Endpoint
 */
@ServerEndpoint("/websocket")
public class SampleWSEndpoint {

    @OnMessage
    public String onMessage(String message) {
        return message.toUpperCase();
    }
    
}
