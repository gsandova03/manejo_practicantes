/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gbm.controladores;

import com.gbm.dao.BcsUsuarioFacade;
import com.gbm.entidades.BcsUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@WebServlet(name = "RecordarContraseña", urlPatterns = {"/RecordarContrase_a"})
public class RecordarContraseña extends HttpServlet {

    @EJB
    BcsUsuarioFacade usuarioFacade;

    private BcsUsuario usuarioB;
    private String UsuarioParaBuscarContra;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        RecordarContraseña k = new RecordarContraseña();
        this.UsuarioParaBuscarContra = request.getParameter("usuario");

        if (this.UsuarioParaBuscarContra == null) {
            sesion.setAttribute("CampoVacio", "El campo del usuario esta vacio");
            response.sendRedirect("../RecupContrasena/Rcontrasena.jsp");
        } else {
            try {
                this.usuarioB = this.usuarioFacade.buscarPorCorreoC(this.UsuarioParaBuscarContra);
                try {
                    String correo = this.usuarioB.getEmiCoorporativo();
                    String contra = this.usuarioB.getPswUsuario();
                    k.EnviarMensaje(correo, contra, this.usuarioB.getEmiPersonal());
                    out.print("Se envio el correo");
                } catch (MessagingException ex1) {
                    Logger.getLogger(RecordarContraseña.class.getName()).log(Level.SEVERE, null, ex1);
                }

            } catch (Exception ex) {

                if (this.usuarioB == null) {
                    sesion.setAttribute("CampoVacio", "El campo del usuario esta vacio");
                    response.sendRedirect("../RecupContrasena/Rcontrasena.jsp");
                    ex.getMessage();
                }
            }
        }
    }

    public void EnviarMensaje(String correo, String contra, String destino) throws AddressException, MessagingException {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        //Para la dirección nomcuenta@gmail.com

        String remitenteD = "enriquefilot";
        String contraCuentaD = "142079Filot*";
        
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitenteD);
        props.put("mail.smtp.clave", contraCuentaD);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitenteD));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));   //Se podrían añadir varios de la misma manera
            message.setSubject("Recuperar contrseña de control de practicantes");
            message.setText("Usuario: " + correo);
            message.setText("Contraseña: " + contra);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitenteD, contraCuentaD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
