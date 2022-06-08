<%@include file="../../../top.jsp" %>
<h1>Registrar el tipo de practica</h1>

<form action="${pageContext.request.contextPath}/controladorTipoPracticas?accion=insert" method="post" name="formInsertarTipopractica"><!-- Formulario de insertar Tipo practicas -->

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion: </label>
        <textarea name="descTipoPracticas" class="form-control" id="exampleFormControlTextarea1" rows="3" required></textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>

</form>
<%@include file="../../../bottom.jsp" %>
