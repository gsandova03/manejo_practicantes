/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author jfilot
 */
@Entity
@Table(name = "bcs_genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcsGenero.findAll", query = "SELECT b FROM BcsGenero b"),
    @NamedQuery(name = "BcsGenero.findByIdGenero", query = "SELECT b FROM BcsGenero b WHERE b.idGenero = :idGenero"),
    @NamedQuery(name = "BcsGenero.findByDesGenero", query = "SELECT b FROM BcsGenero b WHERE b.desGenero = :desGenero")})
public class BcsGenero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_genero")
    private Integer idGenero;
    @Size(max = 100)
    @Column(name = "des_genero")
    private String desGenero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGenero")
    private Collection<CprPracticantes> cprPracticantesCollection;

    public BcsGenero() {
    }

    public BcsGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getDesGenero() {
        return desGenero;
    }

    public void setDesGenero(String desGenero) {
        this.desGenero = desGenero;
    }

    @XmlTransient
    public Collection<CprPracticantes> getCprPracticantesCollection() {
        return cprPracticantesCollection;
    }

    public void setCprPracticantesCollection(Collection<CprPracticantes> cprPracticantesCollection) {
        this.cprPracticantesCollection = cprPracticantesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenero != null ? idGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcsGenero)) {
            return false;
        }
        BcsGenero other = (BcsGenero) object;
        if ((this.idGenero == null && other.idGenero != null) || (this.idGenero != null && !this.idGenero.equals(other.idGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.BcsGenero[ idGenero=" + idGenero + " ]";
    }
    
}
