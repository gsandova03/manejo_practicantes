package com.gbm.controladores;

import com.gbm.dao.BcsRolesFacade;
import com.gbm.entidades.BcsRoles;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorRol")
public class controladorRol extends HttpServlet {

    @EJB
    BcsRolesFacade bscRolesQuery;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insert":
                    this.insert(request, response);
                    break;
                case "update":
                    this.update(request, response);
                    break;
            }
        } else {

        }
    }
    //METODOS SOBRE POST

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cadena = request.getParameter("descRol").trim();

        if (cadena.equals("")) {
            request.setAttribute("tituloMensaje", "Error al registrar");
            request.setAttribute("cuerpoMensaje", "La descripcion está vacia");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/Vista/insertarRol.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {
            BcsRoles objRol = new BcsRoles();
            objRol.setNomRol(cadena);
            bscRolesQuery.create(objRol);
            request.setAttribute("tituloMensaje", "Registro exitoso");
            request.setAttribute("cuerpoMensaje", "Se ingreso el registro");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String cadena = request.getParameter("descRol").trim();

        if (cadena.equals("")) {
            request.setAttribute("tituloMensaje", "Error al registrar");
            request.setAttribute("cuerpoMensaje", "La descripcion está vacia");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {
            BcsRoles objUpdate = new BcsRoles();
            objUpdate.setIdRol(Integer.parseInt(request.getParameter("idRol")));
            objUpdate.setNomRol(cadena);
            bscRolesQuery.edit(objUpdate);
            request.setAttribute("tituloMensaje", "Registro exitoso");
            request.setAttribute("cuerpoMensaje", "Se actualizó el registro");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insert":
                    this.insert(request, response);
                    break;
                case "read":
                    this.read(request, response);
                    break;
                case "update":
                    break;
                case "delete":
                    this.delete(request, response);
                    break;
                case "selectid":
                    this.selectId(request, response);
                    break;
            }
        } else {
        }

    }

    //METODOS SOBRE EL GET
    private void read(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<BcsRoles> listaRoles = bscRolesQuery.findAll();
        if (listaRoles.isEmpty()) {
            request.setAttribute("tituloMensaje", "Registros nulo");
            request.setAttribute("cuerpoMensaje", "No hay registro en tabla");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {
            request.setAttribute("listaRoles", listaRoles);
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarRoles.jsp").forward(request, response);
        }  
    }

    private void selectId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idRol"));
        BcsRoles RolSelect = bscRolesQuery.find(id);
        request.setAttribute("RolSelect", RolSelect);
        request.getRequestDispatcher("/vistas/matenimiento/Vista/actualizarRol.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idRol"));
        BcsRoles roldDelete = bscRolesQuery.find(id);
        bscRolesQuery.remove(roldDelete);
        request.setAttribute("tituloMensaje", "Eliminación exitosa");
        request.setAttribute("cuerpoMensaje", "Se eliminó el registro");
        request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
        request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
    }

}
