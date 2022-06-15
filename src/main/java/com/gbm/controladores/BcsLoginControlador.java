package com.gbm.controladores;

import com.gbm.dao.BcsUsuarioFacade;
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
    BcsUsuarioFacade usuario;

    private BcsUsuario usuariol;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuariouser = request.getParameter("usuario");
        String password = request.getParameter("password");

        HttpSession sesion = request.getSession();
        //obtengo todo el usuario por el cooreo corporativo

        try {
            this.usuariol = usuario.buscarPorCorreoC(usuariouser);
        } catch (Exception ex) {
            ex.getMessage();
        }
        //Ingreso el rol a la sesion para saber que rol tiene
        if (usuariol == null) {
            sesion.setAttribute("ocultar", "<div class='mensaje-usario-logeado'><span>Usuario no existente <i class='bi bi-exclamation-octagon'></i></span></div>");
            response.sendRedirect("vistas/login/login.jsp");
        } else if(usuariol.getEmiCoorporativo().equals(usuariouser) && usuariol.getPswUsuario().equals(password)){
            sesion.setAttribute("Rol", usuariol.getIdRol());
            response.sendRedirect("vistas/home/dashboard.jsp");
   
        }else{
            response.sendRedirect("vistas/login/login.jsp");
        }

    }

}
