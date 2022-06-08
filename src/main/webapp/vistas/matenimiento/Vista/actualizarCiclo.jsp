<%@include file="../../../top.jsp" %>
<h1>Actualizar el Ciclo</h1>
<br/>
<form action="${pageContext.request.contextPath}/controladorCiclos?accion=update" method="post" name="formInsertarCiclo"><!-- Formulario de insertar Ciclo --> 
    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Genero</label> 
        <input type="text" name="idCiclo"  class="form-control" id="exampleFormControlInput1" value="${ciclosSelect.getIdCiclo()}" readonly>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descCiclo" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${ciclosSelect.getDesCiclo()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>