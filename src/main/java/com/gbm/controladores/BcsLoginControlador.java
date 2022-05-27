
package com.gbm.controladores;

import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.dao.BscLoginFacade;
import com.gbm.entidades.BcsUsuario;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "BcsLoginControlador", urlPatterns = {"/BcsLoginControlador"})
public class BcsLoginControlador extends HttpServlet {
    
    @EJB
    BcsUsuarioFacade usuario;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuariouser = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        
        BcsUsuario usuariol = new BcsUsuario();
        BcsUsuario us = new BcsUsuario();
        
        usuariol = usuario.buscarPorCorreoC(usuariouser);
        us = usuario.find(usuariol.getCodUsuario());
        
        if(us.getEmiCoorporativo().equals(usuariouser) && us.getPswUsuario().equals(password) ){
            request.getRequestDispatcher("vistas/home/dashboard.jsp").forward(request, response);
        }else{
            request.setAttribute("UsuarioInvalido", "Ususario o Contraseña invalidos");
            request.getRequestDispatcher("vistas/login/login.jsp").forward(request, response);
        }
    }

  

}

