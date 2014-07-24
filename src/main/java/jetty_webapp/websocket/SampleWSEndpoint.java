package jetty_webapp.websocket;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import jetty_webapp.jpa.service.CustomerService;

/**
 * WebSocket Endpoint
 */
@ServerEndpoint("/websocket")
public class SampleWSEndpoint {
    @OnOpen
    public void onOpen(){
        System.out.println("websocket opened");
    }

    @OnMessage
    public String onMessage(String message) throws Exception{

        //CustomerService と EntityManagerをWebSocketEndpointで使う方法は要検討
        // WebSocket用のPersistenceUnitをRESOURCE_LOCALで作成して、自前で管理する方法がよいか？

        String ret = message.toUpperCase();

        return ret;
    }

}
