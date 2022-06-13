package com.gbm.controladores;

import com.gbm.dao.BcsBitacoraFacade;
import com.gbm.entidades.BcsBitacora;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "controladorBitacoraUsu", urlPatterns = {"/controladorBitacoraUsu"})
public class controladorBitacoraUsu extends HttpServlet {

    @EJB
    BcsBitacoraFacade bcsBitacoraFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "read":
                this.read(request, response);
                break;
        }
    }

//Metodos sobre GET
    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<BcsBitacora> bitacoras = bcsBitacoraFacade.findAll();

        request.setAttribute("bitacoras", bitacoras);

        request.getRequestDispatcher("vistas/usuario/bitacoraUsuario.jsp").forward(request, response);

    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int tipoBusqueda = Integer.parseInt(request.getParameter("buscarTipo"));

        String cadena = "";

        switch (tipoBusqueda) {
            case 1:
                cadena = "TODOS";
                break;
            case 2:
                cadena = "CREATE";
                break;
            case 3:
                cadena = "UPDATE";
                break;
            case 4:
                cadena = "DELETE";
                break;
            case 5:
                cadena = "SELECT";
                break;

        }

        List<BcsBitacora> bitacoras = bcsBitacoraFacade.findAll();

        List<BcsBitacora> bitacoraBusqueda = new ArrayList();

        if (bitacoras.isEmpty()) {
            System.out.println("Lista vacia");
        } else {

            if ("TODOS".equals(cadena)) {
                request.setAttribute("bitacoras", bitacoras);
                request.getRequestDispatcher("/vistas/usuario/bitacoraUsuario.jsp").forward(request, response);
            } else {
                for (BcsBitacora bcsBitacora : bitacoras) {

                    if (bcsBitacora.getTioTransaccion().equals(cadena)) {
                        bitacoraBusqueda.add(bcsBitacora);
                    }
                }
                request.setAttribute("bitacoras", bitacoraBusqueda);
                request.getRequestDispatcher("/vistas/usuario/bitacoraUsuario.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "buscar":
                this.buscar(request, response);
                break;
        }
    }
}
