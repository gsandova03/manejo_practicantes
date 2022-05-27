
package com.gbm.controladores;

import com.gbm.dao.*;
import com.gbm.entidades.BcsEstados;
import com.gbm.entidades.BcsGenero;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprCarreras;
import com.gbm.entidades.CprEspecialidades;
import com.gbm.entidades.CprInstituciones;
import com.gbm.entidades.CprPracticantes;
import com.gbm.entidades.CprTipoPracticas;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/Practicante")
public class PracticanteControlador extends HttpServlet{
    @EJB
    private CprPracticantesFacade practicanteFacade;
    @EJB
    private BcsUsuarioFacade usuario;
    @EJB
    private BcsGeneroFacade genero;
    @EJB
    private CprInstitucionesFacade institucion;
    @EJB
    private CprCarrerasFacade carrera;
    @EJB
    private CprEspecialidadesFacade especialidad;
    @EJB
    private CprTipoPracticasFacade tipo_practica;
    @EJB
    private BcsEstadosFacade estado;
    
    private BcsUsuario user;
    private BcsGenero gen;
    private CprInstituciones inst;
    private CprCarreras carr;
    private CprEspecialidades espec;
    private CprTipoPracticas prac;
    private BcsEstados estad;
    HttpSession sesion;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        RequestDispatcher dispatcher;
        
        switch(accion){
            case "crear":
                dispatcher = request.getRequestDispatcher("vistas/practicante/crearPracticante.jsp");
                dispatcher.forward(request, response);
                break;
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String accion = request.getParameter("accion");
        RequestDispatcher dispatcher;
        
        switch (accion) {
            case "crear":
                crearPracticante(request, response);
                break;
            
        }
    }
    
    private void crearPracticante(HttpServletRequest request, HttpServletResponse response){
        int codigo_usuario = Integer.parseInt(request.getParameter("cod_usuario"));
        String codigo_generacion = request.getParameter("cod_generacion");
        String fecha_ingreso = request.getParameter("fec_ingreso");
        String duracion_practica = request.getParameter("dur_practica");
        String lider_administrativo = request.getParameter("ldr_administrativo");
        String lider_entrenamiento = request.getParameter("ldr_entrenamiento");
        String lider_funcional = request.getParameter("ldr_funcional");
        String cantidad_materias_pendientes = request.getParameter("can_materias_pendientes");
        String descripcion_materias_pendientes = request.getParameter("des_materias_pendientes");
        String revision_materias_pendientes = request.getParameter("rev_materias_pendientes");
        String fecha_actualizacion_expediente = request.getParameter("usuario_cambio_expediente");
        int id_genero = Integer.parseInt(request.getParameter("id_genero"));
        int id_institucion = Integer.parseInt(request.getParameter("id_institucion"));
        int id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
        int id_especialidad = Integer.parseInt(request.getParameter("id_especialidad"));
        int id_practica = Integer.parseInt(request.getParameter("id_practica"));
        int id_estado = Integer.parseInt(request.getParameter("id_estado"));
        
        user = usuario.buscarUsuarioId(codigo_usuario);
        gen = genero.find(id_genero);
        inst = institucion.find(id_institucion);
        carr = carrera.find(id_carrera);
        espec = especialidad.find(id_especialidad);
        prac = tipo_practica.find(id_practica);
        estad = estado.find(id_estado);
        
        BcsUsuario u = new BcsUsuario();
        u.setCodUsuario(user.getCodUsuario());
        
        BcsGenero g = new BcsGenero();
        g.setIdGenero(gen.getIdGenero());
        
        CprInstituciones i = new CprInstituciones();
        i.setIdInstitucion(id_institucion);
        
        CprCarreras c = new CprCarreras();
        c.setIdCarrera(id_carrera);
        
        CprEspecialidades e = new CprEspecialidades();
        e.setIdEspecialidad(id_especialidad);
        
        CprTipoPracticas t = new CprTipoPracticas();
        t.setIdPractica(id_practica);
        
        BcsEstados est = new BcsEstados();
        est.setIdEstado(id_estado);
        
        CprPracticantes practicante = new CprPracticantes();
        
        practicante.setCodUsuarioPract(u.getCodUsuario());
        practicante.setCodGeneracion(codigo_generacion);
        practicante.setFecIngreso(fecha_ingreso);
        practicante.setDurPractica(duracion_practica);
        practicante.setLdrAdministrativo(lider_administrativo);
        practicante.setLdrEntrenamiento(lider_entrenamiento);
        practicante.setLdrFuncional(lider_funcional);
        practicante.setCanMateriasPendientes(cantidad_materias_pendientes);
        practicante.setDesMateriasPendientes(descripcion_materias_pendientes);
        practicante.setRevMateriasPendientes(revision_materias_pendientes);
        practicante.setFecActualizacionExpediente(fecha_actualizacion_expediente);
        practicante.setIdGenero(g);
        practicante.setIdInstitucion(i);
        practicante.setIdCarrera(c);
        practicante.setIdEspecialidad(e);
        practicante.setIdTipoPractica(t);
        practicante.setIdEstado(est);
        
        practicanteFacade.create(practicante);
    }
}
