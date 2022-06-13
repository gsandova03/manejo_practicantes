package com.gbm.dao;

import com.gbm.entidades.CprPracticantes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CprPracticantesFacade extends AbstractFacade<CprPracticantes> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprPracticantesFacade() {
        super(CprPracticantes.class);
    }

    public CprPracticantes buscarPorCodigo(Integer cod) {
        return (CprPracticantes) em.createNamedQuery("CprPracticantes.findByCodUsuarioPract")
                .setParameter("codUsuarioPract", cod)
                .getSingleResult();
    }
}
