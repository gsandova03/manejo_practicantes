
package com.gbm.controladores;

import com.gbm.dao.BcsRolesFacade;
import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.entidades.BcsRoles;
import com.gbm.entidades.BcsUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BscUsuarioControlador", urlPatterns = {"/BscUsuarioControlador"})
public class BscUsuarioControlador extends HttpServlet {

    @EJB
    BcsUsuarioFacade bcsUsuario;
    @EJB
    BcsRolesFacade bcsRolesFacade;

    private BcsUsuario exiteUsuari = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreUsuario = request.getParameter("nom_usuario");
        String cedUsuario = request.getParameter("ced_usuario");
        String fechNacimiento = request.getParameter("fec_nacimiento");
        String dirFisica = request.getParameter("dir_fisica");
        String emailCorporativo = request.getParameter("emi_corporativo");
        String emailPersonal = request.getParameter("emi_persoanl");
        String pswPassword = request.getParameter("psw_usuario");
        String idRol = request.getParameter("id_rol");
        String urlFoto = request.getParameter("foto_usuario");

        BcsRoles rol = new BcsRoles();
        BcsUsuario usuario = new BcsUsuario();

        BcsRoles r = bcsRolesFacade.find(Integer.parseInt(idRol));

        rol.setIdRol(Integer.parseInt(idRol));
        rol.setNomRol(r.getNomRol());

        usuario.setNomUsuario(nombreUsuario);
        usuario.setCedUsuario(cedUsuario);
        usuario.setFecNacimiento(fechNacimiento);
        usuario.setDirFisica(dirFisica);
        usuario.setEmiCoorporativo(emailCorporativo);
        usuario.setEmiPersonal(emailPersonal);
        usuario.setPswUsuario(pswPassword);
        usuario.setIdRol(rol);
        usuario.setFotoUsuario(urlFoto);

        //bcsUsuario.create(usuario);
        try {
            this.exiteUsuari = bcsUsuario.buscarPorCc(cedUsuario);
        } catch (Exception ex) {
            ex.getMessage();
        }
        if (this.exiteUsuari != null) {
            request.setAttribute("UsuarioExistente", "Este usuario ya existe en nuestra base de datos");
            request.getRequestDispatcher("vistas/login/registro_usuario.jsp").forward(request, response);
        } else {
            bcsUsuario.create(usuario);
            request.setAttribute("UsuarioNuevo", "Usuario creado satifactoriamente");
            request.getRequestDispatcher("vistas/login/registro_usuario.jsp").forward(request, response);
        }

    }
}

