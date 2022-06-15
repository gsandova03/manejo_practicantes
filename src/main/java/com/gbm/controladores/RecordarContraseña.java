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
import javax.mail.PasswordAuthentication;
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

        String to = destino;

        String from = correo;

        String host = "localhost";
        


        final String username = correo;
        final String password = contra;

        System.out.println("TLSEmail Start");

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.port", 4848);

        properties.put("mail.smtp.auth", "true");

        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication
                    getPasswordAuthentication() {
                return new PasswordAuthentication("username",
                        "password");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            // header field of the header.
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject("subject");
            message.setText("Hello, aas is sending email ");

            // Send message
            Transport.send(message);
            System.out.println("Yo it has been sent..");
        } catch (MessagingException mex) {
            mex.printStackTrace(System.out);
        }

    }

}

