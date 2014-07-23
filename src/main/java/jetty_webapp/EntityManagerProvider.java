package jetty_webapp;

import com.google.inject.Inject;
import com.google.inject.Provider;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 * EntityManagerのInject用Provider.
 * フィルタでリクエスト属性に設定したEntityManagerを取得するGuice Provider
 */
public class EntityManagerProvider implements Provider<EntityManager>{
    @Inject
    private HttpServletRequest request;

    public EntityManagerProvider() {
        System.out.println("create provider.");
    }

    @Override
    public EntityManager get() {

        return (EntityManager) request.getAttribute("_entity.manager");
    }
    
}
