package com.gbm.controladores;

import com.gbm.dao.BcsBitacoraFacade;
import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.dao.CprValoracionesFacade;
import com.gbm.entidades.BcsBitacora;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprValoraciones;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/controladorValoraciones")
public class controladorValoraciones extends HttpServlet {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    String fecha = dtf.format(LocalDateTime.now());
    BcsBitacora bitacora = new BcsBitacora();

    @EJB
    BcsBitacoraFacade bitacoraFacade;

    @EJB
    BcsUsuarioFacade usuario;

    @EJB
    CprValoracionesFacade cprValoracionesQuery;

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

        String idValoracion = request.getParameter("idValoracion").trim();

        String descValoracion = request.getParameter("descValoracion").trim();

        if (idValoracion.equals("") || descValoracion.equals("")) {
            request.setAttribute("tituloMensaje", "Error al registrar");
            request.setAttribute("cuerpoMensaje", "Hay algun campo vacio");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/Vista/insertarValoracion.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {

            CprValoraciones buscarValoracion = cprValoracionesQuery.find(idValoracion);

            if (buscarValoracion != null) {
                request.setAttribute("tituloMensaje", "registro existente");
                request.setAttribute("cuerpoMensaje", "Ese registro ya esta en la base de datos");
                request.setAttribute("urlMensaje", "/vistas/matenimiento/Vista/insertarValoracion.jsp");
                request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
            } else {
                CprValoraciones ValoracionInsert = new CprValoraciones();
                ValoracionInsert.setIdValoracion(idValoracion);
                ValoracionInsert.setDesDescripcion(descValoracion);
                cprValoracionesQuery.create(ValoracionInsert);

                //Bitacora
                BcsUsuario usuarioRegistrado = usuario.find(1);

                bitacora.setCodUsuario(usuarioRegistrado);
                bitacora.setFecBitacora(fecha);
                bitacora.setTioTransaccion("CREATE");

                bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", creó un registro en la tabla 'Valoraciones'");

                bitacoraFacade.create(bitacora);

                request.setAttribute("tituloMensaje", "Registro exitoso");
                request.setAttribute("cuerpoMensaje", "Se ingreso el registro");
                request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
                request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
            }
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cadena = request.getParameter("descValoracion").trim();

        if (cadena.equals("")) {
            request.setAttribute("tituloMensaje", "Error al registrar");
            request.setAttribute("cuerpoMensaje", "La descripcion está vacia");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {
            CprValoraciones objUpdate = new CprValoraciones();
            objUpdate.setIdValoracion(request.getParameter("idValoracion"));
            objUpdate.setDesDescripcion(cadena);
            cprValoracionesQuery.edit(objUpdate);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("UPDATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", actualizó un registro en la tabla 'Valoraciones'");

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
                case "read":
                    this.read(request, response);
                    break;
                case "update":
                    break;
                case "delete":
                    this.delete(request, response);
                    break;
                case "selectId":
                    this.selectId(request, response);
                    break;
            }
        } else {
        }

    }

    //METODOS SOBRE EL GET
    private void read(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<CprValoraciones> listaValoraciones = cprValoracionesQuery.findAll();
        if (listaValoraciones.isEmpty()) {
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

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", consultó en la tabla 'Valoraciones'");

            bitacoraFacade.create(bitacora);

            request.setAttribute("listaValoraciones", listaValoraciones);
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarValoracion.jsp").forward(request, response);
        }
    }

    private void selectId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("idValoracion");
        CprValoraciones ValoracionSelect = cprValoracionesQuery.find(id);
        request.setAttribute("ValoracionSelect", ValoracionSelect);
        request.getRequestDispatcher("/vistas/matenimiento/Vista/actualizarValoracion.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("idValoracion");
        CprValoraciones valoracionDelete = cprValoracionesQuery.find(id);
        cprValoracionesQuery.remove(valoracionDelete);

        //Bitacora
        BcsUsuario usuarioRegistrado = usuario.find(1);

        bitacora.setCodUsuario(usuarioRegistrado);
        bitacora.setFecBitacora(fecha);
        bitacora.setTioTransaccion("DELETE");

        bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", borró un registro en la tabla 'Valoraciones'");

        bitacoraFacade.create(bitacora);

        request.setAttribute("tituloMensaje", "Eliminación exitosa");
        request.setAttribute("cuerpoMensaje", "Se eliminó el registro");
        request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
        request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
    }
}
