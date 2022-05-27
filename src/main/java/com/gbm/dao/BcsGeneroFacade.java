
package com.gbm.dao;

import com.gbm.entidades.BcsGenero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class BcsGeneroFacade extends AbstractFacade<BcsGenero> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BcsGeneroFacade() {
        super(BcsGenero.class);
    }
    
}
