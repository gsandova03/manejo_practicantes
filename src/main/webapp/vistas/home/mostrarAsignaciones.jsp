<%@include file="../../topPracticante.jsp" %>
<h3 class="text-center">Asignaciones del practicante</h3>
<br>
<table class="table table-hover table-bordered">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>#</th>
            <th>Ciclo</th>
            <th>Contenido</th>

        </tr>
    </thead>
    <c:forEach var = "historias" items= "${HistIndividual}" varStatus="status">
        <tbody>
            <tr>
                <td>${status.count}</td>
                <td>${historias.getCprCiclos().getDesCiclo()}</td>
                <td>${historias.getIdContenido().getDesContenido()}</td>
                
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../bottom.jsp" %>
