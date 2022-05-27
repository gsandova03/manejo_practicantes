/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfilot
 */
@Entity
@Table(name = "bcs_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcsUsuario.findAll", query = "SELECT b FROM BcsUsuario b"),
    @NamedQuery(name = "BcsUsuario.findByCodUsuario", query = "SELECT b FROM BcsUsuario b WHERE b.codUsuario = :codUsuario"),
    @NamedQuery(name = "BcsUsuario.findByNomUsuario", query = "SELECT b FROM BcsUsuario b WHERE b.nomUsuario = :nomUsuario"),
    @NamedQuery(name = "BcsUsuario.findByCedUsuario", query = "SELECT b FROM BcsUsuario b WHERE b.cedUsuario = :cedUsuario"),
    @NamedQuery(name = "BcsUsuario.findByFecNacimiento", query = "SELECT b FROM BcsUsuario b WHERE b.fecNacimiento = :fecNacimiento"),
    @NamedQuery(name = "BcsUsuario.findByDirFisica", query = "SELECT b FROM BcsUsuario b WHERE b.dirFisica = :dirFisica"),
    @NamedQuery(name = "BcsUsuario.findByEmiCoorporativo", query = "SELECT b FROM BcsUsuario b WHERE b.emiCoorporativo = :emiCoorporativo"),
    @NamedQuery(name = "BcsUsuario.findByEmiPersonal", query = "SELECT b FROM BcsUsuario b WHERE b.emiPersonal = :emiPersonal"),
    @NamedQuery(name = "BcsUsuario.findByFotoUsuario", query = "SELECT b FROM BcsUsuario b WHERE b.fotoUsuario = :fotoUsuario"),
    @NamedQuery(name = "BcsUsuario.findByPswUsuario", query = "SELECT b FROM BcsUsuario b WHERE b.pswUsuario = :pswUsuario")})
public class BcsUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_usuario")
    private Integer codUsuario;
    @Size(max = 200)
    @Column(name = "nom_usuario")
    private String nomUsuario;
    @Size(max = 45)
    @Column(name = "ced_usuario")
    private String cedUsuario;
    @Size(max = 45)
    @Column(name = "fec_nacimiento")
    private String fecNacimiento;
    @Size(max = 50)
    @Column(name = "dir_fisica")
    private String dirFisica;
    @Size(max = 45)
    @Column(name = "emi_coorporativo")
    private String emiCoorporativo;
    @Size(max = 45)
    @Column(name = "emi_personal")
    private String emiPersonal;
    @Size(max = 45)
    @Column(name = "foto_usuario")
    private String fotoUsuario;
    @Size(max = 45)
    @Column(name = "psw_usuario")
    private String pswUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreaComentario")
    private Collection<CprComentarios> cprComentariosCollection;
    @OneToMany(mappedBy = "codUsuario")
    private Collection<BcsBitacora> bcsBitacoraCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bcsUsuario")
    private CprPracticantes cprPracticantes;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private BcsRoles idRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bcsUsuario")
    private Collection<BscLogin> bscLoginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bcsUsuario")
    private Collection<CprHistContenidoPracticante> cprHistContenidoPracticanteCollection;

    public BcsUsuario() {
    }

    public BcsUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getCedUsuario() {
        return cedUsuario;
    }

    public void setCedUsuario(String cedUsuario) {
        this.cedUsuario = cedUsuario;
    }

    public String getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(String fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getDirFisica() {
        return dirFisica;
    }

    public void setDirFisica(String dirFisica) {
        this.dirFisica = dirFisica;
    }

    public String getEmiCoorporativo() {
        return emiCoorporativo;
    }

    public void setEmiCoorporativo(String emiCoorporativo) {
        this.emiCoorporativo = emiCoorporativo;
    }

    public String getEmiPersonal() {
        return emiPersonal;
    }

    public void setEmiPersonal(String emiPersonal) {
        this.emiPersonal = emiPersonal;
    }

    public String getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public String getPswUsuario() {
        return pswUsuario;
    }

    public void setPswUsuario(String pswUsuario) {
        this.pswUsuario = pswUsuario;
    }

    @XmlTransient
    public Collection<CprComentarios> getCprComentariosCollection() {
        return cprComentariosCollection;
    }

    public void setCprComentariosCollection(Collection<CprComentarios> cprComentariosCollection) {
        this.cprComentariosCollection = cprComentariosCollection;
    }

    @XmlTransient
    public Collection<BcsBitacora> getBcsBitacoraCollection() {
        return bcsBitacoraCollection;
    }

    public void setBcsBitacoraCollection(Collection<BcsBitacora> bcsBitacoraCollection) {
        this.bcsBitacoraCollection = bcsBitacoraCollection;
    }

    public CprPracticantes getCprPracticantes() {
        return cprPracticantes;
    }

    public void setCprPracticantes(CprPracticantes cprPracticantes) {
        this.cprPracticantes = cprPracticantes;
    }

    public BcsRoles getIdRol() {
        return idRol;
    }

    public void setIdRol(BcsRoles idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public Collection<BscLogin> getBscLoginCollection() {
        return bscLoginCollection;
    }

    public void setBscLoginCollection(Collection<BscLogin> bscLoginCollection) {
        this.bscLoginCollection = bscLoginCollection;
    }

    @XmlTransient
    public Collection<CprHistContenidoPracticante> getCprHistContenidoPracticanteCollection() {
        return cprHistContenidoPracticanteCollection;
    }

    public void setCprHistContenidoPracticanteCollection(Collection<CprHistContenidoPracticante> cprHistContenidoPracticanteCollection) {
        this.cprHistContenidoPracticanteCollection = cprHistContenidoPracticanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcsUsuario)) {
            return false;
        }
        BcsUsuario other = (BcsUsuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.BcsUsuario[ codUsuario=" + codUsuario + " ]";
    }
    
}
