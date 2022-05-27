
package com.gbm.dao;

import com.gbm.entidades.BscLogin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class BscLoginFacade extends AbstractFacade<BscLogin> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BscLoginFacade() {
        super(BscLogin.class);
    }
    
}
