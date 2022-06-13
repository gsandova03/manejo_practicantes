<%@include file="../../../top.jsp" %>
<h3 class="text-center">Actualizar la Especialidad</h3>
<br>
<form action="${pageContext.request.contextPath}/controladorEspecialidad?accion=update" method="post" name="formInsertarEspcialidad"><!-- Formulario de insertar Especialidad -->
    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Especialidad</label> 
        <input type="text" name="idEspacialidad"  class="form-control" id="exampleFormControlInput1" value="${especialidadSelect.getIdEspecialidad()}" readonly>
    </div>                     
    <div class="mb-1">
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descEspecialidad" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${especialidadSelect.getDesEspecialidad()}</textarea><br/>
    </div>
    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form> 
<%@include file="../../../bottom.jsp" %>
