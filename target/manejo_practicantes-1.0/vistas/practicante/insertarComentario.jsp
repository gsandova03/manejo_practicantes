
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Comentario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>

        <div class="container d-flex justify-content-center">
            <% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"); %>
            <form action="${pageContext.request.contextPath}/controladorComentarios?accion=insert" method="POST" name="formComentario">
                <h1>Crear comentario</h1>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">ID Usuario</span>
                    <input type="text" name="idPracticante" value="${comentarioPracticante.getBcsUsuario().getCodUsuario()}" class="form-control" placeholder="Id del practicante" aria-label="Id del practicante" aria-describedby="basic-addon1" readonly>
                </div>

                <div class="input-group mb-3">
                    <input type="text" name="nomPracticante" value="${comentarioPracticante.getBcsUsuario().getNomUsuario()}" class="form-control" placeholder="Nombre del practicante" aria-label="Nombre del practicante" aria-describedby="basic-addon2" readonly>
                    <span class="input-group-text" id="basic-addon2">Nombre Practicante</span>
                </div>
                    
                <div class="input-group mb-3">
                    <input type="text" name="fechaComentario" value="<%= dtf.format(LocalDateTime.now()) %>" class="form-control" placeholder="Nombre del practicante" aria-label="Nombre del practicante" aria-describedby="basic-addon2" readonly>
                    <span class="input-group-text" id="basic-addon2">Fecha</span>
                </div>    

                <div class="input-group p-3">
                    <span class="input-group-text">Comentario</span>
                    <textarea class="form-control" name="comentarioPracticante" aria-label="Comentario" style="height: 100px !important"></textarea>
                </div>

                <div class="d-grid gap-2 col-6 mx-auto">
                    <input type="submit" name="enviarDatos" class="btn btn-primary">
                </div>
        </div>

    </body>
</html>
