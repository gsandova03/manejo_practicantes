/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gsandoval
 */
@Embeddable
public class CprHistContenidoPracticantePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciclo_hist", nullable = false)
    private int idCicloHist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contenido", nullable = false)
    private int idContenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usuario_hist", nullable = false)
    private int codUsuarioHist;

    public CprHistContenidoPracticantePK() {
    }

    public CprHistContenidoPracticantePK(int idCicloHist, int idContenido, int codUsuarioHist) {
        this.idCicloHist = idCicloHist;
        this.idContenido = idContenido;
        this.codUsuarioHist = codUsuarioHist;
    }

    public int getIdCicloHist() {
        return idCicloHist;
    }

    public void setIdCicloHist(int idCicloHist) {
        this.idCicloHist = idCicloHist;
    }

    public int getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(int idContenido) {
        this.idContenido = idContenido;
    }

    public int getCodUsuarioHist() {
        return codUsuarioHist;
    }

    public void setCodUsuarioHist(int codUsuarioHist) {
        this.codUsuarioHist = codUsuarioHist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCicloHist;
        hash += (int) idContenido;
        hash += (int) codUsuarioHist;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprHistContenidoPracticantePK)) {
            return false;
        }
        CprHistContenidoPracticantePK other = (CprHistContenidoPracticantePK) object;
        if (this.idCicloHist != other.idCicloHist) {
            return false;
        }
        if (this.idContenido != other.idContenido) {
            return false;
        }
        if (this.codUsuarioHist != other.codUsuarioHist) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprHistContenidoPracticantePK[ idCicloHist=" + idCicloHist + ", idContenido=" + idContenido + ", codUsuarioHist=" + codUsuarioHist + " ]";
    }
    
}
