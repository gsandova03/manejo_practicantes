package com.gbm.controladores;

import com.gbm.dao.BcsBitacoraFacade;
import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.dao.CprPracticantesFacade;
import com.gbm.dao.CprTipoPracticasFacade;
import com.gbm.entidades.BcsBitacora;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprPracticantes;
import com.gbm.entidades.CprTipoPracticas;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/controladorTipoPracticas")
public class controladorTipopracticas extends HttpServlet {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    String fecha = dtf.format(LocalDateTime.now());
    BcsBitacora bitacora = new BcsBitacora();

    @EJB
    BcsBitacoraFacade bitacoraFacade;

    @EJB
    BcsUsuarioFacade usuario;

    @EJB
    CprTipoPracticasFacade cprTp;

    @EJB
    CprPracticantesFacade cprPracticanteFacade;

    private List<CprTipoPracticas> tipoPracticas;

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
            request.setAttribute("tipo", "error");
            request.setAttribute("mensaje", "La descripcion está vacia");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/insertarTipopractica.jsp").forward(request, response);
        } else {
            CprTipoPracticas tipoPracticaInsert = new CprTipoPracticas();
            tipoPracticaInsert.setDesPractica(cadena);
            cprTp.create(tipoPracticaInsert);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("CREATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", creó un registro en la tabla 'Tipo practicas'");

            bitacoraFacade.create(bitacora);

            tipoPracticas = cprTp.findAll();
            request.setAttribute("listaPracticas", tipoPracticas);
            request.setAttribute("tipo", "success");
            request.setAttribute("mensaje", "Se ingreso el registro");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarTipopracticas.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cadena = request.getParameter("descTipoPracticas").trim();

        if (cadena.equals("")) {
            tipoPracticas = cprTp.findAll();
            request.setAttribute("listaPracticas", tipoPracticas);
            request.setAttribute("tipo", "error");
            request.setAttribute("mensaje", "La descripcion está vacia");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarTipopracticas.jsp").forward(request, response);
        } else {
            CprTipoPracticas objUpdate = new CprTipoPracticas();
            objUpdate.setIdPractica(Integer.parseInt(request.getParameter("idTipoPracticas")));
            objUpdate.setDesPractica(cadena);
            cprTp.edit(objUpdate);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("UPDATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", actualizó un registro en la tabla 'Tipo practicas'");

            bitacoraFacade.create(bitacora);

            tipoPracticas = cprTp.findAll();
            request.setAttribute("listaPracticas", tipoPracticas);
            request.setAttribute("tipo", "success");
            request.setAttribute("mensaje", "Se actualizó el registro");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarTipopracticas.jsp").forward(request, response);
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
            request.setAttribute("tipo", "info");
            request.setAttribute("mensaje", "No hay registro en tabla");
            request.getRequestDispatcher("/vistas/matenimiento/index.jsp").forward(request, response);
        } else {

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("SELECT");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", consultó en la tabla 'Tipo practicas'");

            bitacoraFacade.create(bitacora);

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

        List<CprPracticantes> practicantes = cprPracticanteFacade.findAll();
        boolean registrado = false;

        for (CprPracticantes practicante : practicantes) {
            if (practicante.getIdCarrera().getIdCarrera() == id) {
                registrado = true;
            }
        }

        if (registrado == false) {
            cprTp.remove(tipoPracticaDelete);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("DELETE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", borró un registro en la tabla 'Tipo practicas'");

            bitacoraFacade.create(bitacora);

            request.setAttribute("tipo", "success");
            request.setAttribute("mensaje", "Se eliminó el registro");
            request.getRequestDispatcher("/vistas/matenimiento/index.jsp").forward(request, response);
        }else{
            request.setAttribute("tipo", "error");
            request.setAttribute("mensaje", "No se puede eliminar el registro");
            request.getRequestDispatcher("/vistas/matenimiento/index.jsp").forward(request, response);
        }

    }

}
