/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfilot
 */
@Entity
@Table(name = "bcs_bitacora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcsBitacora.findAll", query = "SELECT b FROM BcsBitacora b"),
    @NamedQuery(name = "BcsBitacora.findByIdBitacora", query = "SELECT b FROM BcsBitacora b WHERE b.idBitacora = :idBitacora"),
    @NamedQuery(name = "BcsBitacora.findByFecBitacora", query = "SELECT b FROM BcsBitacora b WHERE b.fecBitacora = :fecBitacora"),
    @NamedQuery(name = "BcsBitacora.findByTioTransaccion", query = "SELECT b FROM BcsBitacora b WHERE b.tioTransaccion = :tioTransaccion"),
    @NamedQuery(name = "BcsBitacora.findByDesTransaccion", query = "SELECT b FROM BcsBitacora b WHERE b.desTransaccion = :desTransaccion")})
public class BcsBitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bitacora")
    private Integer idBitacora;
    @Size(max = 45)
    @Column(name = "fec_bitacora")
    private String fecBitacora;
    @Size(max = 45)
    @Column(name = "tio_transaccion")
    private String tioTransaccion;
    @Size(max = 100)
    @Column(name = "des_transaccion")
    private String desTransaccion;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario")
    @ManyToOne
    private BcsUsuario codUsuario;

    public BcsBitacora() {
    }

    public BcsBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getFecBitacora() {
        return fecBitacora;
    }

    public void setFecBitacora(String fecBitacora) {
        this.fecBitacora = fecBitacora;
    }

    public String getTioTransaccion() {
        return tioTransaccion;
    }

    public void setTioTransaccion(String tioTransaccion) {
        this.tioTransaccion = tioTransaccion;
    }

    public String getDesTransaccion() {
        return desTransaccion;
    }

    public void setDesTransaccion(String desTransaccion) {
        this.desTransaccion = desTransaccion;
    }

    public BcsUsuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(BcsUsuario codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcsBitacora)) {
            return false;
        }
        BcsBitacora other = (BcsBitacora) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.BcsBitacora[ idBitacora=" + idBitacora + " ]";
    }
    
}
