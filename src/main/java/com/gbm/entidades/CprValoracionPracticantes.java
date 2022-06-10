
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


@Entity
@Table(name = "cpr_valoracion_practicantes", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprValoracionPracticantes.findAll", query = "SELECT c FROM CprValoracionPracticantes c"),
    @NamedQuery(name = "CprValoracionPracticantes.findByIdCicloVal", query = "SELECT c FROM CprValoracionPracticantes c WHERE c.cprValoracionPracticantesPK.idCicloVal = :idCicloVal"),
    @NamedQuery(name = "CprValoracionPracticantes.findByIdValoracion", query = "SELECT c FROM CprValoracionPracticantes c WHERE c.cprValoracionPracticantesPK.idValoracion = :idValoracion"),
    @NamedQuery(name = "CprValoracionPracticantes.findByCodUsuario", query = "SELECT c FROM CprValoracionPracticantes c WHERE c.cprValoracionPracticantesPK.codUsuario = :codUsuario")})
public class CprValoracionPracticantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CprValoracionPracticantesPK cprValoracionPracticantesPK;
    @JoinColumn(name = "id_ciclo_val", referencedColumnName = "id_ciclo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprCiclos cprCiclos;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario_pract", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprPracticantes cprPracticantes;
    @JoinColumn(name = "id_valoracion", referencedColumnName = "id_valoracion", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprValoraciones cprValoraciones;

    public CprValoracionPracticantes() {
    }

    public CprValoracionPracticantes(CprValoracionPracticantesPK cprValoracionPracticantesPK) {
        this.cprValoracionPracticantesPK = cprValoracionPracticantesPK;
    }

    public CprValoracionPracticantes(int idCicloVal, String idValoracion, int codUsuario) {
        this.cprValoracionPracticantesPK = new CprValoracionPracticantesPK(idCicloVal, idValoracion, codUsuario);
    }

    public CprValoracionPracticantesPK getCprValoracionPracticantesPK() {
        return cprValoracionPracticantesPK;
    }

    public void setCprValoracionPracticantesPK(CprValoracionPracticantesPK cprValoracionPracticantesPK) {
        this.cprValoracionPracticantesPK = cprValoracionPracticantesPK;
    }

    public CprCiclos getCprCiclos() {
        return cprCiclos;
    }

    public void setCprCiclos(CprCiclos cprCiclos) {
        this.cprCiclos = cprCiclos;
    }

    public CprPracticantes getCprPracticantes() {
        return cprPracticantes;
    }

    public void setCprPracticantes(CprPracticantes cprPracticantes) {
        this.cprPracticantes = cprPracticantes;
    }

    public CprValoraciones getCprValoraciones() {
        return cprValoraciones;
    }

    public void setCprValoraciones(CprValoraciones cprValoraciones) {
        this.cprValoraciones = cprValoraciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cprValoracionPracticantesPK != null ? cprValoracionPracticantesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprValoracionPracticantes)) {
            return false;
        }
        CprValoracionPracticantes other = (CprValoracionPracticantes) object;
        if ((this.cprValoracionPracticantesPK == null && other.cprValoracionPracticantesPK != null) || (this.cprValoracionPracticantesPK != null && !this.cprValoracionPracticantesPK.equals(other.cprValoracionPracticantesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprValoracionPracticantes[ cprValoracionPracticantesPK=" + cprValoracionPracticantesPK + " ]";
    }
    
}
