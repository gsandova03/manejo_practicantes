/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gsandoval
 */
@Entity
@Table(name = "cpr_tipo_practicas", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprTipoPracticas.findAll", query = "SELECT c FROM CprTipoPracticas c"),
    @NamedQuery(name = "CprTipoPracticas.findByIdPractica", query = "SELECT c FROM CprTipoPracticas c WHERE c.idPractica = :idPractica"),
    @NamedQuery(name = "CprTipoPracticas.findByDesPractica", query = "SELECT c FROM CprTipoPracticas c WHERE c.desPractica = :desPractica")})
public class CprTipoPracticas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_practica", nullable = false)
    private Integer idPractica;
    @Size(max = 45)
    @Column(name = "des_practica", length = 45)
    private String desPractica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPractica", fetch = FetchType.LAZY)
    private List<CprPracticantes> cprPracticantesList;

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
    public List<CprPracticantes> getCprPracticantesList() {
        return cprPracticantesList;
    }

    public void setCprPracticantesList(List<CprPracticantes> cprPracticantesList) {
        this.cprPracticantesList = cprPracticantesList;
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
