
package com.gbm.dao;

import com.gbm.entidades.BcsEstados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class BcsEstadosFacade extends AbstractFacade<BcsEstados> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BcsEstadosFacade() {
        super(BcsEstados.class);
    }
    
}
