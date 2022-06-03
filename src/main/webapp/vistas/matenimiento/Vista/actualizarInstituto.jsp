<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Actualizar Institucion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class=".container sp_center-flex" style="width: 100%;display: flex;flex-wrap: wrap;align-content: center;justify-content: center;flex-direction: column; padding-top: 10%;">
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
        </div>

        
    </body>
</html>
