/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jetty_webapp;

import com.google.inject.Inject;
import com.google.inject.Provider;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author tsasaki
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
