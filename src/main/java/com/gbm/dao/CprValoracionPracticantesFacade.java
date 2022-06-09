package com.gbm.dao;

import com.gbm.entidades.CprValoracionPracticantes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public List<CprValoracionPracticantes> obtenerCantidadValoracion(int ciclo, String valoracion) {
        return (List<CprValoracionPracticantes>) em.createNamedQuery("CprValoracionPracticantes.contardorValoracion")
                .setParameter("idCiclo", ciclo)
                .setParameter("idValoracion", valoracion)
                .getResultList();
    }
    
//    public CprValoracionPracticantes obtenerCantidadValoracion() {
//        return (CprValoracionPracticantes) em.createNamedQuery("CprValoracionPracticantes.findAll");
//    }
}
