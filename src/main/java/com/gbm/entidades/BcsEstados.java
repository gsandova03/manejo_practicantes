
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
@Table(name = "bcs_estados", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcsEstados.findAll", query = "SELECT b FROM BcsEstados b"),
    @NamedQuery(name = "BcsEstados.findByIdEstado", query = "SELECT b FROM BcsEstados b WHERE b.idEstado = :idEstado"),
    @NamedQuery(name = "BcsEstados.findByDesEstados", query = "SELECT b FROM BcsEstados b WHERE b.desEstados = :desEstados")})
public class BcsEstados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado", nullable = false)
    private Integer idEstado;
    @Size(max = 100)
    @Column(name = "des_estados", length = 100)
    private String desEstados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado", fetch = FetchType.LAZY)
    private List<CprPracticantes> cprPracticantesList;

    public BcsEstados() {
    }

    public BcsEstados(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDesEstados() {
        return desEstados;
    }

    public void setDesEstados(String desEstados) {
        this.desEstados = desEstados;
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
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcsEstados)) {
            return false;
        }
        BcsEstados other = (BcsEstados) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.BcsEstados[ idEstado=" + idEstado + " ]";
    }
    
}
