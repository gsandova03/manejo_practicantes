
package com.gbm.dao;

import com.gbm.entidades.CprTipoPracticas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprTipoPracticasFacade extends AbstractFacade<CprTipoPracticas> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprTipoPracticasFacade() {
        super(CprTipoPracticas.class);
    }
    
}
