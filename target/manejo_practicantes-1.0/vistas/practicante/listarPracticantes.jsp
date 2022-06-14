<%@include file="../../top.jsp" %>
<a  class="btn btn-primary" href="${pageContext.request.contextPath}/Practicante?accion=leer">Crear practicante</a>
<br/>
<br/>
<div class="container">
    <table class="table table-hover">
        <thead>
            <tr class="table-dark text-center">
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Fecha ingreso</th>
                <th>Institucion</th>
                <th>Editar</th>
                <th colspan="2" style="text-align: center">Asignacion</th>
                <th>Crear comentario</th>
                <th>Ver comentarios</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${listaUsuario}" varStatus="status">
                <tr class="text-center">
                    <td class="table-secondary">${usuario.codUsuarioPract}</td>
                    <td class="table-light">${usuario.bcsUsuario.nomUsuario}</td>
                    <td class="table-light">${usuario.fecIngreso}</td>
                    <td class="table-light">${usuario.idInstitucion.desInstitucion}</td>
                    <td class="table-light"><a class="btn btn-warning" href="${pageContext.request.contextPath}/Practicante?accion=actualizar&id=${usuario.bcsUsuario.cedUsuario}">Editar</a></td>
                    <td class="table-light"><a class="btn btn-warning" href="${pageContext.request.contextPath}/Practicante?accion=realizarAsignacion&id=${usuario.codUsuarioPract}">Realizar Asignaci�n</a></td>
                    <td class="table-light"><a class="btn btn-warning" href="${pageContext.request.contextPath}/controladorHistPracticante?accion=mostrarAsignacion&id=${usuario.codUsuarioPract}">Mostrar Asignaciones</a></td>
                    <td class="table-light"><a class="btn btn-warning" href="${pageContext.request.contextPath}/controladorComentarios?accion=select&id=${usuario.codUsuarioPract}">Crear</a></td>   
                    <td class="table-light"><a class="btn btn-warning" href="${pageContext.request.contextPath}/controladorComentarios?accion=selectComen&id=${usuario.codUsuarioPract}">Ver</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../../bottom.jsp" %>
