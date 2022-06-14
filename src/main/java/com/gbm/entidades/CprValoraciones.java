
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


@Entity
@Table(name = "cpr_valoraciones", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprValoraciones.findAll", query = "SELECT c FROM CprValoraciones c"),
    @NamedQuery(name = "CprValoraciones.findByDesDescripcion", query = "SELECT c FROM CprValoraciones c WHERE c.desDescripcion = :desDescripcion"),
    @NamedQuery(name = "CprValoraciones.findByIdValoracion", query = "SELECT c FROM CprValoraciones c WHERE c.idValoracion = :idValoracion")})
public class CprValoraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "des_descripcion", nullable = false, length = 100)
    private String desDescripcion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "id_valoracion", nullable = false, length = 3)
    private String idValoracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idValoracion", fetch = FetchType.LAZY)
    private List<CprValoracionPracticantes> cprValoracionPracticantesList;

    public CprValoraciones() {
    }

    public CprValoraciones(String idValoracion) {
        this.idValoracion = idValoracion;
    }

    public CprValoraciones(String idValoracion, String desDescripcion) {
        this.idValoracion = idValoracion;
        this.desDescripcion = desDescripcion;
    }

    public String getDesDescripcion() {
        return desDescripcion;
    }

    public void setDesDescripcion(String desDescripcion) {
        this.desDescripcion = desDescripcion;
    }

    public String getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(String idValoracion) {
        this.idValoracion = idValoracion;
    }

    @XmlTransient
    public List<CprValoracionPracticantes> getCprValoracionPracticantesList() {
        return cprValoracionPracticantesList;
    }

    public void setCprValoracionPracticantesList(List<CprValoracionPracticantes> cprValoracionPracticantesList) {
        this.cprValoracionPracticantesList = cprValoracionPracticantesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValoracion != null ? idValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprValoraciones)) {
            return false;
        }
        CprValoraciones other = (CprValoraciones) object;
        if ((this.idValoracion == null && other.idValoracion != null) || (this.idValoracion != null && !this.idValoracion.equals(other.idValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprValoraciones[ idValoracion=" + idValoracion + " ]";
    }
    
}
