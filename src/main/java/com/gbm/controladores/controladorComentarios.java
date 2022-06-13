package com.gbm.controladores;

import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.dao.CprComentariosFacade;
import com.gbm.dao.CprPracticantesFacade;
import com.gbm.entidades.BcsUsuario;
import com.gbm.entidades.CprComentarios;
import com.gbm.entidades.CprPracticantes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controladorComentarios", urlPatterns = {"/controladorComentarios"})
public class controladorComentarios extends HttpServlet {

    @EJB
    CprPracticantesFacade cprPracticanteFacade;

    @EJB
    CprComentariosFacade cprComentariosFacade;

    @EJB
    BcsUsuarioFacade cprBcsUsuario;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "select":
                this.select(request, response);
                break;
            case "read":
                this.read(request, response);
                break;
            case "delete":
                this.delete(request, response);
            case "selectComen":
                this.selectComen(request, response);

        }
    }

    //Metodos sobre Get
    private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        CprPracticantes comentarioPracticante = cprPracticanteFacade.find(id);

        request.setAttribute("comentarioPracticante", comentarioPracticante);

        request.getRequestDispatcher("/vistas/practicante/insertarComentario.jsp").forward(request, response);
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CprComentarios> comentarios = cprComentariosFacade.findAll();

        request.setAttribute("comentarios", comentarios);

        request.getRequestDispatcher("vistas/practicante/mostrarComentarios.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idComentario = Integer.parseInt(request.getParameter("id"));

        CprComentarios comentarioABorrar = cprComentariosFacade.find(idComentario);

        cprComentariosFacade.remove(comentarioABorrar);

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    private void selectComen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        List<CprComentarios> comentarios = cprComentariosFacade.findAll();

        List<CprComentarios> comentariosPracticante = new ArrayList();

        if (comentarios.isEmpty()) {
            System.out.println("Lista vacia");

        } 
        else {
            for (CprComentarios comentario : comentarios) {

                if (comentario.getCodUsuarioComentario().getBcsUsuario().getCodUsuario() == id) {
                    comentariosPracticante.add(comentario);
                }
            }
            request.setAttribute("comentariosPracticante", comentariosPracticante);
            request.getRequestDispatcher("/vistas/practicante/mostrarComentariosPract.jsp").forward(request, response);
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

    //Metodos sobre Post
    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idPracticante = Integer.parseInt(request.getParameter("idPracticante"));

        BcsUsuario usuario = cprBcsUsuario.find(idPracticante);

        CprPracticantes practicante = cprPracticanteFacade.find(idPracticante);

        String Comentario = request.getParameter("comentarioPracticante");

        String Fecha = request.getParameter("fechaComentario");

        CprComentarios comentario = new CprComentarios();

        comentario.setIdUsuarioCreaComentario(usuario);

        comentario.setCodUsuarioComentario(practicante);

        comentario.setDesComentario(Comentario);

        comentario.setFecComentario(Fecha);

        cprComentariosFacade.create(comentario);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}