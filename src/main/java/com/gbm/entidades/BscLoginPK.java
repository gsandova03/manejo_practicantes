
package com.gbm.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class BscLoginPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_login", nullable = false)
    private int idLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usuario", nullable = false)
    private int codUsuario;

    public BscLoginPK() {
    }

    public BscLoginPK(int idLogin, int codUsuario) {
        this.idLogin = idLogin;
        this.codUsuario = codUsuario;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
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
        hash += (int) idLogin;
        hash += (int) codUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BscLoginPK)) {
            return false;
        }
        BscLoginPK other = (BscLoginPK) object;
        if (this.idLogin != other.idLogin) {
            return false;
        }
        if (this.codUsuario != other.codUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.BscLoginPK[ idLogin=" + idLogin + ", codUsuario=" + codUsuario + " ]";
    }
    
}
