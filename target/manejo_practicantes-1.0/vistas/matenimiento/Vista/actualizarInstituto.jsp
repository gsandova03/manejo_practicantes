<%@include file="../../../top.jsp" %>
<h1>Actualizar la Institucion</h1>
<br/>
<form action="${pageContext.request.contextPath}/controladorInstitucion?accion=update" method="post" name="formInsertarInstitucion"><!-- Formulario de insertar Institucion --> 
    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Institucion</label> 
        <input type="text" name="idInstituto"  class="form-control" id="exampleFormControlInput1" value="${InstitutoSelect.getIdInstitucion()}" readonly>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descInstitucion" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${InstitutoSelect.getDesInstitucion()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>