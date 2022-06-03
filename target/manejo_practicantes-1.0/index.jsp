<%-- 
    Document   : index
    Created on : 26/05/2022, 11:14:27 a. m.
    Author     : gsandoval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo practicantes</title>
    </head>
    <body>
        <h1>Manejo practicantes</h1>
        <br/>
        <a href="${pageContext.request.contextPath}/vistas/login/registro_usuario.jsp">Registrar usuario</a><br/>
        <br/>
        <a href="${pageContext.request.contextPath}/vistas/login/login.jsp">Login</a>
        <br/>
        <a href="${pageContext.request.contextPath}/Practicante?accion=listar">listar practicante</a>
        <br/>
        <a href="${pageContext.request.contextPath}/vistas/matenimiento/index.jsp">Tablas mantenimiento</a>
    </body>
</html>
