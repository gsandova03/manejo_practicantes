<%@include file="../../../top.jsp" %>
<h3 class="text-center">Registrar Especialidad</h3>
<br>
<form action="${pageContext.request.contextPath}/controladorEspecialidad?accion=insert" method="post" name="formInsertarEspcialidad"><!-- Formulario de insertar Especialidad -->

    <div class="mb-1">
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descEspecialidad" class="form-control" id="exampleFormControlTextarea1" rows="3" required></textarea>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>
