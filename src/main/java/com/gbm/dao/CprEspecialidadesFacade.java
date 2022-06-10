
package com.gbm.dao;

import com.gbm.entidades.CprEspecialidades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprEspecialidadesFacade extends AbstractFacade<CprEspecialidades> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprEspecialidadesFacade() {
        super(CprEspecialidades.class);
    }
    
}
