<%@include file="../../top.jsp" %>
<h3 class="text-center">Lista usuarios</h3>
<br>
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
            <th>Eliminar</th>
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

<%@include file="../../bottom.jsp" %>