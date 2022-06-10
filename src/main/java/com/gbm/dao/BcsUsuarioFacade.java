
package com.gbm.dao;

import com.gbm.entidades.BcsUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class BcsUsuarioFacade extends AbstractFacade<BcsUsuario> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BcsUsuarioFacade() {
        super(BcsUsuario.class);
    }
    
    public BcsUsuario buscarUsuarioId(int id){
        return (BcsUsuario) em.createNamedQuery("BcsUsuario.findByCodUsuario").setParameter("codUsuario", id).getSingleResult();
    }
    
    public BcsUsuario buscarPorCc(String cc){
        return (BcsUsuario) em.createNamedQuery("BcsUsuario.findByCedUsuario")
                .setParameter("cedUsuario", cc)
                .getSingleResult();
    }
    
    public BcsUsuario buscarPorCorreoC(String cr){
        return (BcsUsuario) em.createNamedQuery("BcsUsuario.findByEmiCoorporativo")
                .setParameter("emiCoorporativo", cr)
                .getSingleResult();
    }
}
