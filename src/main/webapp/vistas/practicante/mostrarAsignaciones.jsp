<%@include file="../../top.jsp" %>
<h3 class="text-center">Asignaciones del practicante <b>${historicosPracticante.get(0).getCprPracticantes().getBcsUsuario().getNomUsuario()}</b> </h3>
<br>
<table class="table table-hover table-bordered">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Ciclo</th>
            <th>Contenido</th>
            <th>Accion</th>

        </tr>
    </thead>
    <c:forEach var = "historias" items= "${historicosPracticante}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${historias.getCprCiclos().getDesCiclo()}</td>
                <td>${historias.getIdContenido().getDesContenido()}</td>
                <td><a href="${pageContext.request.contextPath}/Practicante?accion=valorarPracticante&idPract=${historias.getCprPracticantes().getBcsUsuario().getCodUsuario()}&idCiclo=${historias.getCprCiclos().getIdCiclo()}" class="btn btn-warning">Valorar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../bottom.jsp" %>
