<%@include file="../../../top.jsp" %>
<h3 class="text-center mb-1">Actualizar Contenido</h3>
<form action="${pageContext.request.contextPath}/controladorCont?accion=update" method="post">

    <div class="mb-1">
        <label for="exampleFormControlInput1" class="form-label">Id Contenido:</label> 
        <input type="text" name="CprContenido"  class="form-control" id="exampleFormControlInput1" value="${contenidoSelect.getIdContenido()}" readonly>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="desContenido" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${contenidoSelect.getDesContenido()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>