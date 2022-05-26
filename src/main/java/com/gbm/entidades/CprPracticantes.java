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
@Table(name = "cpr_practicantes", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CprPracticantes.findAll", query = "SELECT c FROM CprPracticantes c"),
    @NamedQuery(name = "CprPracticantes.findByCodUsuarioPract", query = "SELECT c FROM CprPracticantes c WHERE c.codUsuarioPract = :codUsuarioPract"),
    @NamedQuery(name = "CprPracticantes.findByCodGeneracion", query = "SELECT c FROM CprPracticantes c WHERE c.codGeneracion = :codGeneracion"),
    @NamedQuery(name = "CprPracticantes.findByFecIngreso", query = "SELECT c FROM CprPracticantes c WHERE c.fecIngreso = :fecIngreso"),
    @NamedQuery(name = "CprPracticantes.findByDurPractica", query = "SELECT c FROM CprPracticantes c WHERE c.durPractica = :durPractica"),
    @NamedQuery(name = "CprPracticantes.findByLdrAdministrativo", query = "SELECT c FROM CprPracticantes c WHERE c.ldrAdministrativo = :ldrAdministrativo"),
    @NamedQuery(name = "CprPracticantes.findByLdrEntrenamiento", query = "SELECT c FROM CprPracticantes c WHERE c.ldrEntrenamiento = :ldrEntrenamiento"),
    @NamedQuery(name = "CprPracticantes.findByLdrFuncional", query = "SELECT c FROM CprPracticantes c WHERE c.ldrFuncional = :ldrFuncional"),
    @NamedQuery(name = "CprPracticantes.findByCanMateriasPendientes", query = "SELECT c FROM CprPracticantes c WHERE c.canMateriasPendientes = :canMateriasPendientes"),
    @NamedQuery(name = "CprPracticantes.findByDesMateriasPendientes", query = "SELECT c FROM CprPracticantes c WHERE c.desMateriasPendientes = :desMateriasPendientes"),
    @NamedQuery(name = "CprPracticantes.findByRevMateriasPendientes", query = "SELECT c FROM CprPracticantes c WHERE c.revMateriasPendientes = :revMateriasPendientes"),
    @NamedQuery(name = "CprPracticantes.findByFecActualizacionExpediente", query = "SELECT c FROM CprPracticantes c WHERE c.fecActualizacionExpediente = :fecActualizacionExpediente"),
    @NamedQuery(name = "CprPracticantes.findByUsiuarioCambioExpediente", query = "SELECT c FROM CprPracticantes c WHERE c.usiuarioCambioExpediente = :usiuarioCambioExpediente"),
    @NamedQuery(name = "CprPracticantes.findByIndBorrado", query = "SELECT c FROM CprPracticantes c WHERE c.indBorrado = :indBorrado")})
public class CprPracticantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usuario_pract", nullable = false)
    private Integer codUsuarioPract;
    @Size(max = 45)
    @Column(name = "cod_generacion", length = 45)
    private String codGeneracion;
    @Size(max = 45)
    @Column(name = "fec_ingreso", length = 45)
    private String fecIngreso;
    @Size(max = 45)
    @Column(name = "dur_practica", length = 45)
    private String durPractica;
    @Size(max = 100)
    @Column(name = "ldr_administrativo", length = 100)
    private String ldrAdministrativo;
    @Size(max = 100)
    @Column(name = "ldr_entrenamiento", length = 100)
    private String ldrEntrenamiento;
    @Size(max = 100)
    @Column(name = "ldr_funcional", length = 100)
    private String ldrFuncional;
    @Size(max = 60)
    @Column(name = "can_materias_pendientes", length = 60)
    private String canMateriasPendientes;
    @Size(max = 60)
    @Column(name = "des_materias_pendientes", length = 60)
    private String desMateriasPendientes;
    @Size(max = 60)
    @Column(name = "rev_materias_pendientes", length = 60)
    private String revMateriasPendientes;
    @Size(max = 45)
    @Column(name = "fec_actualizacion_expediente", length = 45)
    private String fecActualizacionExpediente;
    @Size(max = 45)
    @Column(name = "usiuario_cambio_expediente", length = 45)
    private String usiuarioCambioExpediente;
    @Size(max = 45)
    @Column(name = "ind_borrado", length = 45)
    private String indBorrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cprPracticantes", fetch = FetchType.LAZY)
    private List<CprValoracionPracticantes> cprValoracionPracticantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuarioComentario", fetch = FetchType.LAZY)
    private List<CprComentarios> cprComentariosList;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BcsEstados idEstado;
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BcsGenero idGenero;
    @JoinColumn(name = "cod_usuario_pract", referencedColumnName = "cod_usuario", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private BcsUsuario bcsUsuario;
    @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprCarreras idCarrera;
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprEspecialidades idEspecialidad;
    @JoinColumn(name = "id_institucion", referencedColumnName = "id_institucion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprInstituciones idInstitucion;
    @JoinColumn(name = "id_tipo_practica", referencedColumnName = "id_practica", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CprTipoPracticas idTipoPractica;

    public CprPracticantes() {
    }

    public CprPracticantes(Integer codUsuarioPract) {
        this.codUsuarioPract = codUsuarioPract;
    }

    public Integer getCodUsuarioPract() {
        return codUsuarioPract;
    }

    public void setCodUsuarioPract(Integer codUsuarioPract) {
        this.codUsuarioPract = codUsuarioPract;
    }

    public String getCodGeneracion() {
        return codGeneracion;
    }

    public void setCodGeneracion(String codGeneracion) {
        this.codGeneracion = codGeneracion;
    }

    public String getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(String fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public String getDurPractica() {
        return durPractica;
    }

    public void setDurPractica(String durPractica) {
        this.durPractica = durPractica;
    }

    public String getLdrAdministrativo() {
        return ldrAdministrativo;
    }

    public void setLdrAdministrativo(String ldrAdministrativo) {
        this.ldrAdministrativo = ldrAdministrativo;
    }

    public String getLdrEntrenamiento() {
        return ldrEntrenamiento;
    }

    public void setLdrEntrenamiento(String ldrEntrenamiento) {
        this.ldrEntrenamiento = ldrEntrenamiento;
    }

    public String getLdrFuncional() {
        return ldrFuncional;
    }

    public void setLdrFuncional(String ldrFuncional) {
        this.ldrFuncional = ldrFuncional;
    }

    public String getCanMateriasPendientes() {
        return canMateriasPendientes;
    }

    public void setCanMateriasPendientes(String canMateriasPendientes) {
        this.canMateriasPendientes = canMateriasPendientes;
    }

    public String getDesMateriasPendientes() {
        return desMateriasPendientes;
    }

    public void setDesMateriasPendientes(String desMateriasPendientes) {
        this.desMateriasPendientes = desMateriasPendientes;
    }

    public String getRevMateriasPendientes() {
        return revMateriasPendientes;
    }

    public void setRevMateriasPendientes(String revMateriasPendientes) {
        this.revMateriasPendientes = revMateriasPendientes;
    }

    public String getFecActualizacionExpediente() {
        return fecActualizacionExpediente;
    }

    public void setFecActualizacionExpediente(String fecActualizacionExpediente) {
        this.fecActualizacionExpediente = fecActualizacionExpediente;
    }

    public String getUsiuarioCambioExpediente() {
        return usiuarioCambioExpediente;
    }

    public void setUsiuarioCambioExpediente(String usiuarioCambioExpediente) {
        this.usiuarioCambioExpediente = usiuarioCambioExpediente;
    }

    public String getIndBorrado() {
        return indBorrado;
    }

    public void setIndBorrado(String indBorrado) {
        this.indBorrado = indBorrado;
    }

    @XmlTransient
    public List<CprValoracionPracticantes> getCprValoracionPracticantesList() {
        return cprValoracionPracticantesList;
    }

    public void setCprValoracionPracticantesList(List<CprValoracionPracticantes> cprValoracionPracticantesList) {
        this.cprValoracionPracticantesList = cprValoracionPracticantesList;
    }

    @XmlTransient
    public List<CprComentarios> getCprComentariosList() {
        return cprComentariosList;
    }

    public void setCprComentariosList(List<CprComentarios> cprComentariosList) {
        this.cprComentariosList = cprComentariosList;
    }

    public BcsEstados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BcsEstados idEstado) {
        this.idEstado = idEstado;
    }

    public BcsGenero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(BcsGenero idGenero) {
        this.idGenero = idGenero;
    }

    public BcsUsuario getBcsUsuario() {
        return bcsUsuario;
    }

    public void setBcsUsuario(BcsUsuario bcsUsuario) {
        this.bcsUsuario = bcsUsuario;
    }

    public CprCarreras getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(CprCarreras idCarrera) {
        this.idCarrera = idCarrera;
    }

    public CprEspecialidades getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(CprEspecialidades idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public CprInstituciones getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(CprInstituciones idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public CprTipoPracticas getIdTipoPractica() {
        return idTipoPractica;
    }

    public void setIdTipoPractica(CprTipoPracticas idTipoPractica) {
        this.idTipoPractica = idTipoPractica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuarioPract != null ? codUsuarioPract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprPracticantes)) {
            return false;
        }
        CprPracticantes other = (CprPracticantes) object;
        if ((this.codUsuarioPract == null && other.codUsuarioPract != null) || (this.codUsuarioPract != null && !this.codUsuarioPract.equals(other.codUsuarioPract))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbm.entidades.CprPracticantes[ codUsuarioPract=" + codUsuarioPract + " ]";
    }
    
}
