package com.gbm.controladores;

import com.gbm.dao.*;
import com.gbm.entidades.BcsBitacora;
import com.gbm.entidades.BcsEstados;
import com.gbm.entidades.BcsGenero;
import com.gbm.entidades.BcsRoles;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprCarreras;
import com.gbm.entidades.CprCiclos;
import com.gbm.entidades.CprEspecialidades;
import com.gbm.entidades.CprInstituciones;
import com.gbm.entidades.CprPracticantes;
import com.gbm.entidades.CprTipoPracticas;
import com.gbm.entidades.CprValoraciones;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Practicante")
public class PracticanteControlador extends HttpServlet {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    String fecha = dtf.format(LocalDateTime.now());
    BcsBitacora bitacora = new BcsBitacora();

    @EJB
    BcsBitacoraFacade bitacoraFacade;

    @EJB
    BcsUsuarioFacade usuario;

    @EJB
    private CprPracticantesFacade practicanteFacade;
    @EJB
    private BcsUsuarioFacade usuarioFacade;
    @EJB
    private BcsGeneroFacade generoFacade;
    @EJB
    private CprInstitucionesFacade institucionFacade;
    @EJB
    private CprCarrerasFacade carreraFacade;
    @EJB
    private CprEspecialidadesFacade especialidadFacade;
    @EJB
    private CprTipoPracticasFacade tipo_practicaFacade;
    @EJB
    private BcsEstadosFacade estadoFacade;
    @EJB
    private BcsRolesFacade rolFacade;
    @EJB
    private CprCiclosFacade cprCicloFacaed;
    @EJB
    private CprValoracionesFacade valoracionFacade;

    
    
    HttpSession sesion;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "leer":
                leerTablas(request, response);
                break;
            case "verificar":
                verificarCedula(request, response);
                break;
            case "listar":
                listarPracticantes(request, response);
                break;
            case "actualizar":
                llenarCamposFormulario(request, response);
                break;
            case "valorarPracticante":
                this.valorarPracticante(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "crear":
                crearPracticante(request, response);
                break;
            case "verificar":
                verificarCedula(request, response);
                break;
            case "listar":
                listarPracticantes(request, response);
                break;
            case "actualizar":
                actualizarPracticanteBD(request, response);
                break;
        }
    }

    private void crearPracticante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cod_usuario = Integer.parseInt(request.getParameter("cod_usuario"));
        String codigo_generacion = request.getParameter("cod_generacion");
        String fecha_ingreso = request.getParameter("fec_ingreso");
        String duracion_practica = request.getParameter("dur_practica");
        String lider_administrativo = request.getParameter("ldr_administrativo");
        String lider_entrenamiento = request.getParameter("ldr_entrenamiento");
        String lider_funcional = request.getParameter("ldr_funcional");
        String cantidad_materias_pendientes = request.getParameter("can_materias_pendientes");
        String descripcion_materias_pendientes = request.getParameter("des_materias_pendientes");
        String revision_materias_pendientes = request.getParameter("rev_materias_pendientes");
        String fecha_actualizacion_expediente = request.getParameter("fec_actualizacion_expediente");
        String usuario_cambio_expediente = request.getParameter("usuario_cambio_expediente");
        int id_genero = Integer.parseInt(request.getParameter("id_genero"));
        int id_institucion = Integer.parseInt(request.getParameter("id_institucion"));
        int id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
        int id_especialidad = Integer.parseInt(request.getParameter("id_especialidad"));
        int id_practica = Integer.parseInt(request.getParameter("id_practica"));
        int id_estado = Integer.parseInt(request.getParameter("id_estado"));

        BcsUsuario u = new BcsUsuario();
        u.setCodUsuario(cod_usuario);

        BcsGenero g = new BcsGenero();
        g.setIdGenero(id_genero);

        CprInstituciones i = new CprInstituciones();
        i.setIdInstitucion(id_institucion);

        CprCarreras c = new CprCarreras();
        c.setIdCarrera(id_carrera);

        CprEspecialidades e = new CprEspecialidades();
        e.setIdEspecialidad(id_especialidad);

        CprTipoPracticas t = new CprTipoPracticas();
        t.setIdPractica(id_practica);

        BcsEstados est = new BcsEstados();
        est.setIdEstado(id_estado);

        CprPracticantes practicante = new CprPracticantes();

        practicante.setCodUsuarioPract(cod_usuario);
        practicante.setCodGeneracion(codigo_generacion);
        practicante.setFecIngreso(fecha_ingreso);
        practicante.setDurPractica(duracion_practica);
        practicante.setLdrAdministrativo(lider_administrativo);
        practicante.setLdrEntrenamiento(lider_entrenamiento);
        practicante.setLdrFuncional(lider_funcional);
        practicante.setCanMateriasPendientes(cantidad_materias_pendientes);
        practicante.setDesMateriasPendientes(descripcion_materias_pendientes);
        practicante.setRevMateriasPendientes(revision_materias_pendientes);
        practicante.setFecActualizacionExpediente(fecha_actualizacion_expediente);
        practicante.setUsiuarioCambioExpediente(usuario_cambio_expediente);
        practicante.setIdGenero(g);
        practicante.setIdInstitucion(i);
        practicante.setIdCarrera(c);
        practicante.setIdEspecialidad(e);
        practicante.setIdTipoPractica(t);
        practicante.setIdEstado(est);
        practicante.setIndBorrado("false");

        practicanteFacade.create(practicante);

        //Bitacora
        BcsUsuario usuarioRegistrado = usuario.find(1);

        bitacora.setCodUsuario(usuarioRegistrado);
        bitacora.setFecBitacora(fecha);
        bitacora.setTioTransaccion("CREATE");

        bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", creó un registro en la tabla 'Practicante'");

        bitacoraFacade.create(bitacora);
        
        request.setAttribute("tipo", "success");
        request.setAttribute("mensaje", "Se creo el practicante");
        request.getRequestDispatcher("vistas/practicante/listarPracticantes.jsp").forward(request, response);
        
    }

    public void leerTablas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CprInstituciones> instituciones = institucionFacade.findAll();
        List<CprCarreras> carreras = carreraFacade.findAll();
        List<CprEspecialidades> especialidades = especialidadFacade.findAll();
        List<CprTipoPracticas> tipo_practica = tipo_practicaFacade.findAll();
        List<BcsEstados> estados = estadoFacade.findAll();
        List<BcsGenero> generos = generoFacade.findAll();

        BcsUsuario user = new BcsUsuario();

        request.setAttribute("Instituciones", instituciones);
        request.setAttribute("Carreras", carreras);
        request.setAttribute("Especialidades", especialidades);
        request.setAttribute("Tipo_practica", tipo_practica);
        request.setAttribute("Estados", estados);
        request.setAttribute("Generos", generos);
        request.setAttribute("Usuario", user);

        request.getRequestDispatcher("vistas/practicante/crearPracticante.jsp").forward(request, response);
    }

    public void verificarCedula(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cedula_usuario = request.getParameter("ced_usuario");
        BcsUsuario user;
        List<CprInstituciones> instituciones = institucionFacade.findAll();
        List<CprCarreras> carreras = carreraFacade.findAll();
        List<CprEspecialidades> especialidades = especialidadFacade.findAll();
        List<CprTipoPracticas> tipo_practica = tipo_practicaFacade.findAll();
        List<BcsEstados> estados = estadoFacade.findAll();
        List<BcsGenero> generos = generoFacade.findAll();

        user = usuarioFacade.buscarPorCc(cedula_usuario);

        request.setAttribute("Instituciones", instituciones);
        request.setAttribute("Carreras", carreras);
        request.setAttribute("Especialidades", especialidades);
        request.setAttribute("Tipo_practica", tipo_practica);
        request.setAttribute("Estados", estados);
        request.setAttribute("Generos", generos);

        if (user == null) {
            user = new BcsUsuario();
            request.setAttribute("mensaje", "No se encontro el usuario");
            request.setAttribute("tipo", "error");
            request.setAttribute("Usuario", user);
            request.getRequestDispatcher("vistas/practicante/crearPracticante.jsp").forward(request, response);
        } else if(user.getIdRol().getIdRol() == 1 || user.getIdRol().getIdRol() == 3){
            user = new BcsUsuario();
            request.setAttribute("mensaje", "No se puede crear practicante");
            request.setAttribute("tipo", "error");
            request.setAttribute("Usuario", user);
            request.getRequestDispatcher("vistas/practicante/crearPracticante.jsp").forward(request, response);
        }
    }

    private void listarPracticantes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CprPracticantes> practicante = practicanteFacade.findAll();

        //Bitacora
        BcsUsuario usuarioRegistrado = usuario.find(1);

        bitacora.setCodUsuario(usuarioRegistrado);
        bitacora.setFecBitacora(fecha);
        bitacora.setTioTransaccion("SELECT");

        bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", consultó en la tabla 'Practicante'");

        bitacoraFacade.create(bitacora);

        request.setAttribute("listaUsuario", practicante);
        request.getRequestDispatcher("vistas/practicante/listarPracticantes.jsp").forward(request, response);

    }

    private void llenarCamposFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        BcsUsuario user;
        CprPracticantes pract;
        List<CprInstituciones> instituciones = institucionFacade.findAll();
        List<CprCarreras> carreras = carreraFacade.findAll();
        List<CprEspecialidades> especialidades = especialidadFacade.findAll();
        List<CprTipoPracticas> tipo_practica = tipo_practicaFacade.findAll();
        List<BcsEstados> estados = estadoFacade.findAll();
        List<BcsGenero> generos = generoFacade.findAll();

        user = usuarioFacade.buscarPorCc(id);
        pract = practicanteFacade.buscarPorCodigo(user.getCodUsuario());
        if (user != null) {
            request.setAttribute("Instituciones", instituciones);
            request.setAttribute("Carreras", carreras);
            request.setAttribute("Especialidades", especialidades);
            request.setAttribute("Tipo_practica", tipo_practica);
            request.setAttribute("Estados", estados);
            request.setAttribute("Usuario", user);
            request.setAttribute("Practicante", pract);
            request.setAttribute("cod_usuario", user.getCodUsuario());
            request.setAttribute("Generos", generos);

            request.getRequestDispatcher("vistas/practicante/editarPracticante.jsp").forward(request, response);
        }
    }

    private void actualizarPracticanteBD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod_usuario = Integer.parseInt(request.getParameter("cod_usuario"));
        String codigo_generacion = request.getParameter("cod_generacion");
        String fecha_ingreso = request.getParameter("fec_ingreso");
        String duracion_practica = request.getParameter("dur_practica");
        String lider_administrativo = request.getParameter("ldr_administrativo");
        String lider_entrenamiento = request.getParameter("ldr_entrenamiento");
        String lider_funcional = request.getParameter("ldr_funcional");
        String cantidad_materias_pendientes = request.getParameter("can_materias_pendientes");
        String descripcion_materias_pendientes = request.getParameter("des_materias_pendientes");
        String revision_materias_pendientes = request.getParameter("rev_materias_pendientes");
        String fecha_actualizacion_expediente = request.getParameter("fec_actualizacion_expediente");
        String usuario_cambio_expediente = request.getParameter("usuario_cambio_expediente");
        int id_genero = Integer.parseInt(request.getParameter("id_genero"));
        int id_institucion = Integer.parseInt(request.getParameter("id_institucion"));
        int id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
        int id_especialidad = Integer.parseInt(request.getParameter("id_especialidad"));
        int id_practica = Integer.parseInt(request.getParameter("id_practica"));
        int id_estado = Integer.parseInt(request.getParameter("id_estado"));

        BcsGenero g = new BcsGenero();
        g.setIdGenero(id_genero);

        CprInstituciones i = new CprInstituciones();
        i.setIdInstitucion(id_institucion);

        CprCarreras c = new CprCarreras();
        c.setIdCarrera(id_carrera);

        CprEspecialidades e = new CprEspecialidades();
        e.setIdEspecialidad(id_especialidad);

        CprTipoPracticas t = new CprTipoPracticas();
        t.setIdPractica(id_practica);

        BcsEstados est = new BcsEstados();
        est.setIdEstado(id_estado);

        CprPracticantes practicante = new CprPracticantes();

        practicante.setCodUsuarioPract(cod_usuario);
        practicante.setCodGeneracion(codigo_generacion);
        practicante.setFecIngreso(fecha_ingreso);
        practicante.setDurPractica(duracion_practica);
        practicante.setLdrAdministrativo(lider_administrativo);
        practicante.setLdrEntrenamiento(lider_entrenamiento);
        practicante.setLdrFuncional(lider_funcional);
        practicante.setCanMateriasPendientes(cantidad_materias_pendientes);
        practicante.setDesMateriasPendientes(descripcion_materias_pendientes);
        practicante.setRevMateriasPendientes(revision_materias_pendientes);
        practicante.setFecActualizacionExpediente(fecha_actualizacion_expediente);
        practicante.setUsiuarioCambioExpediente(usuario_cambio_expediente);
        practicante.setIdGenero(g);
        practicante.setIdInstitucion(i);
        practicante.setIdCarrera(c);
        practicante.setIdEspecialidad(e);
        practicante.setIdTipoPractica(t);
        practicante.setIdEstado(est);
        practicante.setIndBorrado("false");

        List<CprPracticantes> practicantes = practicanteFacade.findAll();
        request.setAttribute("listaUsuario", practicantes);

        practicanteFacade.edit(practicante);

        //Bitacora
        BcsUsuario usuarioRegistrado = usuario.find(1);

        bitacora.setCodUsuario(usuarioRegistrado);
        bitacora.setFecBitacora(fecha);
        bitacora.setTioTransaccion("UPDATE");

        bitacora.setDesTransaccion("EL usuario " + usuarioRegistrado.getNomUsuario() + ", actualizó un registro en la tabla 'Practicante'");

        bitacoraFacade.create(bitacora);

        request.getRequestDispatcher("vistas/practicante/listarPracticantes.jsp").forward(request, response);
    }

    private void valorarPracticante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idPracticante = Integer.parseInt(request.getParameter("id"));

        CprPracticantes practicanteValorar = practicanteFacade.find(idPracticante);

        List<CprCiclos> listaCiclo = cprCicloFacaed.findAll();

        List<CprValoraciones> listaValoracion = valoracionFacade.findAll();

        request.setAttribute("practicanteValorar", practicanteValorar);
        request.setAttribute("listaCiclo", listaCiclo);
        request.setAttribute("listaValoracion", listaValoracion);

        request.getRequestDispatcher("/vistas/practicante/insertarValoracionPrac.jsp").forward(request, response);

    }
}
