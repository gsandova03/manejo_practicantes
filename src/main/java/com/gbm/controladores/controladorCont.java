
package com.gbm.controladores;

import com.gbm.dao.CprContenidoFacade;
import com.gbm.entidades.CprContenido;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jfilot
 */
@WebServlet(name = "controladorCont", urlPatterns = {"/controladorCont"})
public class controladorCont extends HttpServlet {

    @EJB
    CprContenidoFacade cprCont;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        }else{
            
    }
}

private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        CprContenido objCont = new CprContenido();
        
        String cadena = request.getParameter("CprContenido").trim();
        
        if (cadena.equals("")){
            request.setAttribute("tituloContenido", "Error al ingresar Contenido");
            request.setAttribute("cuerMensaje","La descrpcion esta vacia");
            request.getAttribute("contenidoSelect");
            request.getRequestDispatcher("/Vista/contenido/insert.jsp").forward(request, response);
        } else{
            objCont.setDesContenido(cadena);
            cprCont.create(objCont);
            request.setAttribute("tituloContenido", "Registro exitoso");
            request.setAttribute("cuerMensaje","Se ingreso el registro");
            request.setAttribute("urlMensaje","ingresar la ruta");
            List< CprContenido > contenido = cprCont.findAll();
            request.setAttribute("Contenidos",contenido );
            request.getRequestDispatcher("/vistas/contenido/mostrarContenido.jsp").forward(request, response);
            
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String cadena = request.getParameter("desContenido").trim();
        
        if(cadena.equals("")){
            request.setAttribute("tituloContenido", "Error  al registar");
            request.setAttribute("cuerMensaje", "La descripcion esta vacia");
            request.setAttribute("urlMensaje", "/vistas/contenido/msn.jsp");
            request.getRequestDispatcher("/vistas/contenido/actualizarContenido.jsp").forward(request, response);
        }else{
            CprContenido objUpdate = new CprContenido();
            objUpdate.setIdContenido(Integer.parseInt(request.getParameter("CprContenido")));
            objUpdate.setDesContenido(cadena);
            cprCont.edit(objUpdate);
            request.setAttribute("tituloMensaje","Registro exitoso");
            request.setAttribute("cuerMensaje", "Se actualizo el registro");
            request.setAttribute("urlMensaje", "ruta del index");
            request.getRequestDispatcher("/vistas/contenido/msn.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String accion = request.getParameter("accion");
        
        if(accion != null){
            switch (accion){
                case "read":
                    this.read(request, response);
                    break;
                case "update":
                    break;
                case "delete":
                    this.delete(request,response);
                case "selectid":
                    this.selectId(request, response);
                    break;
            }
        }
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CprContenido> contenido = cprCont.findAll();
        
        if(contenido.isEmpty()){
            request.setAttribute("tituloMensaje", "Registro fallido");
            request.setAttribute("cuerMensaje"," N o hay reagistro en la base");
            request.setAttribute("urlMensaje", "ruta del index");
            request.getRequestDispatcher("/vistas/contenido/msn.jsp").forward(request, response);
        }else{
            request.setAttribute("Contenidos",contenido );
            request.getRequestDispatcher("/vistas/contenido/mostrarContenido.jsp").forward(request, response);
            
        }
    }

    private void selectId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idContenido"));
        CprContenido contenidoSelect = cprCont.find(id);
        request.setAttribute("contenidoSelect", contenidoSelect);
        request.getRequestDispatcher("/vistas/contenido/actualizarContenido.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("idContenido"));
       CprContenido conteDelete = cprCont.find(id);
       cprCont.remove(conteDelete);
       request.setAttribute("tituloMensaje", "Eliminacion exitosa");
       request.setAttribute("cuerMensaje","Se elimino el contenido");
       request.setAttribute("urlMensaje", "/vistas/contenido/mostrarContenido.jsp");
       request.getRequestDispatcher("/vistas/contenido/msn.jsp").forward(request, response);
       
    }
    
   

}
