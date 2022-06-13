<%@include file="../../../top.jsp" %>
<h3 style="text-align: center">Mostrar Ciclos</h3>
<br>
<table class="table table-hover table-bordered">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Id Ciclo</th>
            <th>Descripcion</th>
            <th>Actualizar</th>
            <th>Eliminar</th>

        </tr>
    </thead>
    <c:forEach var = "ListaCiclos" items= "${listaCiclos}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${ListaCiclos.getIdCiclo()}</td>
                <td>${ListaCiclos.getDesCiclo()}</td>
                <td><a href="${pageContext.request.contextPath}/controladorCiclos?accion=selectId&idCiclo=${ListaCiclos.getIdCiclo()}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/controladorCiclos?accion=delete&idCiclo=${ListaCiclos.getIdCiclo()}" class="btn btn-danger">Eliminar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../../bottom.jsp" %>
