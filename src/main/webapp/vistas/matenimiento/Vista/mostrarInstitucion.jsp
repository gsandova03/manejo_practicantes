<%@include file="../../../top.jsp" %>
<h2 style="text-align: center">Lista instituciones</h2>
<table class="table table-hover table-bordered" style="width: 80% !important;">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Id Institucion</th>
            <th>Descripcion</th>
            <th>Actualizar</th>
            <th>Eliminar</th>

        </tr>
    </thead>
    <c:forEach var = "Institucion" items= "${Instituciones}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${Institucion.getIdInstitucion()}</td>
                <td>${Institucion.getDesInstitucion()}</td>
                <td><a href="${pageContext.request.contextPath}/controladorInstitucion?accion=selectid&idInstitucion=${Institucion.getIdInstitucion()}" class="btn btn-warning">Actualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/controladorInstitucion?accion=delete&idInstitucion=${Institucion.getIdInstitucion()}" class="btn btn-danger">Eliminar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../../bottom.jsp" %>
