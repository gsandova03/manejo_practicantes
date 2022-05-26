/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gsandoval
 */
@Entity
@Table(name = "bcs_usuario", catalog = "mydb", schema = "")
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
    @NamedQuery(name = "BcsUsuario.findByPswUsuario", query = "SELECT b FROM BcsUsuario b WHERE b.pswUsuario = :pswUsuario")})
public class BcsUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usuario", nullable = false)
    private Integer codUsuario;
    @Size(max = 70)
    @Column(name = "nom_usuario", length = 70)
    private String nomUsuario;
    @Size(max = 45)
    @Column(name = "ced_usuario", length = 45)
    private String cedUsuario;
    @Size(max = 45)
    @Column(name = "fec_nacimiento", length = 45)
    private String fecNacimiento;
    @Size(max = 50)
    @Column(name = "dir_fisica", length = 50)
    private String dirFisica;
    @Size(max = 45)
    @Column(name = "emi_coorporativo", length = 45)
    private String emiCoorporativo;
    @Size(max = 20)
    @Column(name = "emi_personal", length = 20)
    private String emiPersonal;
    @Size(max = 45)
    @Column(name = "psw_usuario", length = 45)
    private String pswUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreaComentario", fetch = FetchType.LAZY)
    private List<CprComentarios> cprComentariosList;
    @OneToMany(mappedBy = "codUsuario", fetch = FetchType.LAZY)
    private List<BcsBitacora> bcsBitacoraList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bcsUsuario", fetch = FetchType.LAZY)
    private CprPracticantes cprPracticantes;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(fetch = FetchType.LAZY)
    private BcsRoles idRol;
    @JoinColumn(name = "id_login_usuario", referencedColumnName = "id_login")
    @ManyToOne(fetch = FetchType.LAZY)
    private BscLogin idLoginUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bcsUsuario", fetch = FetchType.LAZY)
    private List<CprHistContenidoPracticante> cprHistContenidoPracticanteList;

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

    public String getPswUsuario() {
        return pswUsuario;
    }

    public void setPswUsuario(String pswUsuario) {
        this.pswUsuario = pswUsuario;
    }

    @XmlTransient
    public List<CprComentarios> getCprComentariosList() {
        return cprComentariosList;
    }

    public void setCprComentariosList(List<CprComentarios> cprComentariosList) {
        this.cprComentariosList = cprComentariosList;
    }

    @XmlTransient
    public List<BcsBitacora> getBcsBitacoraList() {
        return bcsBitacoraList;
    }

    public void setBcsBitacoraList(List<BcsBitacora> bcsBitacoraList) {
        this.bcsBitacoraList = bcsBitacoraList;
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

    public BscLogin getIdLoginUsuario() {
        return idLoginUsuario;
    }

    public void setIdLoginUsuario(BscLogin idLoginUsuario) {
        this.idLoginUsuario = idLoginUsuario;
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
