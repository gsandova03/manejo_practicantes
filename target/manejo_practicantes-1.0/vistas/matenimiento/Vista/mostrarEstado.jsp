<%@include file="../../../top.jsp" %>
<h2 style="text-align: center">Mostrar Estados</h2>
<table class="table table-hover table-bordered" style="width: 80% !important;">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Id Estado</th>
            <th>Nombre</th>
            <th>Actualizar</th>
            <th>Eliminar</th>

        </tr>
    </thead>
    <c:forEach var = "ListaEstado" items= "${listaEstado}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${ListaEstado.getIdEstado()}</td>
                <td>${ListaEstado.getDesEstados()}</td>
                <td><a href="${pageContext.request.contextPath}/ControladorEstado?accion=selectId&idEstado=${ListaEstado.getIdEstado()}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/ControladorEstado?accion=delete&idEstado=${ListaEstado.getIdEstado()}" class="btn btn-danger">Eliminar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../../bottom.jsp" %>
