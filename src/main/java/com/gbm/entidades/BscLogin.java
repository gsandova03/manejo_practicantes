/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gsandoval
 */
@Entity
@Table(name = "bsc_login", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BscLogin.findAll", query = "SELECT b FROM BscLogin b"),
    @NamedQuery(name = "BscLogin.findByIdLogin", query = "SELECT b FROM BscLogin b WHERE b.idLogin = :idLogin"),
    @NamedQuery(name = "BscLogin.findByEmiCorporativo", query = "SELECT b FROM BscLogin b WHERE b.emiCorporativo = :emiCorporativo"),
    @NamedQuery(name = "BscLogin.findByPswUsuario", query = "SELECT b FROM BscLogin b WHERE b.pswUsuario = :pswUsuario")})
public class BscLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_login", nullable = false)
    private Integer idLogin;
    @Size(max = 45)
    @Column(name = "emi_corporativo", length = 45)
    private String emiCorporativo;
    @Size(max = 45)
    @Column(name = "psw_usuario", length = 45)
    private String pswUsuario;
    @OneToMany(mappedBy = "idLoginUsuario", fetch = FetchType.LAZY)
    private List<BcsUsuario> bcsUsuarioList;

    public BscLogin() {
    }

    public BscLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getEmiCorporativo() {
        return emiCorporativo;
    }

    public void setEmiCorporativo(String emiCorporativo) {
        this.emiCorporativo = emiCorporativo;
    }

    public String getPswUsuario() {
        return pswUsuario;
    }

    public void setPswUsuario(String pswUsuario) {
        this.pswUsuario = pswUsuario;
    }

    @XmlTransient
    public List<BcsUsuario> getBcsUsuarioList() {
        return bcsUsuarioList;
    }

    public void setBcsUsuarioList(List<BcsUsuario> bcsUsuarioList) {
        this.bcsUsuarioList = bcsUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogin != null ? idLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BscLogin)) {
            return false;
        }
        BscLogin other = (BscLogin) object;
        if ((this.idLogin == null && other.idLogin != null) || (this.idLogin != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.BscLogin[ idLogin=" + idLogin + " ]";
    }
    
}
