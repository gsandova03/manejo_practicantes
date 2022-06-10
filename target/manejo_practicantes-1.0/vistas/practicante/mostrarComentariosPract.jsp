<%-- 
    Document   : formulario_usuario
    Created on : 26/05/2022, 3:22:36 p. m.
    Author     : gsandoval
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/vistas/css/estilosPracticante.css" type="text/css" rel="stylesheet">
        <title>Crear practicante</title>
    </head>

    <body>
        <div class="container text-center">
            <table class="table table-hover table-bordered" style="width: 80% !important;">
                <thead style="background-color: #0a58ca; color: #fff" >
                    <tr>
                        <th>Comentario</th>
                        <th>Fecha</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <c:forEach var="comentarioPract" items="${comentariosPracticante}" varStatus = "status">                
                    <tbody>
                        <tr style="font">
                        <tr>
                            <td class="text-start">
                                ${comentarioPract.getDesComentario()} <br/> <br/>
                                <b>Comentario dado por:</b> ${comentarioPract.getIdUsuarioCreaComentario().getCodUsuario()}<br/>
                                <b>Practicante: </b>${comentarioPract.getCodUsuarioComentario().getBcsUsuario().getNomUsuario()}<br/>
                            </td>
                            <td>${comentarioPract.getFecComentario()}</td>
                            <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/controladorComentarios?accion=delete&id=${comentarioPract.getIdComentarios()}">Borrar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
