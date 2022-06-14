
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
@Table(name = "cpr_ciclos", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprCiclos.findAll", query = "SELECT c FROM CprCiclos c"),
    @NamedQuery(name = "CprCiclos.findByIdCiclo", query = "SELECT c FROM CprCiclos c WHERE c.idCiclo = :idCiclo"),
    @NamedQuery(name = "CprCiclos.findByDesCiclo", query = "SELECT c FROM CprCiclos c WHERE c.desCiclo = :desCiclo")})
public class CprCiclos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ciclo", nullable = false)
    private Integer idCiclo;
    @Size(max = 100)
    @Column(name = "des_ciclo", length = 100)
    private String desCiclo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cprCiclos", fetch = FetchType.LAZY)
    private List<CprValoracionPracticantes> cprValoracionPracticantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cprCiclos", fetch = FetchType.LAZY)
    private List<CprHistContenidoPracticante> cprHistContenidoPracticanteList;

    public CprCiclos() {
    }

    public CprCiclos(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getDesCiclo() {
        return desCiclo;
    }

    public void setDesCiclo(String desCiclo) {
        this.desCiclo = desCiclo;
    }

    @XmlTransient
    public List<CprValoracionPracticantes> getCprValoracionPracticantesList() {
        return cprValoracionPracticantesList;
    }

    public void setCprValoracionPracticantesList(List<CprValoracionPracticantes> cprValoracionPracticantesList) {
        this.cprValoracionPracticantesList = cprValoracionPracticantesList;
    }

    @XmlTransient
    public List<CprHistContenidoPracticante> getCprHistContenidoPracticanteList() {
        return cprHistContenidoPracticanteList;
    }

    public void setCprHistContenidoPracticanteList(List<CprHistContenidoPracticante> cprHistContenidoPracticanteList) {
        this.cprHistContenidoPracticanteList = cprHistContenidoPracticanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiclo != null ? idCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprCiclos)) {
            return false;
        }
        CprCiclos other = (CprCiclos) object;
        if ((this.idCiclo == null && other.idCiclo != null) || (this.idCiclo != null && !this.idCiclo.equals(other.idCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprCiclos[ idCiclo=" + idCiclo + " ]";
    }
    
}
