<%@include file="../../../top.jsp" %>
<h1>Actualizar el Estado</h1>
<br/>
<form action="${pageContext.request.contextPath}/ControladorEstado?accion=update" method="post" name="formInsertarEstado"><!-- Formulario de insertar Estado --> 
    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Genero</label> 
        <input type="text" name="idEstado"  class="form-control" id="exampleFormControlInput1" value="${estadoSelect.getIdEstado()}" readonly>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descEstado" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${estadoSelect.getDesEstados()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>
