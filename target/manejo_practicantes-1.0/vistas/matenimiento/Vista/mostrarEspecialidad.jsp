<%@include file="../../../top.jsp" %>
<h2 style="text-align: center">Mostrar Especialidades</h2>
<table class="table table-hover table-bordered" style="width: 80% !important;">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Id Especialidad</th>
            <th>Descripcion</th>
            <th>Actualizar</th>
            <th>Eliminar</th>

        </tr>
    </thead>
    <c:forEach var = "Especialidad" items= "${Especialidades}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${Especialidad.getIdEspecialidad()}</td>
                <td>${Especialidad.getDesEspecialidad()}</td>
                <td><a href="${pageContext.request.contextPath}/controladorEspecialidad?accion=selectId&idEspecialidad=${Especialidad.getIdEspecialidad()}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/controladorEspecialidad?accion=delete&idEspecialidad=${Especialidad.getIdEspecialidad()}" class="btn btn-danger">Eliminar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../../bottom.jsp" %>
