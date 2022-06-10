package com.gbm.controladores;

import com.gbm.dao.BcsRolesFacade;
import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.entidades.BcsRoles;
import com.gbm.entidades.BcsUsuario;
import java.io.IOException;
import java.util.List;
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

        String accion = request.getParameter("accion");

        switch (accion) {
            case "insert":
                this.insetar(request, response);
                break;
            case "update":
                this.update(request, response);
                break;
        }
    }

    private void insetar(HttpServletRequest request, HttpServletResponse response)
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
            request.setAttribute("UsuarioExistente", "Este usuario ya existe en nuestra base de datos<i class='bi bi-exclamation-octagon'>");
            request.setAttribute("mensajeerror", "mensaje-error");
            request.getRequestDispatcher("vistas/login/registro_usuario.jsp").forward(request, response);
        } else {
            bcsUsuario.create(usuario);
            request.setAttribute("UsuarioNuevo", "Usuario creado satifactoriamente<i class='bi bi-person-check'></i>");
            request.setAttribute("mensajecreado", "mensaje-creado");
            request.getRequestDispatcher("vistas/login/registro_usuario.jsp").forward(request, response);
        }
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BcsUsuario usuarioActualizar = new BcsUsuario();
        BcsRoles rol = new BcsRoles();
        
        usuarioActualizar.setCodUsuario(Integer.parseInt(request.getParameter("cod_usuario")));
        usuarioActualizar.setNomUsuario(request.getParameter("nom_usuario"));
        usuarioActualizar.setCedUsuario(request.getParameter("ced_usuario"));
        usuarioActualizar.setFecNacimiento(request.getParameter("fec_nacimiento"));
        usuarioActualizar.setDirFisica(request.getParameter("dir_fisica"));
        usuarioActualizar.setEmiCoorporativo(request.getParameter("emi_corporativo"));
        usuarioActualizar.setEmiPersonal(request.getParameter("emi_persoanl"));
        usuarioActualizar.setPswUsuario(request.getParameter("pass_usuario"));
        
        
        int idRol = Integer.parseInt(request.getParameter("rol_usuario"));

        
        BcsRoles r = bcsRolesFacade.find(idRol);
        
        rol.setIdRol(r.getIdRol());
        rol.setNomRol(r.getNomRol());
        
        usuarioActualizar.setIdRol(rol);
        bcsUsuario.edit(usuarioActualizar);
        
        response.sendRedirect("index.jsp");
        
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "read":
                this.read(request, response);
            case "select":
                this.seleccionar(request, response);
                break;
            case "formInfo":
                this.formInfo(request, response);
                
        }
    }

    private void read(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<BcsUsuario> listaUsuario = bcsUsuario.findAll();
        request.setAttribute("ListaUsuarios", listaUsuario);
        request.getRequestDispatcher("vistas/login/listaUsuarios.jsp").forward(request, response);
    }

    private void seleccionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idUsuario"));

        BcsUsuario usuarioBuscado = bcsUsuario.find(id);

        request.setAttribute("usuarioEncontrado", usuarioBuscado);

        request.getRequestDispatcher("vistas/login/actualizarUsuario.jsp").forward(request, response);

    }
    
    //Cambios
    
    private void formInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<BcsRoles> roles = bcsRolesFacade.findAll();
        
        request.setAttribute("roles", roles);

        request.getRequestDispatcher("vistas/login/registro_usuario.jsp").forward(request, response);
    }

}
