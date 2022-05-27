<%-- 
    Document   : login
    Created on : 27 may 2022, 11:18:14
    Author     : jfilot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="${pageContext.request.contextPath}/BcsLoginControlador" id="" method="post">
            Usuario:<input type="text" id="ipn-usuario" name="usuario" >
            Password:<input type="password" id="id" name="password" >
            <input type="submit" value="Iniciar session">
        </form>
           
            <div><p>${UsuarioInvalido}</p></div>
    </body>
</html>
