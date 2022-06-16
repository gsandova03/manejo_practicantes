<%@include file="../../../top.jsp" %>
<h3 class="text-center mb-1">Registrar Contenido</h3>

<form action="${pageContext.request.contextPath}/controladorCont?accion=insert" method="post" >

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="CprContenido" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${InstitutoSelect.getDesCarrera()}</textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>