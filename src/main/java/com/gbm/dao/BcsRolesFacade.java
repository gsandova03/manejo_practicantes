
package com.gbm.dao;

import com.gbm.entidades.BcsRoles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class BcsRolesFacade extends AbstractFacade<BcsRoles> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BcsRolesFacade() {
        super(BcsRoles.class);
    }
    
}
