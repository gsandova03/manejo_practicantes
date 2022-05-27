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
@Table(name = "cpr_contenido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprContenido.findAll", query = "SELECT c FROM CprContenido c"),
    @NamedQuery(name = "CprContenido.findByIdContenido", query = "SELECT c FROM CprContenido c WHERE c.idContenido = :idContenido"),
    @NamedQuery(name = "CprContenido.findByDesContenido", query = "SELECT c FROM CprContenido c WHERE c.desContenido = :desContenido")})
public class CprContenido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contenido")
    private Integer idContenido;
    @Size(max = 100)
    @Column(name = "des_contenido")
    private String desContenido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cprContenido")
    private Collection<CprHistContenidoPracticante> cprHistContenidoPracticanteCollection;

    public CprContenido() {
    }

    public CprContenido(Integer idContenido) {
        this.idContenido = idContenido;
    }

    public Integer getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(Integer idContenido) {
        this.idContenido = idContenido;
    }

    public String getDesContenido() {
        return desContenido;
    }

    public void setDesContenido(String desContenido) {
        this.desContenido = desContenido;
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
        hash += (idContenido != null ? idContenido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprContenido)) {
            return false;
        }
        CprContenido other = (CprContenido) object;
        if ((this.idContenido == null && other.idContenido != null) || (this.idContenido != null && !this.idContenido.equals(other.idContenido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprContenido[ idContenido=" + idContenido + " ]";
    }
    
}
