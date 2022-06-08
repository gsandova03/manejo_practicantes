<%@include file="../../../top.jsp" %>
<h2 style="text-align: center">Lista de Roles</h2>
<table class="table table-hover table-bordered" style="width: 80% !important;">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Id Roles</th>
            <th>Nombre</th>
            <th>Actualizar</th>
            <th>Eliminar</th>

        </tr>
    </thead>
    <c:forEach var = "ListaRoles" items= "${listaRoles}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${ListaRoles.getIdRol()}</td>
                <td>${ListaRoles.getNomRol()}</td>
                <td><a href="${pageContext.request.contextPath}/ControladorRol?accion=selectid&idRol=${ListaRoles.getIdRol()}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/ControladorRol?accion=delete&idRol=${ListaRoles.getIdRol()}" class="btn btn-danger">Eliminar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../../bottom.jsp" %>
