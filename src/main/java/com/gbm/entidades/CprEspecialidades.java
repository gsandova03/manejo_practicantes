
package com.gbm.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "cpr_especialidades", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprEspecialidades.findAll", query = "SELECT c FROM CprEspecialidades c"),
    @NamedQuery(name = "CprEspecialidades.findByIdEspecialidad", query = "SELECT c FROM CprEspecialidades c WHERE c.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "CprEspecialidades.findByDesEspecialidad", query = "SELECT c FROM CprEspecialidades c WHERE c.desEspecialidad = :desEspecialidad")})
public class CprEspecialidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_especialidad", nullable = false)
    private Integer idEspecialidad;
    @Size(max = 100)
    @Column(name = "des_especialidad", length = 100)
    private String desEspecialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecialidad", fetch = FetchType.LAZY)
    private List<CprPracticantes> cprPracticantesList;

    public CprEspecialidades() {
    }

    public CprEspecialidades(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getDesEspecialidad() {
        return desEspecialidad;
    }

    public void setDesEspecialidad(String desEspecialidad) {
        this.desEspecialidad = desEspecialidad;
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
        hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprEspecialidades)) {
            return false;
        }
        CprEspecialidades other = (CprEspecialidades) object;
        if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprEspecialidades[ idEspecialidad=" + idEspecialidad + " ]";
    }
    
}
