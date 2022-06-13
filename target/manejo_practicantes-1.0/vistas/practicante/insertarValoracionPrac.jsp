<%@include file="../../top.jsp" %>
<div class="container d-flex justify-content-center align-items-center">
    <form action="${pageContext.request.contextPath}/controladorValoracionPracticante?accion=insert" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Id del practicante</label>
            <input type="text" name="idPracticante" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${practicanteValorar.codUsuarioPract}" readonly>
        </div>
        <div class="mb-3">
            <div class="mb-3">
                <label for="disabledSelect" class="form-label">Ciclos</label>
                <select id="disabledSelect" class="form-select" name="idCiclo" required>
                    <c:forEach var="ListaCiclo" items="${listaCiclo}">
                        <option value="${ListaCiclo.idCiclo}">${ListaCiclo.desCiclo}</option>                            
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="disabledSelect" class="form-label">Valoracion</label>
                <select id="disabledSelect" class="form-select" name="idValoracion" required>
                    <c:forEach var="ListaValoracion" items="${listaValoracion}">
                        <option value="${ListaValoracion.idValoracion}">${ListaValoracion.desDescripcion}</option>                            
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
    </form>
</div>
<%@include file="../../bottom.jsp" %>