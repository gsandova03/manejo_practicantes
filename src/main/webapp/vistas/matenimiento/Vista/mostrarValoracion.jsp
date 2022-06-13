<%@include file="../../../top.jsp" %>
<h3 style="text-align: center">Lista de Valoraciones</h3>
<br>
<table class="table table-hover table-bordered">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Id Valoraciones</th>
            <th>Descripcion</th>
            <th>Actualizar</th>
            <th>Eliminar</th>

        </tr>
    </thead>
    <c:forEach var = "ListaValoraciones" items= "${listaValoraciones}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${ListaValoraciones.getIdValoracion()}</td>
                <td>${ListaValoraciones.getDesDescripcion()}</td>
                <td><a href="${pageContext.request.contextPath}/controladorValoraciones?accion=selectId&idValoracion=${ListaValoraciones.getIdValoracion()}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/controladorValoraciones?accion=delete&idValoracion=${ListaValoraciones.getIdValoracion()}" class="btn btn-danger">Eliminar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../../bottom.jsp" %>
