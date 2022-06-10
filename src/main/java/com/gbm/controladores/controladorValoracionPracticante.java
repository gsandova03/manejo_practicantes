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

@WebServlet(name = "controladorValoracionPracticante", urlPatterns = {"/controladorValoracionPracticante"})
public class controladorValoracionPracticante extends HttpServlet {

    @EJB
    CprValoracionPracticantesFacade cprValorPracticante;
    @EJB
    CprCiclosFacade cprCiclo;
    @EJB
    CprPracticantesFacade cprPracticante;
    @EJB
    CprValoracionesFacade cprValoraciones;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "read":
                this.read(request, response);
                break;
            case "select":
                this.select(request, response);
        }
    }

    //Metodos sobre Get
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "insert":
                this.insert(request, response);
                break;
            case "update":
                this.update(request, response);
        }
    }

    //Metodos sobre Post
    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPracticante = Integer.parseInt(request.getParameter("idPracticante"));
        int idCiclo = Integer.parseInt(request.getParameter("idCiclo"));
        String idValoracion = request.getParameter("idValoracion");

        CprValoracionPracticantesPK objInsert = new CprValoracionPracticantesPK();

        objInsert.setCodUsuario(idPracticante);

        objInsert.setIdCicloVal(idCiclo);

        objInsert.setIdValoracion(idValoracion);

        List<CprValoracionPracticantes> listaValoraciones = cprValorPracticante.findAll();

        boolean repetido = false;

        for (CprValoracionPracticantes listaValoracion : listaValoraciones) {

            int idPracticanteList = listaValoracion.getCprPracticantes().getCodUsuarioPract();

            if (idPracticanteList == idPracticante) {
                int idCicloList = listaValoracion.getCprCiclos().getIdCiclo();
                if (idCicloList == idCiclo) {
                    repetido = true;
                }
            }

        }

        if (repetido == false) {
            CprValoracionPracticantes insert = new CprValoracionPracticantes(objInsert.getIdCicloVal(), objInsert.getIdValoracion(), objInsert.getCodUsuario());
            cprValorPracticante.create(insert);
            request.setAttribute("tituloMensaje", "Registro exitoso");
            request.setAttribute("cuerpoMensaje", "Se ha añadido el registro de forma correcta");
            request.setAttribute("urlMensaje", "/index.jsp");
            request.getRequestDispatcher("/vistas/practicante/mensaje.jsp").forward(request, response);
        } else {
            request.setAttribute("tituloMensaje", "Valoracion por ciclo");
            request.setAttribute("cuerpoMensaje", "Solo puedes añadir una valoración por ciclo");
            request.setAttribute("urlMensaje", "/index.jsp");
            request.getRequestDispatcher("/vistas/practicante/mensaje.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codPracticante = Integer.parseInt(request.getParameter("idPracticante"));
        int idCiclo = Integer.parseInt(request.getParameter("idCiclo"));
        String idValoracion = request.getParameter("idValoracion");

        CprValoracionPracticantesPK objUpate = new CprValoracionPracticantesPK();

        objUpate.setCodUsuario(codPracticante);
        objUpate.setIdCicloVal(idCiclo);
        objUpate.setIdValoracion(idValoracion);

        CprValoracionPracticantes valoracionPraticanteUp = new CprValoracionPracticantes(idCiclo, idValoracion, codPracticante);

        cprValorPracticante.edit(valoracionPraticanteUp);

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
