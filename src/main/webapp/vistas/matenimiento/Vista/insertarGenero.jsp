<%@include file="../../../top.jsp" %>
<h3 class="text-center">Registrar Genero</h3>
<br>
<form action="${pageContext.request.contextPath}/controladorGenero?accion=insert" method="post" name="formInsertaGenero"><!-- Formulario de insertar Genero -->
    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
        <textarea name="descGenero" class="form-control" id="exampleFormControlTextarea1" rows="3" required></textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>
</form>
<%@include file="../../../bottom.jsp" %>
