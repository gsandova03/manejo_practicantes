package com.gbm.controladores;

import com.gbm.dao.BcsBitacoraFacade;
import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.dao.CprCarrerasFacade;
import com.gbm.dao.CprPracticantesFacade;
import com.gbm.entidades.BcsBitacora;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprCarreras;
import com.gbm.entidades.CprPracticantes;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/controladorCarrera")
public class controladorCarr extends HttpServlet {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    String fecha = dtf.format(LocalDateTime.now());
    BcsBitacora bitacora = new BcsBitacora();

    @EJB
    BcsBitacoraFacade bitacoraFacade;

    @EJB
    BcsUsuarioFacade usuario;

    @EJB
    CprCarrerasFacade cprCarr;

    @EJB
    CprPracticantesFacade cprPracticanteFacade;

    private List<CprCarreras> carreras;

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
        CprCarreras objcprCarr = new CprCarreras();

        String cadena = request.getParameter("descCarrera").trim();

        if (cadena.equals("")) {
            request.setAttribute("tipo", "error");
            request.setAttribute("mensaje", "La descripcion está vacia");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/insertarCarrera.jsp").forward(request, response);
        } else {
            objcprCarr.setDesCarrera(cadena);
            cprCarr.create(objcprCarr);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("CREATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", creó un registro en la tabla 'Carreras'");

            bitacoraFacade.create(bitacora);

            carreras = cprCarr.findAll();
            request.setAttribute("Carreras", this.carreras);
            request.setAttribute("tipo", "success");
            request.setAttribute("mensaje", "Se ingreso el registro");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarCarrera.jsp").forward(request, response);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cadena = request.getParameter("descCarrera").trim();

        if (cadena.equals("")) {
            carreras = cprCarr.findAll();
            request.setAttribute("Carreras", this.carreras);
            request.setAttribute("tipo", "error");
            request.setAttribute("mensaje", "La descripcion está vacia");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarCarrera.jsp").forward(request, response);
        } else {
            CprCarreras objUpdate = new CprCarreras();
            objUpdate.setIdCarrera(Integer.parseInt(request.getParameter("idCarrera")));
            objUpdate.setDesCarrera(cadena);
            cprCarr.edit(objUpdate);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("UPDATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", actualizó un registro en la tabla 'Carreras'");

            bitacoraFacade.create(bitacora);

            carreras = cprCarr.findAll();
            request.setAttribute("Carreras", this.carreras);
            request.setAttribute("tipo", "succes");
            request.setAttribute("mensaje", "Se actualizó el registro");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarCarrera.jsp").forward(request, response);
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
        carreras = cprCarr.findAll();
        if (this.carreras.isEmpty()) {
            request.setAttribute("tipo", "info");
            request.setAttribute("mensaje", "No hay registros en tabla");
            request.getRequestDispatcher("/vistas/matenimiento/index.jsp").forward(request, response);
        } else {

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("SELECT");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", consultó en la tabla 'Carreras'");

            bitacoraFacade.create(bitacora);

            request.setAttribute("Carreras", this.carreras);
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarCarrera.jsp").forward(request, response);
        }

    }

    private void selectId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idCarrera"));
        CprCarreras carreraSelect = cprCarr.find(id);
        request.setAttribute("carreraSelect", carreraSelect);
        request.getRequestDispatcher("/vistas/matenimiento/Vista/actualizarCarrera.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idCarrera"));
        List<CprPracticantes> practicantes = cprPracticanteFacade.findAll();
        carreras = cprCarr.findAll();
        
        
        boolean registrado = false;

        for (CprPracticantes practicante : practicantes) {
            if (practicante.getIdCarrera().getIdCarrera() == id) {
                registrado = true;
            }
        }

        if (registrado == false) {
            CprCarreras carroDelete = cprCarr.find(id);
            cprCarr.remove(carroDelete);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("DELETE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", borró un registro en la tabla 'Carreras'");

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
