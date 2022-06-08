<%@include file="../../../top.jsp" %>
<h2 style="text-align: center">Mostrar Especialidades</h2>
<table class="table table-hover table-bordered" style="width: 80% !important;">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Id Genero</th>
            <th>Descripcion</th>
            <th>Actualizar</th>
            <th>Eliminar</th>

        </tr>
    </thead>
    <c:forEach var = "ListaGenero" items= "${listaGenero}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${ListaGenero.getIdGenero()}</td>
                <td>${ListaGenero.getDesGenero()}</td>
                <td><a href="${pageContext.request.contextPath}/controladorGenero?accion=selectId&idGenero=${ListaGenero.getIdGenero()}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/controladorGenero?accion=delete&idGenero=${ListaGenero.getIdGenero()}" class="btn btn-danger">Eliminar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../../bottom.jsp" %>
