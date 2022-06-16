package com.gbm.controladores;

import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.dao.CprComentariosFacade;
import com.gbm.dao.CprHistContenidoPracticanteFacade;
import com.gbm.dao.CprPracticantesFacade;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprComentarios;
import com.gbm.entidades.CprHistContenidoPracticante;
import com.gbm.entidades.CprPracticantes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "controladorDashboardPracticante", urlPatterns = {"/controladorDashboardPracticante"})
public class controladorDashboardPracticante extends HttpServlet {

    @EJB
    CprPracticantesFacade cprPracticanteFacade;

    @EJB
    BcsUsuarioFacade bcsUsurioFacade;

    @EJB
    CprComentariosFacade cprComentariosFacade;
    
    @EJB
    CprHistContenidoPracticanteFacade cprHist;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "editar":
                this.editar(request, response);
                break;
            case "verComentarios":
                this.verComentarios(request, response);
                break;
            case "mostrarAsignacion":
                this.mostrarAsignacion(request, response);
                break;
            case "mostarResumenGeneral":
                this.infoGeneral(request, response);
        }
    }

    //METODO SOBRE GET
    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        int id = (int) sesion.getAttribute("Id");

        CprPracticantes practicante = cprPracticanteFacade.find(id);

        request.setAttribute("practicante", practicante);

        request.getRequestDispatcher("/vistas/home/dashEditarPracticante.jsp").forward(request, response);

    }

    private void verComentarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        int idPract = (int) sesion.getAttribute("Id");

        List<CprComentarios> listaComentariosPracticante = obtenerComentarios(idPract, request);

        request.setAttribute("comentariosPracticante", listaComentariosPracticante);
        request.getRequestDispatcher("/vistas/home/mostrarComentarios.jsp").forward(request, response);

    }

    private void mostrarAsignacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int idPract = (int) sesion.getAttribute("Id");
        
        List<CprHistContenidoPracticante> historialPract = obtenerAsignaciones(idPract, request);
        
        request.setAttribute("HistIndividual", historialPract);
        request.getRequestDispatcher("/vistas/home/mostrarAsignaciones.jsp").forward(request, response);
        
    }
    
    protected void infoGeneral(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int idPract = (int) sesion.getAttribute("Id");

        List<CprComentarios> listaComentariosPracticante = obtenerComentarios(idPract, request);
        List<CprHistContenidoPracticante> listaContenidoHistorialPract = obtenerAsignaciones(idPract, request);
        
        request.setAttribute("listaComentarios", listaComentariosPracticante);
        request.setAttribute("listaHistorialContenido", listaContenidoHistorialPract);
        request.getRequestDispatcher("/vistas/home/dashboardPracticante.jsp").forward(request, response);
    }
    
    
    //Obtener asignaciones de practicante por codigo
    protected List<CprHistContenidoPracticante> obtenerAsignaciones(int id, HttpServletRequest request){
        
        
        List<CprHistContenidoPracticante> historicosGeneral = cprHist.findAll();
        
        List<CprHistContenidoPracticante> historialPract = new ArrayList();
        
        for (CprHistContenidoPracticante HistIndividual : historicosGeneral) {
            if(HistIndividual.getCprHistContenidoPracticantePK().getCodUsuarioHist() == id){
                historialPract.add(HistIndividual);
            }
        }
        
        return historialPract;
    }
    
    //Obtener comentarios de practicante por codigo
    protected List<CprComentarios> obtenerComentarios(int id, HttpServletRequest request){
        List<CprComentarios> comentarios = cprComentariosFacade.findAll();

        List<CprComentarios> listaComentariosPracticante = new ArrayList();

        for (CprComentarios comentario : comentarios) {

            if (comentario.getCodUsuarioComentario().getCodUsuarioPract() == id) {
                listaComentariosPracticante.add(comentario);
            }
        }
        
        return listaComentariosPracticante;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "actualizarDatos":
                this.actualizarDatos(request, response);
                break;
        }
    }
    

    //METODOS SOBRE POST
    private void actualizarDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("cod_practicante"));

        BcsUsuario usuarioEditar = bcsUsurioFacade.find(id);

        usuarioEditar.setNomUsuario(request.getParameter("nom_practicante"));

        usuarioEditar.setDirFisica(request.getParameter("dir_practicante"));

        usuarioEditar.setEmiPersonal(request.getParameter("email_personal"));

        bcsUsurioFacade.edit(usuarioEditar);

        HttpSession sesion = request.getSession();
        sesion.setAttribute("Usuario", usuarioEditar.getNomUsuario());

        request.getRequestDispatcher("vistas/home/indexPracticante.jsp").forward(request, response);

    }

}
