package com.gbm.controladores;

import com.gbm.dao.BcsRolesFacade;
import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.entidades.BcsRoles;
import com.gbm.entidades.BcsUsuario;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "BcsLoginControlador", urlPatterns = {"/BcsLoginControlador"})
public class BcsLoginControlador extends HttpServlet {

    @EJB
    BcsUsuarioFacade usuarioFacade;
    @EJB
    BcsRolesFacade rolesFacade;
    
    
    private BcsUsuario usuariol;
    private BcsRoles rol;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuariouser = request.getParameter("usuario");
        String password = request.getParameter("password");

        HttpSession sesion = request.getSession();
        //obtengo todo el usuario por el cooreo corporativo
        
//        try {
//            this.usuariol = usuarioFacade.buscarPorCorreoC(usuariouser);
//            
//        } catch (Exception ex) {
//            ex.getMessage();
//        }
    
        this.usuariol = usuarioFacade.buscarPorCorreoC(usuariouser);
        
        //Ingreso el rol a la sesion para saber que rol tiene
        if (usuariol == null) {
            sesion.setAttribute("tipo", "error");
            sesion.setAttribute("mensaje", "Usuario no existente");
            response.sendRedirect("index.jsp");
        } else if(usuariol.getEmiCoorporativo().equals(usuariouser) && usuariol.getPswUsuario().equals(password)){
            sesion.setAttribute("Usuario", usuariol.getNomUsuario());
            sesion.setAttribute("Rol", usuariol.getIdRol().getNomRol());
            sesion.setAttribute("Id", usuariol.getCodUsuario());
            
            if(usuariol.getIdRol().getIdRol() == 1 || usuariol.getIdRol().getIdRol() == 3){
                response.sendRedirect("vistas/home/indexAdmin.jsp");
            }else if(usuariol.getIdRol().getIdRol() == 2){
                response.sendRedirect("vistas/home/indexPracticante.jsp");
            }
        }else{
            response.sendRedirect("index.jsp");
        }

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    }

}
