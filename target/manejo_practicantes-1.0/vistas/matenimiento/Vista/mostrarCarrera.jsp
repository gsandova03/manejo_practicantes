<%@include file="../../../top.jsp" %>
<h3 class="text-center">Lista Carreras</h3>
<br>
<table class="table table-hover table-bordered">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Id Carrera</th>
            <th>Descripcion</th>
            <th>Actualizar</th>
            <th>Eliminar</th>

        </tr>
    </thead>
    <c:forEach var = "Carrera" items= "${Carreras}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${Carrera.getIdCarrera()}</td>
                <td>${Carrera.getDesCarrera()}</td>
                <td><a href="${pageContext.request.contextPath}/controladorCarrera?accion=selectid&idCarrera=${Carrera.getIdCarrera()}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/controladorCarrera?accion=delete&idCarrera=${Carrera.getIdCarrera()}" class="btn btn-danger">Eliminar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../../bottom.jsp" %>
