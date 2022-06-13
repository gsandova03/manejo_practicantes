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
@Table(name = "bcs_roles", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcsRoles.findAll", query = "SELECT b FROM BcsRoles b"),
    @NamedQuery(name = "BcsRoles.findByIdRol", query = "SELECT b FROM BcsRoles b WHERE b.idRol = :idRol"),
    @NamedQuery(name = "BcsRoles.findByNomRol", query = "SELECT b FROM BcsRoles b WHERE b.nomRol = :nomRol")})
public class BcsRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;
    @Size(max = 100)
    @Column(name = "nom_rol", length = 100)
    private String nomRol;
    @OneToMany(mappedBy = "idRol", fetch = FetchType.LAZY)
    private List<BcsUsuario> bcsUsuarioList;

    public BcsRoles() {
    }

    public BcsRoles(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
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
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcsRoles)) {
            return false;
        }
        BcsRoles other = (BcsRoles) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.BcsRoles[ idRol=" + idRol + " ]";
    }
    
}
