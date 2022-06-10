<%-- 
    Document   : listarPracticantes
    Created on : 1/06/2022, 5:50:58 p. m.
    Author     : gsandoval
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/Practicante?accion=leer">Crear practicante</a>
        <h1>Practicantes</h1>

        <div class="container">
            <table class="table table-hover">
                <thead>
                    <tr class="table-dark">
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Fecha ingreso</th>
                        <th>Institucion</th>
                        <th style="text-align: center" colspan="4">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${listaUsuario}" varStatus="status">
                        <tr>
                            <td class="table-secondary">${usuario.codUsuarioPract}</td>
                            <td class="table-light">${usuario.bcsUsuario.nomUsuario}</td>
                            <td class="table-light">${usuario.fecIngreso}</td>
                            <td class="table-light">${usuario.idInstitucion.desInstitucion}</td>
                            <td class="table-light"><a class="btn btn-warning" href="${pageContext.request.contextPath}/Practicante?accion=actualizar&id=${usuario.bcsUsuario.cedUsuario}">Editar</a></td>
                            <td class="table-light"><a class="btn btn-warning" href="${pageContext.request.contextPath}/Practicante?accion=valorarPracticante&id=${usuario.codUsuarioPract}">Valorar Practicante</a></td>
                            <td class="table-light"><a class="btn btn-warning" href="${pageContext.request.contextPath}/controladorComentarios?accion=select&id=${usuario.codUsuarioPract}">Crear Comentario</a></td>
                            <td class="table-light"><a class="btn btn-warning" href="${pageContext.request.contextPath}/controladorComentarios?accion=selectComen&id=${usuario.codUsuarioPract}">Ver Comentario</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
