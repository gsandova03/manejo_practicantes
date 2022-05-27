
package com.gbm.dao;

import com.gbm.entidades.CprContenido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprContenidoFacade extends AbstractFacade<CprContenido> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprContenidoFacade() {
        super(CprContenido.class);
    }
    
}
