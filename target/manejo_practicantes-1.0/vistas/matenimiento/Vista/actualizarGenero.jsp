<%@include file="../../../top.jsp" %>
<h1>Actualizar la Institucion</h1>
<br/>
<form action="${pageContext.request.contextPath}/controladorGenero?accion=update" method="post" name="formInsertarGenero"><!-- Formulario de insertar Genero --> 
    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Genero</label> 
        <input type="text" name="idGenero"  class="form-control" id="exampleFormControlInput1" value="${generoSelect.getIdGenero()}" readonly>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descGenero" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${generoSelect.getDesGenero()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>
