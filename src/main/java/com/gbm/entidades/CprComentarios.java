/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gsandoval
 */
@Entity
@Table(name = "cpr_comentarios", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprComentarios.findAll", query = "SELECT c FROM CprComentarios c"),
    @NamedQuery(name = "CprComentarios.findByIdComentarios", query = "SELECT c FROM CprComentarios c WHERE c.idComentarios = :idComentarios"),
    @NamedQuery(name = "CprComentarios.findByDesComentario", query = "SELECT c FROM CprComentarios c WHERE c.desComentario = :desComentario"),
    @NamedQuery(name = "CprComentarios.findByFecComentario", query = "SELECT c FROM CprComentarios c WHERE c.fecComentario = :fecComentario")})
public class CprComentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comentarios", nullable = false)
    private Integer idComentarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "des_comentario", nullable = false, length = 100)
    private String desComentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fec_comentario", nullable = false, length = 45)
    private String fecComentario;
    @JoinColumn(name = "id_usuario_crea_comentario", referencedColumnName = "cod_usuario", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BcsUsuario idUsuarioCreaComentario;
    @JoinColumn(name = "cod_usuario_comentario", referencedColumnName = "cod_usuario_pract", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprPracticantes codUsuarioComentario;

    public CprComentarios() {
    }

    public CprComentarios(Integer idComentarios) {
        this.idComentarios = idComentarios;
    }

    public CprComentarios(Integer idComentarios, String desComentario, String fecComentario) {
        this.idComentarios = idComentarios;
        this.desComentario = desComentario;
        this.fecComentario = fecComentario;
    }

    public Integer getIdComentarios() {
        return idComentarios;
    }

    public void setIdComentarios(Integer idComentarios) {
        this.idComentarios = idComentarios;
    }

    public String getDesComentario() {
        return desComentario;
    }

    public void setDesComentario(String desComentario) {
        this.desComentario = desComentario;
    }

    public String getFecComentario() {
        return fecComentario;
    }

    public void setFecComentario(String fecComentario) {
        this.fecComentario = fecComentario;
    }

    public BcsUsuario getIdUsuarioCreaComentario() {
        return idUsuarioCreaComentario;
    }

    public void setIdUsuarioCreaComentario(BcsUsuario idUsuarioCreaComentario) {
        this.idUsuarioCreaComentario = idUsuarioCreaComentario;
    }

    public CprPracticantes getCodUsuarioComentario() {
        return codUsuarioComentario;
    }

    public void setCodUsuarioComentario(CprPracticantes codUsuarioComentario) {
        this.codUsuarioComentario = codUsuarioComentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentarios != null ? idComentarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprComentarios)) {
            return false;
        }
        CprComentarios other = (CprComentarios) object;
        if ((this.idComentarios == null && other.idComentarios != null) || (this.idComentarios != null && !this.idComentarios.equals(other.idComentarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprComentarios[ idComentarios=" + idComentarios + " ]";
    }
    
}
