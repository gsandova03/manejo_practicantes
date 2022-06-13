<%@include file="../../top.jsp" %>



<form action="${pageContext.request.contextPath}/controladorBitacoraUsu?accion=buscar" method="POST" style="margin-bottom: 50px">
    <div class="input-group">
        <select class="form-select" id="inputGroupSelect04" aria-label="Elige tipo de consulta" name="buscarTipo">
            <option selected>Elige tipo de consulta</option>
            <option value="1">TODOS</option>
            <option value="2">CREATE</option>
            <option value="3">UPDATE</option>
            <option value="4">DELETE</option>
            <option value="5">SELECT</option>
        </select>
        <input type="submit" name="buscarTipo" class="btn btn-primary" value="Buscar">
    </div>
</form>
<div class="list-group">
    <c:forEach var="Bitacora" items="${bitacoras}" varStatus="status">
        <a href="#" class="list-group-item list-group-item-action">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">${Bitacora.getTioTransaccion()} - ${Bitacora.getIdBitacora()}</h5>
                <small>${Bitacora.getFecBitacora()}</small>
            </div>
            <p class="mb-1">${Bitacora.getDesTransaccion()}</p>
            <small> <b>Usuario:</b> ${Bitacora.getCodUsuario().getNomUsuario()}.</small>
        </a>
    </c:forEach>
</div>
<%@include file="../../bottom.jsp" %>