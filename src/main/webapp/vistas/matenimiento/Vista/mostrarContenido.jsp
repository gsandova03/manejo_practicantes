<%@include file="../../../top.jsp" %>
<h3 class="text-center mb-3">Lista Contenido</h3>
<table class="table table-hover table-bordered">
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
<%@include file="../../../bottom.jsp" %>