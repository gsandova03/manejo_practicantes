package com.gbm.controladores;

import com.gbm.dao.CprCiclosFacade;
import com.gbm.dao.CprPracticantesFacade;
import com.gbm.dao.CprValoracionPracticantesFacade;
import com.gbm.dao.CprValoracionesFacade;
import com.gbm.entidades.CprCiclos;
import com.gbm.entidades.CprPracticantes;
import com.gbm.entidades.CprValoracionPracticantes;
import com.gbm.entidades.CprValoracionPracticantesPK;
import com.gbm.entidades.CprValoraciones;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Valoraciones")
public class controladorValoracionPracticante extends HttpServlet {

    @EJB
    private CprValoracionPracticantesFacade valoracionPracticanteFacade;
    @EJB
    private CprValoracionPracticantesFacade cprValorPracticante;
    @EJB
    private CprCiclosFacade cprCiclo;
    @EJB
    private CprPracticantesFacade cprPracticante;
    @EJB
    private CprValoracionesFacade cprValoraciones;

    HttpSession sesion;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                obtenerDatos(request, response);
                break;
            case "read":
                this.read(request, response);
                break;
            case "select":
                this.select(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

//        switch (accion) {
//            case "insert":
//                this.insert(request, response);
//                break;
//            case "update":
//                this.update(request, response);
//        }
    }

    //Metodos GET
    private void read(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<CprValoracionPracticantes> listaValoraciones = cprValorPracticante.findAll();
        request.setAttribute("listaValoraciones", listaValoraciones);
        request.getRequestDispatcher("/vistas/practicante/mostrarValoracioPrac.jsp").forward(request, response);
    }

    private void select(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<CprValoraciones> listaValoracion = cprValoraciones.findAll();

        int idCiclo = Integer.parseInt(request.getParameter("idCiclo"));

        CprCiclos Ciclo = cprCiclo.find(idCiclo);

        int practicante = Integer.parseInt(request.getParameter("idPracticante"));

        CprPracticantes Practicante = cprPracticante.find(practicante);

        request.setAttribute("Practicante", Practicante);
        request.setAttribute("listaValoracion", listaValoracion);
        request.setAttribute("Ciclo", Ciclo);
        request.getRequestDispatcher("/vistas/practicante/actualizarValoracionPrac.jsp").forward(request, response);

    }

    public void obtenerDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ciclo1 = 1;
        int ciclo2 = 2;
        int ciclo3 = 3;
        String val1 = "A";
        String val2 = "M";
        String val3 = "B";
        List<CprValoracionPracticantes> val_alto_ciclo1 = valoracionPracticanteFacade.obtenerCantidadValoracion(ciclo1, val1);
        List<CprValoracionPracticantes> val_medio_ciclo1 = valoracionPracticanteFacade.obtenerCantidadValoracion(ciclo1, val2);
        List<CprValoracionPracticantes> val_bajo_ciclo1 = valoracionPracticanteFacade.obtenerCantidadValoracion(ciclo1, val3);

        List<CprValoracionPracticantes> val_alto_ciclo2 = valoracionPracticanteFacade.obtenerCantidadValoracion(ciclo2, val1);
        List<CprValoracionPracticantes> val_medio_ciclo2 = valoracionPracticanteFacade.obtenerCantidadValoracion(ciclo2, val2);
        List<CprValoracionPracticantes> val_bajo_ciclo2 = valoracionPracticanteFacade.obtenerCantidadValoracion(ciclo2, val3);

        List<CprValoracionPracticantes> val_alto_ciclo3 = valoracionPracticanteFacade.obtenerCantidadValoracion(ciclo3, val1);
        List<CprValoracionPracticantes> val_medio_ciclo3 = valoracionPracticanteFacade.obtenerCantidadValoracion(ciclo3, val2);
        List<CprValoracionPracticantes> val_bajo_ciclo3 = valoracionPracticanteFacade.obtenerCantidadValoracion(ciclo3, val3);

        int val_alt_ciclo1 = val_alto_ciclo1.size();
        int val_med_ciclo1 = val_medio_ciclo1.size();
        int val_baj_ciclo1 = val_bajo_ciclo1.size();

        int val_alt_ciclo2 = val_alto_ciclo2.size();
        int val_med_ciclo2 = val_medio_ciclo2.size();
        int val_baj_ciclo2 = val_bajo_ciclo2.size();

        int val_alt_ciclo3 = val_alto_ciclo3.size();
        int val_med_ciclo3 = val_medio_ciclo3.size();
        int val_baj_ciclo3 = val_bajo_ciclo3.size();
        request.setAttribute("Ciclo1_alto", val_alt_ciclo1);
        request.setAttribute("Ciclo1_medio", val_med_ciclo1);
        request.setAttribute("Ciclo1_bajo", val_baj_ciclo1);

        request.setAttribute("Ciclo2_alto", val_alt_ciclo2);
        request.setAttribute("Ciclo2_medio", val_med_ciclo2);
        request.setAttribute("Ciclo2_bajo", val_baj_ciclo2);

        request.setAttribute("Ciclo3_alto", val_alt_ciclo3);
        request.setAttribute("Ciclo3_medio", val_med_ciclo3);
        request.setAttribute("Ciclo3_bajo", val_baj_ciclo3);

        request.getRequestDispatcher("vistas/home/dashboard.jsp").forward(request, response);
    }

    // Metodos POST
//    private void insert(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        int idPracticante = Integer.parseInt(request.getParameter("idPracticante"));
//        int idCiclo = Integer.parseInt(request.getParameter("idCiclo"));
//        String idValoracion = request.getParameter("idValoracion");
//
//        CprValoracionPracticantesPK objInsert = new CprValoracionPracticantesPK();
//
//        objInsert.setCodUsuario(idPracticante);
//
//        objInsert.setIdCicloVal(idCiclo);
//
//        
//
//        List<CprValoracionPracticantes> listaValoraciones = cprValorPracticante.findAll();
//
//        boolean repetido = false;
//
//        for (CprValoracionPracticantes listaValoracion : listaValoraciones) {
//
//            int idPracticanteList = listaValoracion.getCprPracticantes().getCodUsuarioPract();
//
//            if (idPracticanteList == idPracticante) {
//                int idCicloList = listaValoracion.getCprCiclos().getIdCiclo();
//                if (idCicloList == idCiclo) {
//                    repetido = true;
//                }
//            }
//
//        }
//
//        if (repetido == false) {
//            CprValoracionPracticantes insert = new CprValoracionPracticantes(objInsert.getIdCicloVal(), objInsert.getIdValoracion(), objInsert.getCodUsuario());
//            cprValorPracticante.create(insert);
//            request.setAttribute("tituloMensaje", "Registro exitoso");
//            request.setAttribute("cuerpoMensaje", "Se ha añadido el registro de forma correcta");
//            request.setAttribute("urlMensaje", "/index.jsp");
//            request.getRequestDispatcher("/vistas/practicante/mensaje.jsp").forward(request, response);
//        } else {
//            request.setAttribute("tituloMensaje", "Valoracion por ciclo");
//            request.setAttribute("cuerpoMensaje", "Solo puedes añadir una valoración por ciclo");
//            request.setAttribute("urlMensaje", "/index.jsp");
//            request.getRequestDispatcher("/vistas/practicante/mensaje.jsp").forward(request, response);
//        }
//    }
//
//    private void update(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        int codPracticante = Integer.parseInt(request.getParameter("idPracticante"));
//        int idCiclo = Integer.parseInt(request.getParameter("idCiclo"));
//        String idValoracion = request.getParameter("idValoracion");
//
//        CprValoracionPracticantesPK objUpate = new CprValoracionPracticantesPK();
//
//        objUpate.setCodUsuario(codPracticante);
//        objUpate.setIdCicloVal(idCiclo);
//        objUpate.setIdValoracion(idValoracion);
//
//        CprValoracionPracticantes valoracionPraticanteUp = new CprValoracionPracticantes(idCiclo, idValoracion, codPracticante);
//
//        cprValorPracticante.edit(valoracionPraticanteUp);
//
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
//
//    }
}
