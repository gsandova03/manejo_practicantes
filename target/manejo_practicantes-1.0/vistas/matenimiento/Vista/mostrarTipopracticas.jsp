<%@include file="../../../top.jsp" %>
<h2 style="text-align: center">Lista instituciones</h2>
<table class="table table-hover table-bordered" style="width: 80% !important;">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Id Descripcion</th>
            <th>Descripcion</th>
            <th>Actualizar</th>
            <th>Eliminar</th>

        </tr>
    </thead>
    <c:forEach var = "ListaPracticas" items= "${listaPracticas}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${ListaPracticas.getIdPractica()}</td>
                <td>${ListaPracticas.getDesPractica()}</td>
                <td><a href="${pageContext.request.contextPath}/controladorTipoPracticas?accion=selectid&idTipoPractica=${ListaPracticas.getIdPractica()}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/controladorTipoPracticas?accion=delete&idTipoPractica=${ListaPracticas.getIdPractica()}" class="btn btn-danger">Eliminar</a></td>
            </tr>
    </c:forEach>
</tbody>
</table>
<%@include file="../../../bottom.jsp" %>
