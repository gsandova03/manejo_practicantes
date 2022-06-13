<%@include file="../../../top.jsp" %>
<h3 class="text-center">Actualizar la Institucion</h3>
<br/>
<form action="${pageContext.request.contextPath}/ControladorRol?accion=update" method="post" name="formInsertarRol"><!-- Formulario de insertar Rol --> 
    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Rol</label> 
        <input type="text" name="idRol"  class="form-control" id="exampleFormControlInput1" value="${RolSelect.getIdRol()}" readonly>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Nombre</label>
        <textarea name="descRol" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${RolSelect.getNomRol()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>
