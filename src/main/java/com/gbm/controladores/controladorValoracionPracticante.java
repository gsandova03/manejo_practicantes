package com.gbm.controladores;

import com.gbm.dao.CprValoracionPracticantesFacade;
import com.gbm.entidades.CprValoracionPracticantes;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Valoraciones")
public class controladorValoracionPracticante extends HttpServlet{
    @EJB
    private CprValoracionPracticantesFacade valoracionPracticanteFacade;
    
    
    private CprValoracionPracticantes cprValPracticantes;
    HttpSession sesion;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "listar":
                obtenerDatos(request, response);
                break;
        }
    }
    
//    public void obtenerDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        int ciclo = 1;
//        
////        cprValPracticantes = valoracionPracticanteFacade.obtenerCantidadValoracion();
////        
////        request.setAttribute("Cantidad", cprValPracticantes);
//
//        List<CprValoracionPracticantes> valoraciones = valoracionPracticanteFacade.findAll();
//        int count = 0;
//        
//        for(CprValoracionPracticantes cvp: valoraciones){
//            if(cvp.getCprCiclos().getIdCiclo() == 1){
//                count++;
//            }
//        }
//        
//        request.setAttribute("Cantidad", count);
//        request.getRequestDispatcher("vistas/home/dashboard.jsp").forward(request, response);
//    }
    
    public void obtenerDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
}
