package com.gbm.controladores;

import com.gbm.dao.BcsBitacoraFacade;
import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.dao.CprEspecialidadesFacade;
import com.gbm.entidades.BcsBitacora;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprEspecialidades;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/controladorEspecialidad")
public class controladorEsp extends HttpServlet {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    String fecha = dtf.format(LocalDateTime.now());
    BcsBitacora bitacora = new BcsBitacora();
    
    @EJB
    BcsBitacoraFacade bitacoraFacade;

    @EJB
    BcsUsuarioFacade usuario;
    
    @EJB
    CprEspecialidadesFacade cprEsp;

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

        String cadena = request.getParameter("descEspecialidad").trim();

        if (cadena.equals("")) {
            request.setAttribute("tituloMensaje", "Error al registrar");
            request.setAttribute("cuerpoMensaje", "La descripcion está vacia");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/Vista/insertarEspecialidad.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {
            CprEspecialidades objCpresp = new CprEspecialidades();
            objCpresp.setDesEspecialidad(cadena);
            cprEsp.create(objCpresp);
            
            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("CREATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", creó un registro en la tabla 'Especialidades'");

            bitacoraFacade.create(bitacora);

            
            request.setAttribute("tituloMensaje", "Registro exitoso");
            request.setAttribute("cuerpoMensaje", "Se ingreso el registro");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cadena = request.getParameter("descEspecialidad").trim();

        if (cadena.equals("")) {
            request.setAttribute("tituloMensaje", "Error al registrar");
            request.setAttribute("cuerpoMensaje", "La descripcion está vacia");
            request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
        } else {
            CprEspecialidades objUpdate = new CprEspecialidades();
            objUpdate.setIdEspecialidad(Integer.parseInt(request.getParameter("idEspacialidad")));
            objUpdate.setDesEspecialidad(cadena);
            cprEsp.edit(objUpdate);
            
            //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("UPDATE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", realizó una actualizacion en la tabla 'Especialidades'");

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
            }
        } else {

        }
    }

    //METODOS SOBRE EL GET
    private void read(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<CprEspecialidades> Especialidades = cprEsp.findAll();
        if (Especialidades.isEmpty()) {
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

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", consultó en la tabla 'Especialidades'");

            bitacoraFacade.create(bitacora);
            
            request.setAttribute("Especialidades", Especialidades);
            request.getRequestDispatcher("/vistas/matenimiento/Vista/mostrarEspecialidad.jsp").forward(request, response);
        }

    }

    private void selectId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idEspecialidad"));
        CprEspecialidades especialidadSelect = cprEsp.find(id);
        request.setAttribute("especialidadSelect", especialidadSelect);
        request.getRequestDispatcher("/vistas/matenimiento/Vista/actualizarEspecialidad.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idEspecialidad"));
        CprEspecialidades especialidadDelete = cprEsp.find(id);
        cprEsp.remove(especialidadDelete);
        
        //Bitacora
            BcsUsuario usuarioRegistrado = usuario.find(1);

            bitacora.setCodUsuario(usuarioRegistrado);
            bitacora.setFecBitacora(fecha);
            bitacora.setTioTransaccion("DELETE");

            bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", borró un registro en la tabla 'Especialidades'");

            bitacoraFacade.create(bitacora);
        
        request.setAttribute("tituloMensaje", "Eliminación exitosa");
        request.setAttribute("cuerpoMensaje", "Se eliminó el registro");
        request.setAttribute("urlMensaje", "/vistas/matenimiento/index.jsp");
        request.getRequestDispatcher("/vistas/matenimiento/Vista/mensaje.jsp").forward(request, response);
    }

}
