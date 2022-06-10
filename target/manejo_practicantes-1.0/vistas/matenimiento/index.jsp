<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Administracion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    </head>
    <body>

        <h1 style="text-align: center">Administracion de datos</h1>
        <br/>
        <div class="container d-flex flex-row justify-content-around flex-wrap gy-5 text-center">
            <div class="card col-4 border-primary p-2" style="width: 15rem;">
                <img src="Imagen/oficina.png" class="card-img-top" alt="No encontrado">
                <div class="card-body">
                    <h5 class="card-title">Instituciones</h5>
                    <p class="card-text">Registrar, Eliminar, Actualizar y Mostrar de Instituciones</p>
                    <a href="Vista/insertarInstitucion.jsp" class="btn btn-primary">Registrar</a>
                    <a href="${pageContext.request.contextPath}/controladorInstitucion?accion=read" class="btn btn-primary">Mostrar</a>
                </div>
            </div>
            <div class="card col-4 border-primary p-2" style="width: 15rem;">
                <img src="Imagen/especialista.png" class="card-img-top" alt="No encontrado">
                <div class="card-body">
                    <h5 class="card-title">Especialidades</h5>
                    <p class="card-text">Registrar, Eliminar, Actualizar y Mostrar de Especialidades</p>
                    <a href="Vista/insertarEspecialidad.jsp" class="btn btn-primary">Registrar</a>
                    <a href="${pageContext.request.contextPath}/controladorEspecialidad?accion=read" class="btn btn-primary">Mostrar</a>
                </div>
            </div>
            <div class="card col-4 border-primary p-2" style="width: 15rem;">
                <img src="Imagen/practica.png" class="card-img-top" alt="No encontrado">
                <div class="card-body">
                    <h5 class="card-title">Tipo Practicas</h5>
                    <p class="card-text">Registrar, Eliminar, Actualizar y Mostrar de Tipo Practicas</p>
                    <a href="Vista/insertarTipopractica.jsp" class="btn btn-primary">Registrar</a>
                    <a href="${pageContext.request.contextPath}/controladorTipoPracticas?accion=read" class="btn btn-primary">Mostrar</a>
                </div>
            </div>
            <div class="card col-4 border-primary p-2" style="width: 15rem;">
                <img src="Imagen/igualdad-de-genero.png" class="card-img-top" alt="No encontrado">
                <div class="card-body">
                    <h5 class="card-title">Generos</h5>
                    <p class="card-text">Registrar, Eliminar, Actualizar y Mostrar de Generos</p>
                    <a href="Vista/insertarGenero.jsp" class="btn btn-primary">Registrar</a>
                    <a href="${pageContext.request.contextPath}/controladorGenero?accion=read" class="btn btn-primary">Mostrar</a>
                </div>
            </div>
            <div class="card col-4 border-primary p-2" style="width: 15rem;">
                <img src="Imagen/roles.png" class="card-img-top" alt="No encontrado">
                <div class="card-body">
                    <h5 class="card-title">Roles</h5>
                    <p class="card-text">Registrar, Eliminar, Actualizar y Mostrar de Roles</p>
                    <a href="Vista/insertarRol.jsp" class="btn btn-primary">Registrar</a>
                    <a href="${pageContext.request.contextPath}/ControladorRol?accion=read" class="btn btn-primary">Mostrar</a>
                </div>
            </div>
            <div class="card col-4 border-primary p-2" style="width: 15rem;">
                <img src="Imagen/cheque.png" class="card-img-top" alt="No encontrado">
                <div class="card-body">
                    <h5 class="card-title">Estados</h5>
                    <p class="card-text">Registrar, Eliminar, Actualizar y Mostrar de Estados</p>
                    <a href="Vista/insertarEstado.jsp" class="btn btn-primary">Registrar</a>
                    <a href="${pageContext.request.contextPath}/ControladorEstado?accion=read" class="btn btn-primary">Mostrar</a>
                </div>
            </div>
            <div class="card col-4 border-primary p-2" style="width: 15rem;">
                <img src="Imagen/gorra.png" class="card-img-top" alt="No encontrado">
                <div class="card-body">
                    <h5 class="card-title">Carreras</h5>
                    <p class="card-text">Registrar, Eliminar, Actualizar y Mostrar de Carreras</p>
                    <a href="Vista/insertarCarrera.jsp" class="btn btn-primary">Registrar</a>
                    <a href="${pageContext.request.contextPath}/controladorCarrera?accion=read" class="btn btn-primary">Mostrar</a>
                </div>
            </div>
            <div class="card col-4 border-primary p-2" style="width: 15rem;">
                <img src="Imagen/ciclo-vital.png" class="card-img-top" alt="No encontrado">
                <div class="card-body">
                    <h5 class="card-title">Ciclos</h5>
                    <p class="card-text">Registrar, Eliminar, Actualizar y Mostrar de Ciclos</p>
                    <a href="Vista/insertarCiclos.jsp" class="btn btn-primary">Registrar</a>
                    <a href="${pageContext.request.contextPath}/controladorCiclos?accion=read" class="btn btn-primary">Mostrar</a>
                </div>
            </div>
            <div class="card col-4 border-primary p-2" style="width: 15rem;">
                <img src="Imagen/clasificacion.png" class="card-img-top" alt="No encontrado">
                <div class="card-body">
                    <h5 class="card-title">Valoraciones</h5>
                    <p class="card-text">Registrar, Eliminar, Actualizar y Mostrar de Valoraciones</p>
                    <a href="Vista/insertarValoracion.jsp" class="btn btn-primary">Registrar</a>
                    <a href="${pageContext.request.contextPath}/controladorValoraciones?accion=read" class="btn btn-primary">Mostrar</a>
                </div>
            </div>

        </div>
    </body>
    <script>
        /*$(document).ready(function() {
         function disableBack() {
         window.history.forward()
         }
         window.onload = disableBack();
         window.onpageshow = function(e) {
         if (e.persisted)
         disableBack();
         }
         }); */
    </script>
</html>
