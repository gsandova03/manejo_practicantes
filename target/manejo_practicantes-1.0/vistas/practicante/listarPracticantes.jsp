<%@include file="../../top.jsp" %>
<a  class="btn btn-primary" href="${pageContext.request.contextPath}/Practicante?accion=leer">Crear practicante</a>
<h1>Practicantes</h1>

<div class="container">
    <table class="table table-hover">
        <thead>
            <tr class="table-dark">
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Fecha ingreso</th>
                <th>Institucion</th>
                <th>Acciones</th>
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
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../../bottom.jsp" %>
