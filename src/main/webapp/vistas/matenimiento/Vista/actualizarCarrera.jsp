<%@include file="../../../top.jsp" %>
<h3 class="text-center">Actualizar la Carrera</h3>
<br>
<form action="${pageContext.request.contextPath}/controladorCarrera?accion=update" method="post" name="formInsertarCarrera"><!-- Formulario de insertar Carrera -->            

    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Carrera:</label> 
        <input type="text" name="idCarrera"  class="form-control" id="exampleFormControlInput1" value="${carreraSelect.getIdCarrera()}" readonly>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descCarrera" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${carreraSelect.getDesCarrera()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>
