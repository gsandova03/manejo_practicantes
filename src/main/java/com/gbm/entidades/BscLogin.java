/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfilot
 */
@Entity
@Table(name = "bsc_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BscLogin.findAll", query = "SELECT b FROM BscLogin b"),
    @NamedQuery(name = "BscLogin.findByIdLogin", query = "SELECT b FROM BscLogin b WHERE b.bscLoginPK.idLogin = :idLogin"),
    @NamedQuery(name = "BscLogin.findByCodUsuario", query = "SELECT b FROM BscLogin b WHERE b.bscLoginPK.codUsuario = :codUsuario")})
public class BscLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BscLoginPK bscLoginPK;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BcsUsuario bcsUsuario;

    public BscLogin() {
    }

    public BscLogin(BscLoginPK bscLoginPK) {
        this.bscLoginPK = bscLoginPK;
    }

    public BscLogin(int idLogin, int codUsuario) {
        this.bscLoginPK = new BscLoginPK(idLogin, codUsuario);
    }

    public BscLoginPK getBscLoginPK() {
        return bscLoginPK;
    }

    public void setBscLoginPK(BscLoginPK bscLoginPK) {
        this.bscLoginPK = bscLoginPK;
    }

    public BcsUsuario getBcsUsuario() {
        return bcsUsuario;
    }

    public void setBcsUsuario(BcsUsuario bcsUsuario) {
        this.bcsUsuario = bcsUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bscLoginPK != null ? bscLoginPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BscLogin)) {
            return false;
        }
        BscLogin other = (BscLogin) object;
        if ((this.bscLoginPK == null && other.bscLoginPK != null) || (this.bscLoginPK != null && !this.bscLoginPK.equals(other.bscLoginPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.BscLogin[ bscLoginPK=" + bscLoginPK + " ]";
    }
    
}
