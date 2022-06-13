<%@include file="../../../top.jsp" %>
<h3 class="text-center">Registrar Ciclos</h3>
<br>
<form action="${pageContext.request.contextPath}/controladorCiclos?accion=insert" method="post" name="formInsertarCarrera"><!-- Formulario de insertar Carrerqa -->

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descCiclos" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${InstitutoSelect.getDesCarrera()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>
