<%@include file="../../../top.jsp" %>
<h3 class="text-center">Registrar la Valoración</h3>
<br>
<form action="${pageContext.request.contextPath}/controladorValoraciones?accion=insert" method="post" name="formInsertarTipopractica"><!-- Formulario de insertar Tipo practicas -->


    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Valoracion</label>
        <input type="text" name="idValoracion" class="form-control" id="exampleFormControlInput1" placeholder="Digite la valoracion" maxlength="3" required>
    </div>

    <div class="mb-1">          
        <label for="exampleFormControlTextarea1" class="form-label">Descripcion: </label>
        <textarea name="descValoracion" class="form-control" id="exampleFormControlTextarea1" rows="3" required></textarea><br/>
    </div>

    <div class="col-auto">
        <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
    </div>

</form>
<%@include file="../../../bottom.jsp" %>
