
package com.gbm.dao;

import com.gbm.entidades.CprValoracionPracticantes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprValoracionPracticantesFacade extends AbstractFacade<CprValoracionPracticantes> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprValoracionPracticantesFacade() {
        super(CprValoracionPracticantes.class);
    }
    
}
