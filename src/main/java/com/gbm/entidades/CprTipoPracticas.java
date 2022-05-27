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
@Table(name = "cpr_tipo_practicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprTipoPracticas.findAll", query = "SELECT c FROM CprTipoPracticas c"),
    @NamedQuery(name = "CprTipoPracticas.findByIdPractica", query = "SELECT c FROM CprTipoPracticas c WHERE c.idPractica = :idPractica"),
    @NamedQuery(name = "CprTipoPracticas.findByDesPractica", query = "SELECT c FROM CprTipoPracticas c WHERE c.desPractica = :desPractica")})
public class CprTipoPracticas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_practica")
    private Integer idPractica;
    @Size(max = 45)
    @Column(name = "des_practica")
    private String desPractica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPractica")
    private Collection<CprPracticantes> cprPracticantesCollection;

    public CprTipoPracticas() {
    }

    public CprTipoPracticas(Integer idPractica) {
        this.idPractica = idPractica;
    }

    public Integer getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(Integer idPractica) {
        this.idPractica = idPractica;
    }

    public String getDesPractica() {
        return desPractica;
    }

    public void setDesPractica(String desPractica) {
        this.desPractica = desPractica;
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
        hash += (idPractica != null ? idPractica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprTipoPracticas)) {
            return false;
        }
        CprTipoPracticas other = (CprTipoPracticas) object;
        if ((this.idPractica == null && other.idPractica != null) || (this.idPractica != null && !this.idPractica.equals(other.idPractica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprTipoPracticas[ idPractica=" + idPractica + " ]";
    }
    
}
