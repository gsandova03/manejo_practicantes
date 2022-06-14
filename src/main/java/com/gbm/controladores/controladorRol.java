package com.gbm.controladores;

import com.gbm.dao.BcsBitacoraFacade;
import com.gbm.dao.BcsRolesFacade;
import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.entidades.BcsBitacora;
import com.gbm.entidades.BcsRoles;
import com.gbm.entidades.BcsUsuario;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorRol")
public class controladorRol extends HttpServlet {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    String fecha = dtf.format(LocalDateTime.now());
    BcsBitacora bitacora = new BcsBitacora();

    @EJB
    BcsBitacoraFacade bitacoraFacade;

    @EJB
    BcsUsuarioFacade usuario;

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

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("CREATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", creó un registro en la tabla 'Rol'");

            bitacoraFacade.create(bitacora);

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

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("UPDATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", actualizó un registro en la tabla 'Rol'");

            bitacoraFacade.create(bitacora);

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

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("SELECT");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", consultó en la tabla 'Rol'");

            bitacoraFacade.create(bitacora);

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

        //Bitacora
        BcsUsuario usuarioRegistrado = usuario.find(1);

        bitacora.setCodUsuario(usuarioRegistrado);
        bitacora.setFecBitacora(fecha);
        bitacora.setTioTransaccion("DELETE");

        bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", borró un registro en la tabla 'Rol'");

        bitacoraFacade.create(bitacora);

        request.setAttribute("tituloMensaje", "Eliminación exitosa");
        request.setAttribute("cuerpoMensaje", "Se eliminó el registro");
        request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
        request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
    }

}
