<%@include file="../../../top.jsp" %>
<h1>Actualizar la Institucion</h1>
<br/>
<form action="${pageContext.request.contextPath}/controladorTipoPracticas?accion=update" method="post" name="formInsertarTipopra"><!-- Formulario de insertar Tipo practicas --> 
    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Institucion</label> 
        <input type="text" name="idTipoPracticas"  class="form-control" id="exampleFormControlInput1" value="${tipoPracticaSelect.getIdPractica()}" readonly>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descTipoPracticas" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${tipoPracticaSelect.getDesPractica()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>
