<%-- 
    Document   : mostrarContenido
    Created on : 9/06/2022, 09:55:34 PM
    Author     : JOHANN FILOT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Carrera</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class=".container, .sp_center-flex" style="width: 100%;display: flex;flex-wrap: wrap;align-content: center;justify-content: center;flex-direction: column; padding-top: 10%;">
        <h2 style="text-align: center">Lista Contenido</h2>
    <table class="table table-hover table-bordered" style="width: 80% !important;">
       <thead style="background-color: #0a58ca; color: #fff" >
            <tr>
                <th>#</th>
                <th>Id Contenido</th>
                <th>Descripcion</th>
                <th>Actualizar</th>
                <th>Eliminar</th>
                
            </tr>
        </thead>
        <c:forEach var = "contenido" items= "${Contenidos}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${contenido.getIdContenido()}</td>
                <td>${contenido.desContenido}</td>
                <td><a href="${pageContext.request.contextPath}/controladorCont?accion=selectid&idContenido=${contenido.idContenido}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/controladorCont?accion=delete&idContenido=${contenido.idContenido}" class="btn btn-danger">Eliminar</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        </div>
    </body>
</html>
