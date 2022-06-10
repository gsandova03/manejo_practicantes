
package com.gbm.dao;

import com.gbm.entidades.BcsBitacora;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class BcsBitacoraFacade extends AbstractFacade<BcsBitacora> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BcsBitacoraFacade() {
        super(BcsBitacora.class);
    }
    
}
