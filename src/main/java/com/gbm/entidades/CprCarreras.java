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
@Table(name = "cpr_carreras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprCarreras.findAll", query = "SELECT c FROM CprCarreras c"),
    @NamedQuery(name = "CprCarreras.findByIdCarrera", query = "SELECT c FROM CprCarreras c WHERE c.idCarrera = :idCarrera"),
    @NamedQuery(name = "CprCarreras.findByDesCarrera", query = "SELECT c FROM CprCarreras c WHERE c.desCarrera = :desCarrera")})
public class CprCarreras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrera")
    private Integer idCarrera;
    @Size(max = 100)
    @Column(name = "des_carrera")
    private String desCarrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarrera")
    private Collection<CprPracticantes> cprPracticantesCollection;

    public CprCarreras() {
    }

    public CprCarreras(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getDesCarrera() {
        return desCarrera;
    }

    public void setDesCarrera(String desCarrera) {
        this.desCarrera = desCarrera;
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
        hash += (idCarrera != null ? idCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprCarreras)) {
            return false;
        }
        CprCarreras other = (CprCarreras) object;
        if ((this.idCarrera == null && other.idCarrera != null) || (this.idCarrera != null && !this.idCarrera.equals(other.idCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprCarreras[ idCarrera=" + idCarrera + " ]";
    }
    
}
