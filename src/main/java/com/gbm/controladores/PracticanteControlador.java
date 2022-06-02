
package com.gbm.controladores;

import com.gbm.dao.*;
import com.gbm.entidades.BcsEstados;
import com.gbm.entidades.BcsGenero;
import com.gbm.entidades.BcsRoles;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprCarreras;
import com.gbm.entidades.CprEspecialidades;
import com.gbm.entidades.CprInstituciones;
import com.gbm.entidades.CprPracticantes;
import com.gbm.entidades.CprTipoPracticas;
import java.io.IOException;
import java.util.List;
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
    private BcsUsuarioFacade usuarioFacade;
    @EJB
    private BcsGeneroFacade generoFacade;
    @EJB
    private CprInstitucionesFacade institucionFacade;
    @EJB
    private CprCarrerasFacade carreraFacade;
    @EJB
    private CprEspecialidadesFacade especialidadFacade;
    @EJB
    private CprTipoPracticasFacade tipo_practicaFacade;
    @EJB
    private BcsEstadosFacade estadoFacade;
    @EJB
    private BcsRolesFacade rolFacade;
    
    private CprPracticantes pract;
    private BcsUsuario user;
    private BcsGenero gen;
    private CprInstituciones inst;
    private CprCarreras carr;
    private CprEspecialidades espec;
    private CprTipoPracticas prac;
    private BcsEstados estad;
    private BcsRoles rol;
    HttpSession sesion;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        RequestDispatcher dispatcher;
        
        switch(accion){
            case "crear":
                dispatcher = request.getRequestDispatcher("vistas/practicante/crearPracticante.jsp");
                dispatcher.forward(request, response);
                break;
            case "leer":
                leerTablas(request, response);
                break;
            case "verificar":
                verificarCedula(request, response);
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "crear":
                crearPracticante(request, response);
                break;
            case "verificar":
                verificarCedula(request, response);
                break;
        }
    }
    
    private void crearPracticante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        int cod_usuario = Integer.parseInt(request.getParameter("cod_usuario"));
//        String nombre_usuario = request.getParameter("nom_usuario");
//        String cedula_usuario = request.getParameter("ced_usuario");
//        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
//        String foto_usuario = request.getParameter("foto_usuario");
        String codigo_generacion = request.getParameter("cod_generacion");
        String fecha_ingreso = request.getParameter("fec_ingreso");
        String duracion_practica = request.getParameter("dur_practica");
        String lider_administrativo = request.getParameter("ldr_administrativo");
        String lider_entrenamiento = request.getParameter("ldr_entrenamiento");
        String lider_funcional = request.getParameter("ldr_funcional");
        String cantidad_materias_pendientes = request.getParameter("can_materias_pendientes");
        String descripcion_materias_pendientes = request.getParameter("des_materias_pendientes");
        String revision_materias_pendientes = request.getParameter("rev_materias_pendientes");
        String fecha_actualizacion_expediente = request.getParameter("fec_actualizacion_expediente");
        String usuario_cambio_expediente = request.getParameter("usuario_cambio_expediente");
        int id_genero = Integer.parseInt(request.getParameter("id_genero"));
        int id_institucion = Integer.parseInt(request.getParameter("id_institucion"));
        int id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
        int id_especialidad = Integer.parseInt(request.getParameter("id_especialidad"));
        int id_practica = Integer.parseInt(request.getParameter("id_practica"));
        int id_estado = Integer.parseInt(request.getParameter("id_estado"));
        
        
        BcsUsuario u = new BcsUsuario();
        u.setCodUsuario(cod_usuario);
        
        BcsGenero g = new BcsGenero();
        g.setIdGenero(id_genero);
        
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
        
        BcsRoles roles = new BcsRoles();
        roles.setIdRol(1);
        
        CprPracticantes practicante = new CprPracticantes();
        
        practicante.setCodUsuarioPract(cod_usuario);
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
        practicante.setUsiuarioCambioExpediente(usuario_cambio_expediente);
        practicante.setIdGenero(g);
        practicante.setIdInstitucion(i);
        practicante.setIdCarrera(c);
        practicante.setIdEspecialidad(e);
        practicante.setIdTipoPractica(t);
        practicante.setIdEstado(est);
        practicante.setIndBorrado("false");
        
//        crearUsuario(u.getCodUsuario(), nombre_usuario, cedula_usuario, fecha_nacimiento, foto_usuario, roles);
        
        practicanteFacade.create(practicante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/practicante/listarPracticantes.jsp");
        dispatcher.forward(request, response);
    }
    
//    private void crearUsuario(Integer cod_usuario ,String nombre, String cedula, String fecha_nacimiento, String foto_usuario, BcsRoles roles){
//        
//        BcsUsuario usuario = new BcsUsuario();
//        usuario.setCodUsuario(cod_usuario);
//        usuario.setNomUsuario(nombre);
//        usuario.setCedUsuario(cedula);
//        usuario.setFecNacimiento(fecha_nacimiento);
//        usuario.setFotoUsuario(foto_usuario);
//        usuario.setDirFisica(" ");
//        usuario.setEmiCoorporativo(" ");
//        usuario.setEmiPersonal(" ");
//        usuario.setPswUsuario(" ");
//        usuario.setIdRol(roles);
//        
//        usuarioFacade.edit(usuario);
//    }
    
    public void leerTablas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<CprInstituciones> instituciones = institucionFacade.findAll();
        List<CprCarreras> carreras = carreraFacade.findAll();
        List<CprEspecialidades> especialidades = especialidadFacade.findAll();
        List<CprTipoPracticas> tipo_practica = tipo_practicaFacade.findAll();
        List<BcsEstados> estados = estadoFacade.findAll();
        List<BcsGenero> generos = generoFacade.findAll();
        
        request.setAttribute("Intituciones", instituciones);
        request.setAttribute("Carreras", carreras);
        request.setAttribute("Especialidades", especialidades);
        request.setAttribute("Tipo_practica", tipo_practica);
        request.setAttribute("Estados", estados);
        request.setAttribute("Generos", generos);
        
        request.getRequestDispatcher("vistas/practicante/crearPracticante.jsp").forward(request, response);
    }
    
    public void verificarCedula(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String cedula_usuario = request.getParameter("ced_usuario");

        List<CprInstituciones> instituciones = institucionFacade.findAll();
        List<CprCarreras> carreras = carreraFacade.findAll();
        List<CprEspecialidades> especialidades = especialidadFacade.findAll();
        List<CprTipoPracticas> tipo_practica = tipo_practicaFacade.findAll();
        List<BcsEstados> estados = estadoFacade.findAll();
        List<BcsGenero> generos = generoFacade.findAll();
        
            user = usuarioFacade.buscarPorCc(cedula_usuario);
       
        
        if(user != null){
            request.setAttribute("Instituciones", instituciones);
            request.setAttribute("Carreras", carreras);
            request.setAttribute("Especialidades", especialidades);
            request.setAttribute("Tipo_practica", tipo_practica);
            request.setAttribute("Estados", estados);
            request.setAttribute("Usuario", user);
            request.setAttribute("cod_usuario", user.getCodUsuario());
            request.setAttribute("Generos", generos);
            
            request.getRequestDispatcher("vistas/practicante/crearPracticante.jsp").forward(request, response);
        }else{
            
        }
    }
}
