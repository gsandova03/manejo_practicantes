<%-- 
    Document   : login
    Created on : 27 may 2022, 11:18:14
    Author     : jfilot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login manejo de practicantes</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
        <script src="../js/js-login.js"></script>
        <link rel="stylesheet" href="../css/index-login.css">
    </head>
    <body>
        
        <div class="container-login">
            <div class="box-login">
                <div class="box-logo">
                    <img src="../img/gbm.png" alt="Logo de GBM">
                </div>

                <div>${ocultar}</div>
                <form action="${pageContext.request.contextPath}/BcsLoginControlador" method="POST">
                    <div class="box-user">
                        <i class="bi bi-person"></i>
                        <input id="usuario" class="inputs" name="usuario" type="text" placeholder="Ej: Example@gbm.net">
                    </div>
                    <div class="box-user">
                        <i class="bi bi-lock"></i>
                        <input class="inputs" id="password" name="password"  type="password" placeholder="Ingrese su contraseña">
                        <button type="button" id="mostrar-password" onclick="mostrarPassword()"><i class="bi bi-eye"></i></button>
                        <button type="button" id="ocultar-password" hidden onclick="ocultarPassword()"><i class="bi bi-eye-slash"></i></button>
                    </div>
                    <input type="checkbox" id="recordar-datos"> Recordar datos
                    <input class="btn-iniciar-session" type="submit" value="Iniciar sessión"> <br>
                    <button id="btn-limpiar" class="btn-limpiar-campos" type="button" onclick="limpiarCampos()">Limpiar campos</button> <br>
                    <a href="#">Recordar contraseña</a><br>
                </form>
            </div>
        </div>
        <script src="js/js-login.js"></script>
    </body>
</html>