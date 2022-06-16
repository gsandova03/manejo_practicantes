
package com.gbm.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class CprHistContenidoPracticantePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciclo_hist", nullable = false)
    private int idCicloHist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_pract_hist", nullable = false)
    private int codUsuarioHist;

    public CprHistContenidoPracticantePK() {
    }

    public CprHistContenidoPracticantePK(int idCicloHist, int codUsuarioHist) {
        this.idCicloHist = idCicloHist;
        this.codUsuarioHist = codUsuarioHist;
    }

    public int getIdCicloHist() {
        return idCicloHist;
    }

    public void setIdCicloHist(int idCicloHist) {
        this.idCicloHist = idCicloHist;
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
        if (this.codUsuarioHist != other.codUsuarioHist) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprHistContenidoPracticantePK[ idCicloHist=" + idCicloHist + ", codUsuarioHist=" + codUsuarioHist + " ]";
    }
    
}
