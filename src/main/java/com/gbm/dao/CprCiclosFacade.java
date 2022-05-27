
package com.gbm.dao;

import com.gbm.entidades.CprCiclos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprCiclosFacade extends AbstractFacade<CprCiclos> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprCiclosFacade() {
        super(CprCiclos.class);
    }
    
}
