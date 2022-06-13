<%@include file="../../../top.jsp" %>
<h3 class="text-center">Actualizar la valoracion</h3>
<br/>
<form action="${pageContext.request.contextPath}/controladorValoraciones?accion=update" method="post" name="formInsertarTipopra"><!-- Formulario de insertar Tipo practicas --> 
    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Valoración</label> 
        <input type="text" name="idValoracion"  class="form-control" id="exampleFormControlInput1" value="${ValoracionSelect.getIdValoracion()}" readonly>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descValoracion" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${ValoracionSelect.getDesDescripcion()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>