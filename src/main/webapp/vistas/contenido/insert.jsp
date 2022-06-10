<%-- 
    Document   : index
    Created on : 9 jun 2022, 15:21:55
    Author     : jfilot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <title>Contenido</title>
    </head>
    <body>
        <div class="sp_center-flex" style="width: 100%;display: flex;flex-wrap: wrap;align-content: center;justify-content: center;flex-direction: column; padding-top: 10%;">
        <h1>Registrar Contenido</h1>
        
        <form action="${pageContext.request.contextPath}/controladorCont?accion=insert" method="post" >
            
            <div class="mb-1">          
                <label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
                <textarea name="CprContenido" class="form-control" id="exampleFormControlTextarea1" rows="3" required>${InstitutoSelect.getDesCarrera()}</textarea><br/>
            </div>
                   
            <div class="col-auto">
                <input type="submit" class="btn btn-primary mb-3" name="enviarDatos">
            </div>
        </form>
    </body>
</html>
