
package com.gbm.dao;

import com.gbm.entidades.CprHistContenidoPracticante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprHistContenidoPracticanteFacade extends AbstractFacade<CprHistContenidoPracticante> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprHistContenidoPracticanteFacade() {
        super(CprHistContenidoPracticante.class);
    }
    
}
