/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.dao;

import com.gbm.entidades.CprContenido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jfilot
 */
@Stateless
public class CprContenidoFacade extends AbstractFacade<CprContenido> {

    @PersistenceContext(unitName = "mydb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CprContenidoFacade() {
        super(CprContenido.class);
    }
    
}
