
package com.gbm.dao;

import com.gbm.entidades.CprInstituciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprInstitucionesFacade extends AbstractFacade<CprInstituciones> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprInstitucionesFacade() {
        super(CprInstituciones.class);
    }
    
}
