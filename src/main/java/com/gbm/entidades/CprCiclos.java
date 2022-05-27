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
@Table(name = "cpr_ciclos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprCiclos.findAll", query = "SELECT c FROM CprCiclos c"),
    @NamedQuery(name = "CprCiclos.findByIdCiclo", query = "SELECT c FROM CprCiclos c WHERE c.idCiclo = :idCiclo"),
    @NamedQuery(name = "CprCiclos.findByDesCiclo", query = "SELECT c FROM CprCiclos c WHERE c.desCiclo = :desCiclo")})
public class CprCiclos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ciclo")
    private Integer idCiclo;
    @Size(max = 100)
    @Column(name = "des_ciclo")
    private String desCiclo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cprCiclos")
    private Collection<CprValoracionPracticantes> cprValoracionPracticantesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cprCiclos")
    private Collection<CprHistContenidoPracticante> cprHistContenidoPracticanteCollection;

    public CprCiclos() {
    }

    public CprCiclos(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getDesCiclo() {
        return desCiclo;
    }

    public void setDesCiclo(String desCiclo) {
        this.desCiclo = desCiclo;
    }

    @XmlTransient
    public Collection<CprValoracionPracticantes> getCprValoracionPracticantesCollection() {
        return cprValoracionPracticantesCollection;
    }

    public void setCprValoracionPracticantesCollection(Collection<CprValoracionPracticantes> cprValoracionPracticantesCollection) {
        this.cprValoracionPracticantesCollection = cprValoracionPracticantesCollection;
    }

    @XmlTransient
    public Collection<CprHistContenidoPracticante> getCprHistContenidoPracticanteCollection() {
        return cprHistContenidoPracticanteCollection;
    }

    public void setCprHistContenidoPracticanteCollection(Collection<CprHistContenidoPracticante> cprHistContenidoPracticanteCollection) {
        this.cprHistContenidoPracticanteCollection = cprHistContenidoPracticanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiclo != null ? idCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprCiclos)) {
            return false;
        }
        CprCiclos other = (CprCiclos) object;
        if ((this.idCiclo == null && other.idCiclo != null) || (this.idCiclo != null && !this.idCiclo.equals(other.idCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprCiclos[ idCiclo=" + idCiclo + " ]";
    }
    
}
