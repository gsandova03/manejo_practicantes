
package com.gbm.dao;

import com.gbm.entidades.CprValoraciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprValoracionesFacade extends AbstractFacade<CprValoraciones> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprValoracionesFacade() {
        super(CprValoraciones.class);
    }
    
}
