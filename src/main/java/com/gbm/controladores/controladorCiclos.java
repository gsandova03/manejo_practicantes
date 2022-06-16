package com.gbm.controladores;

import com.gbm.dao.BcsBitacoraFacade;
import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.dao.CprCiclosFacade;
import com.gbm.dao.CprPracticantesFacade;
import com.gbm.entidades.BcsBitacora;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprCiclos;
import com.gbm.entidades.CprPracticantes;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/controladorCiclos")
public class controladorCiclos extends HttpServlet {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    String fecha = dtf.format(LocalDateTime.now());
    BcsBitacora bitacora = new BcsBitacora();

    @EJB
    BcsBitacoraFacade bitacoraFacade;

    @EJB
    BcsUsuarioFacade usuario;

    @EJB
    CprCiclosFacade cprCiclosQuery;

    @EJB
    CprPracticantesFacade cprPracticanteFacade;

    private List<CprCiclos> ciclos;

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

        CprCiclos objCiclo = new CprCiclos();

        String cadena = request.getParameter("descCiclos").trim();

        if (cadena.equals("")) {
            request.setAttribute("tipo", "error");
            request.setAttribute("mensaje", "La descripcion está vacia");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/insertarCiclos.jsp").forward(request, response);
        } else {
            objCiclo.setDesCiclo(cadena);
            cprCiclosQuery.create(objCiclo);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("CREATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", creó un registro en la tabla 'Ciclos'");

            bitacoraFacade.create(bitacora);

            ciclos = cprCiclosQuery.findAll();
            request.setAttribute("listaCiclos", this.ciclos);
            request.setAttribute("tipo", "success");
            request.setAttribute("mensaje", "Se ingreso el registro");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarCiclos.jsp").forward(request, response);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cadena = request.getParameter("descCiclo").trim();
        
        if (cadena.equals("")) {
            ciclos = cprCiclosQuery.findAll();
            request.setAttribute("listaCiclos", ciclos);
            request.setAttribute("tipo", "error");
            request.setAttribute("mensaje", "La descripcion está vacia");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarCiclos.jsp").forward(request, response);
        } else {
            CprCiclos objUpdate = new CprCiclos();
            objUpdate.setIdCiclo(Integer.parseInt(request.getParameter("idCiclo")));
            objUpdate.setDesCiclo(cadena);
            cprCiclosQuery.edit(objUpdate);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("UPDATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", actualizó un registro en la tabla 'Ciclos'");

            bitacoraFacade.create(bitacora);

            request.setAttribute("listaCiclos", this.ciclos);
            request.setAttribute("tipo", "success");
            request.setAttribute("mensaje", "Se actualizó el registro");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarCiclos.jsp").forward(request, response);
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
        List<CprCiclos> listaCiclos = cprCiclosQuery.findAll();
        if (listaCiclos.isEmpty()) {
            request.setAttribute("tipo", "info");
            request.setAttribute("mensaje", "No hay registros en tabla");
            request.getRequestDispatcher("/vistas/matenimiento/index.jsp").forward(request, response);
        } else {

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("SELECT");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", consultó en la tabla 'Ciclos'");

            bitacoraFacade.create(bitacora);

            request.setAttribute("listaCiclos", listaCiclos);
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarCiclos.jsp").forward(request, response);
        }
    }

    private void selectId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idCiclo"));
        CprCiclos ciclosSelect = cprCiclosQuery.find(id);
        request.setAttribute("ciclosSelect", ciclosSelect);
        request.getRequestDispatcher("/vistas/matenimiento/Vista/actualizarCiclo.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idCiclo"));
        CprCiclos ciclosDelete = cprCiclosQuery.find(id);
        List<CprPracticantes> practicantes = cprPracticanteFacade.findAll();
        

        boolean registrado = false;

        for (CprPracticantes practicante : practicantes) {
            if (practicante.getIdCarrera().getIdCarrera() == id) {
                registrado = true;
            }
        }

        if (registrado == false) {
            cprCiclosQuery.remove(ciclosDelete);

            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("DELETE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", borró un registro en la tabla 'Ciclos'");

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
