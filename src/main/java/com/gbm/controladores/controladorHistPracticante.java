package com.gbm.controladores;

import com.gbm.dao.CprContenidoFacade;
import com.gbm.dao.CprHistContenidoPracticanteFacade;
import com.gbm.entidades.CprContenido;
import com.gbm.entidades.CprHistContenidoPracticante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "controladorHistPracticante", urlPatterns = {"/controladorHistPracticante"})
public class controladorHistPracticante extends HttpServlet {

    @EJB
    CprHistContenidoPracticanteFacade cprHistorico;

    @EJB
    CprContenidoFacade cprContenido;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "mostrarAsignacion":
                this.mostrarAsignacion(request, response);
                break;
        }
    }

    //METODOS SOBRE GET
    private void mostrarAsignacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CprHistContenidoPracticante> historicos = cprHistorico.findAll();

        int idPracticante = Integer.parseInt(request.getParameter("id"));

        List<CprHistContenidoPracticante> historicosPracticante = new ArrayList();

        if (historicos.isEmpty()) {

        } else {
            for (CprHistContenidoPracticante historico : historicos) {

                if (historico.getCprPracticantes().getBcsUsuario().getCodUsuario() == idPracticante) {
                    historicosPracticante.add(historico);
                }
            }

            request.setAttribute("historicosPracticante", historicosPracticante);
            request.getRequestDispatcher("/vistas/practicante/mostrarAsignaciones.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "insert":
                this.insert(request, response);
                break;
        }

    }

    //METODOS SOBRE POST
    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idPracticante = Integer.parseInt(request.getParameter("idPracticante"));
        int idCiclo = Integer.parseInt(request.getParameter("ciclo"));
        int idContenido = Integer.parseInt(request.getParameter("contenido"));

        CprContenido contenido = cprContenido.find(idContenido);

        CprHistContenidoPracticante historia = new CprHistContenidoPracticante(idCiclo, idPracticante);
        historia.setIdContenido(contenido);

        List<CprHistContenidoPracticante> listaHistoria = cprHistorico.findAll();

        boolean diferente = true;

        for (CprHistContenidoPracticante historicos : listaHistoria) {
            if (historia.getCprHistContenidoPracticantePK().getCodUsuarioHist() == historicos.getCprHistContenidoPracticantePK().getCodUsuarioHist()) {
                if (historia.getCprHistContenidoPracticantePK().getIdCicloHist() == historicos.getCprHistContenidoPracticantePK().getIdCicloHist()) {
                    diferente = false;
                }
            }
        }

        if (diferente == true) {
            cprHistorico.create(historia);
            request.setAttribute("tituloMensaje", "Registro exitoso");
            request.setAttribute("cuerpoMensaje", "Se ha añadido el registro de forma correcta");
            request.setAttribute("urlMensaje", "/index.jsp");
            request.getRequestDispatcher("/vistas/practicante/mensaje.jsp").forward(request, response);
        } else {
            request.setAttribute("tituloMensaje", "Error en el registro");
            request.setAttribute("cuerpoMensaje", "No se puede asignar al mismo ciclo");
            request.setAttribute("urlMensaje", "/index.jsp");
            request.getRequestDispatcher("/vistas/practicante/mensaje.jsp").forward(request, response);
        }

        cprHistorico.create(historia);

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

}
