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
@Table(name = "cpr_instituciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprInstituciones.findAll", query = "SELECT c FROM CprInstituciones c"),
    @NamedQuery(name = "CprInstituciones.findByIdInstitucion", query = "SELECT c FROM CprInstituciones c WHERE c.idInstitucion = :idInstitucion"),
    @NamedQuery(name = "CprInstituciones.findByDesInstitucion", query = "SELECT c FROM CprInstituciones c WHERE c.desInstitucion = :desInstitucion")})
public class CprInstituciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_institucion")
    private Integer idInstitucion;
    @Size(max = 100)
    @Column(name = "des_institucion")
    private String desInstitucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitucion")
    private Collection<CprPracticantes> cprPracticantesCollection;

    public CprInstituciones() {
    }

    public CprInstituciones(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getDesInstitucion() {
        return desInstitucion;
    }

    public void setDesInstitucion(String desInstitucion) {
        this.desInstitucion = desInstitucion;
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
        hash += (idInstitucion != null ? idInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprInstituciones)) {
            return false;
        }
        CprInstituciones other = (CprInstituciones) object;
        if ((this.idInstitucion == null && other.idInstitucion != null) || (this.idInstitucion != null && !this.idInstitucion.equals(other.idInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprInstituciones[ idInstitucion=" + idInstitucion + " ]";
    }
    
}
