
package com.gbm.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class CprValoracionPracticantesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciclo_val", nullable = false)
    private int idCicloVal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usuario", nullable = false)
    private int codUsuario;

    public CprValoracionPracticantesPK() {
    }

    public CprValoracionPracticantesPK(int idCicloVal, int codUsuario) {
        this.idCicloVal = idCicloVal;
        this.codUsuario = codUsuario;
    }

    public int getIdCicloVal() {
        return idCicloVal;
    }

    public void setIdCicloVal(int idCicloVal) {
        this.idCicloVal = idCicloVal;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCicloVal;
        hash += (int) codUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprValoracionPracticantesPK)) {
            return false;
        }
        CprValoracionPracticantesPK other = (CprValoracionPracticantesPK) object;
        if (this.idCicloVal != other.idCicloVal) {
            return false;
        }
        if (this.codUsuario != other.codUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprValoracionPracticantesPK[ idCicloVal=" + idCicloVal + ", codUsuario=" + codUsuario + " ]";
    }
    
}
