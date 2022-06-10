
package com.gbm.dao;

import com.gbm.entidades.CprCarreras;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprCarrerasFacade extends AbstractFacade<CprCarreras> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprCarrerasFacade() {
        super(CprCarreras.class);
    }
    
}
