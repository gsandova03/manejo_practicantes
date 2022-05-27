/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbm.controladores;

import com.gbm.dao.CprPracticantesFacade;
import com.gbm.entidades.BcsGenero;
import com.gbm.entidades.CprPracticantes;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author gsandoval
 */
@WebServlet("/Practicante")
public class PracticanteControlador extends HttpServlet{
    @EJB
    private CprPracticantesFacade practicanteFacade;
    @EJB
    private BcsGenero genero;
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
        
        CprPracticantes practicante = new CprPracticantes();
        
        practicante.setCodUsuarioPract(codigo_usuario);
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
//        practicante.setIdGenero(id_genero);
//        practicante.setIdInstitucion(id_institucion);
    }
}
