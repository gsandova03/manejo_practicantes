package com.gbm.controladores;

import com.gbm.dao.CprTipoPracticasFacade;
import com.gbm.entidades.CprTipoPracticas;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/controladorTipoPracticas")
public class controladorTipopracticas extends HttpServlet {

    @EJB
    CprTipoPracticasFacade cprTp;

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

        String cadena = request.getParameter("descTipoPracticas").trim();

        if (cadena.equals("")) {
            request.setAttribute("tituloMensaje", "Error al registrar");
            request.setAttribute("cuerpoMensaje", "La descripcion está vacia");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/Vista/insertarTipopractica.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {
            CprTipoPracticas tipoPracticaInsert = new CprTipoPracticas();
            tipoPracticaInsert.setDesPractica(cadena);
            cprTp.create(tipoPracticaInsert);
            request.setAttribute("tituloMensaje", "Registro exitoso");
            request.setAttribute("cuerpoMensaje", "Se ingreso el registro");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cadena = request.getParameter("descTipoPracticas").trim();

        if (cadena.equals("")) {
            request.setAttribute("tituloMensaje", "Error al registrar");
            request.setAttribute("cuerpoMensaje", "La descripcion está vacia");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {
            CprTipoPracticas objUpdate = new CprTipoPracticas();
            objUpdate.setIdPractica(Integer.parseInt(request.getParameter("idTipoPracticas")));
            objUpdate.setDesPractica(cadena);
            cprTp.edit(objUpdate);
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
                case "selectid":
                    this.selectId(request, response);
                    break;
            }
        } else {
        }

    }

    //METODOS SOBRE EL GET
    private void read(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<CprTipoPracticas> listaPracticas = cprTp.findAll();
        if (listaPracticas.isEmpty()) {
            request.setAttribute("tituloMensaje", "Registros nulo");
            request.setAttribute("cuerpoMensaje", "No hay registro en tabla");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {
            request.setAttribute("listaPracticas", listaPracticas);
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarTipopracticas.jsp").forward(request, response);
        }  
    }

    private void selectId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idTipoPractica"));
        CprTipoPracticas tipoPracticaSelect = cprTp.find(id);
        request.setAttribute("tipoPracticaSelect", tipoPracticaSelect);
        request.getRequestDispatcher("/vistas/matenimiento/Vista/actualizarTipopracticas.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idTipoPractica"));
        CprTipoPracticas tipoPracticaDelete = cprTp.find(id);
        cprTp.remove(tipoPracticaDelete);
        request.setAttribute("tituloMensaje", "Eliminación exitosa");
        request.setAttribute("cuerpoMensaje", "Se eliminó el registro");
        request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
        request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
    }

}
