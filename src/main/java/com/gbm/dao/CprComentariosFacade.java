
package com.gbm.dao;

import com.gbm.entidades.CprComentarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprComentariosFacade extends AbstractFacade<CprComentarios> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprComentariosFacade() {
        super(CprComentarios.class);
    }
    
}
