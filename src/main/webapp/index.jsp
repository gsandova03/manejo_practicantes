<%@page import="com.gbm.controladores.BcsLoginControlador" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true"%>
<!DOCTYPE html>
<html>
    <head>
        <title>GBM Practicantes</title>  

        <!--JQUERY-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

        <!-- Los iconos tipo Solid de Fontawesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
        <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <!-- Nuestro css-->
        <link href="vistas/css/Logincss.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="caja-logo" >
            <img src="vistas/img/gbm2.png" width="300px" height="95px"/>
        </div>
        <div class="modal-dialog text-center">
            <div class="col-sm-8 main-section">
                <div class="modal-content">
                    <div class="col-12 usuario-imagenes">
                        <img src="vistas/img/usuario.jpg"/>
                    </div>
                    <form id="login-form" class="col-12" action="${pageContext.request.contextPath}/BcsLoginControlador" method="POST">
                        <div class="form-group" id="user-group">
                            <input type="email" class="form-control" id="usuario" placeholder="Correo coorporativo" name="usuario"/>
                        </div>
                        <div class="form-group" id="contrasena-group">
                            <input type="password" id="password" class="form-control" placeholder="Contrasena" name="password"/>
                            <button type="button" id="ocultar-password" hidden onclick="ocultarPassword()"><i class="bi bi-eye-slash"></i></button>
                        </div>
                        <button type="submit"  value="Iniciar sessi??n" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i> Ingresar </button>
                        <button type="button" class="btn-limpiar-campos btn btn-danger" id="btn-limpiar" class="btn-limpiar-campos" onclick="limpiarCampos()"><i class="fas fa-recycle"></i>Cancelar</button>
                    </form>
                    <div class="Recordarme">
                        <label><input type="checkbox" id="cbox1"> Recordarme</label>
                    </div>
                    <div class="col-12 olvidar">
                        <a href="#">Olvid?? mi contrase??a</a>
                    </div>
                    <div <button type="button" id="ocultar-password" hidden onclick="ocultarPassword()"><i class="bi bi-eye-slash"></i></button>
                    </div>
                </div>
            </div>
        </div>
        <script src="vistas/js/js-login.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    </body>

    <script type="text/javascript">
        <%--
        $(document).ready(function () {
            function disableBack() {
                window.history.forward();
            }
                window.onload = disableBack();

                window.onpageshow = function (e) {
                    if (e.persisted) {
                        disableBack();
                    }
                }

        });
        --%>
            
        <%
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("tipo") != null){
        %>
        
            var tipo = "<%= sesion.getAttribute("tipo") %>";
            var mensaje = "<%= sesion.getAttribute("mensaje") %>";
            
            Swal.fire({
                icon: tipo,
                title: mensaje,
                timer:2000,
                showConfirmButton: false
            });
        
        <%
            }
            sesion.invalidate();
        %>
        <%--
        const loginForm = document.getElementById("login-form");
        loginForm.addEventListener("submit", function(event){
            console.log(event);
            event.preventDefault();
        })
        --%>

    </script>

</html>