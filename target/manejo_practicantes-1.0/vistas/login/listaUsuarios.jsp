<%-- 
    Document   : listaUsuarios
    Created on : 1 jun 2022, 14:03:27
    Author     : jfilot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center">Lista usuarios</h1><br>
        <div class="container w-100">
            <table class="table table-hover table-responsive w-auto text-center">
                <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Id usuario</th>
                        <th>Nombre</th>
                        <th>Cedula</th>
                        <th>Fecha de nacimiento</th>
                        <th>Direccion</th>
                        <th>Correo Corporativo</th>
                        <th>Correo Personal</th>
                        <th>Rol</th>
                        <th>Actualizar</th>
                        <th>Elminar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="lista_de_usuario" items="${ListaUsuarios}" varStatus="status" >
                        <tr>
                            <td>${status.count}</td>
                            <td>${lista_de_usuario.codUsuario}</td>
                            <td>${lista_de_usuario.nomUsuario}</td>
                            <td>${lista_de_usuario.cedUsuario}</td>
                            <td>${lista_de_usuario.fecNacimiento}</td>
                            <td>${lista_de_usuario.dirFisica}</td>
                            <td>${lista_de_usuario.emiCoorporativo}</td>
                            <td>${lista_de_usuario.emiPersonal}</td>
                            <td>${lista_de_usuario.idRol.nomRol}</td>
                            <td><a href="${pageContext.request.contextPath}/BscUsuarioControlador?accion=select&idUsuario=${lista_de_usuario.codUsuario}" class="btn btn-primary">Actualizar</a></td>
                            <td><a href="#" class="btn btn-primary">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
