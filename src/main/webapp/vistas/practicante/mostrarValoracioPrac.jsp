<%@include file="../../top.jsp" %>
<div class=".container, .sp_center-flex" style="width: 100%;display: flex;flex-wrap: wrap;align-content: center;justify-content: center;flex-direction: column; padding-top: 10%;">
    <h2 style="text-align: center">Lista de valoraciones a practicantes</h2>
    <table class="table table-hover table-bordered" style="width: 80% !important;">
        <thead style="background-color: #0a58ca; color: #fff" >
            <tr>
                <th>#</th>
                <th>Ciclo</th>
                <th>Nombre practicante</th>
                <th>Calificación</th>
                <th>Actualizar</th>
                <th>Eliminar</th>

            </tr>
        </thead>
        <c:forEach var = "ListaVar" items= "${listaValoraciones}" varStatus="status">
            <tbody>
                <tr>
                    <td>${status.count}</td>
                    <td>${ListaVar.getCprCiclos().getDesCiclo()}</td>
                    <td>${ListaVar.getCprPracticantes().getBcsUsuario().getNomUsuario()}</td>
                    <td>${ListaVar.getIdValoracion().getIdValoracion()}</td>
                    <td><a href="${pageContext.request.contextPath}/Valoraciones?accion=select&idPracticante=${ListaVar.getCprPracticantes().getCodUsuarioPract()}&idCiclo=${ListaVar.getCprCiclos().getIdCiclo()}" class="btn btn-warning">Actualizar</a></td>
                    <td><a href="${pageContext.request.contextPath}" class="btn btn-danger">Eliminar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../../bottom.jsp" %>