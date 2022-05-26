/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gsandoval
 */
@Entity
@Table(name = "cpr_hist_contenido_practicante", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprHistContenidoPracticante.findAll", query = "SELECT c FROM CprHistContenidoPracticante c"),
    @NamedQuery(name = "CprHistContenidoPracticante.findByIdCicloHist", query = "SELECT c FROM CprHistContenidoPracticante c WHERE c.cprHistContenidoPracticantePK.idCicloHist = :idCicloHist"),
    @NamedQuery(name = "CprHistContenidoPracticante.findByIdContenido", query = "SELECT c FROM CprHistContenidoPracticante c WHERE c.cprHistContenidoPracticantePK.idContenido = :idContenido"),
    @NamedQuery(name = "CprHistContenidoPracticante.findByCodUsuarioHist", query = "SELECT c FROM CprHistContenidoPracticante c WHERE c.cprHistContenidoPracticantePK.codUsuarioHist = :codUsuarioHist")})
public class CprHistContenidoPracticante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CprHistContenidoPracticantePK cprHistContenidoPracticantePK;
    @JoinColumn(name = "cod_usuario_hist", referencedColumnName = "cod_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BcsUsuario bcsUsuario;
    @JoinColumn(name = "id_ciclo_hist", referencedColumnName = "id_ciclo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprCiclos cprCiclos;
    @JoinColumn(name = "id_contenido", referencedColumnName = "id_contenido", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprContenido cprContenido;

    public CprHistContenidoPracticante() {
    }

    public CprHistContenidoPracticante(CprHistContenidoPracticantePK cprHistContenidoPracticantePK) {
        this.cprHistContenidoPracticantePK = cprHistContenidoPracticantePK;
    }

    public CprHistContenidoPracticante(int idCicloHist, int idContenido, int codUsuarioHist) {
        this.cprHistContenidoPracticantePK = new CprHistContenidoPracticantePK(idCicloHist, idContenido, codUsuarioHist);
    }

    public CprHistContenidoPracticantePK getCprHistContenidoPracticantePK() {
        return cprHistContenidoPracticantePK;
    }

    public void setCprHistContenidoPracticantePK(CprHistContenidoPracticantePK cprHistContenidoPracticantePK) {
        this.cprHistContenidoPracticantePK = cprHistContenidoPracticantePK;
    }

    public BcsUsuario getBcsUsuario() {
        return bcsUsuario;
    }

    public void setBcsUsuario(BcsUsuario bcsUsuario) {
        this.bcsUsuario = bcsUsuario;
    }

    public CprCiclos getCprCiclos() {
        return cprCiclos;
    }

    public void setCprCiclos(CprCiclos cprCiclos) {
        this.cprCiclos = cprCiclos;
    }

    public CprContenido getCprContenido() {
        return cprContenido;
    }

    public void setCprContenido(CprContenido cprContenido) {
        this.cprContenido = cprContenido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cprHistContenidoPracticantePK != null ? cprHistContenidoPracticantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprHistContenidoPracticante)) {
            return false;
        }
        CprHistContenidoPracticante other = (CprHistContenidoPracticante) object;
        if ((this.cprHistContenidoPracticantePK == null && other.cprHistContenidoPracticantePK != null) || (this.cprHistContenidoPracticantePK != null && !this.cprHistContenidoPracticantePK.equals(other.cprHistContenidoPracticantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprHistContenidoPracticante[ cprHistContenidoPracticantePK=" + cprHistContenidoPracticantePK + " ]";
    }
    
}
