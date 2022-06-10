<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="recursos/estilo.css"/>
        <link rel="stylesheet" href="../css/estilosAlertas.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div >
            <p id="usuarioE">${UsuarioExistente}</p>
            <p id="UsuarioN">${UsuarioNuevo}</p>
        </div>
        <div class="d-flex justify-content-center alling-items-center w-100">
            <div class="">
                <div class="">
                    <div class="well well-sm">
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/BscUsuarioControlador?accion=insert" name="form1" method="POST">
                            <fieldset>
                                <legend class="text-center header">Registro de Usuario</legend>
                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col">
                                        <input type="text" id="nombre_usuario" name="nom_usuario" placeholder="Nombre Usuario" class="form-control">
                                    </div>
                                </div><br>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col">
                                        <input type="text" id="cc_usuario" name="ced_usuario" placeholder="Cedula Usuario" class="form-control">
                                    </div>
                                </div><br>

                                <section class="col-sm-6">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="date" name="fec_nacimiento" class="form-control" id="datetimepicker">
                                            <span class="input-group-aadon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </section><br>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                                    <div class="col">
                                        <input type="text" id="dr_usuario" name="dir_fisica" placeholder="Direccion fisica" class="form-control">
                                    </div>
                                </div><br>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                                    <div class="col">
                                        <input type="email" id="email" name="emi_corporativo"  placeholder="Email Cororporativo" class="form-control">
                                    </div>
                                </div><br>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                                    <div class="col">
                                        <input ype="email" id="email" name="emi_persoanl" placeholder="Email Personal" class="form-control">
                                    </div>
                                </div><br>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-phone-square bigicon"></i></span>
                                    <div class="col">
                                        <input type="file" name="foto_usuario" class="form-control">
                                    </div>
                                </div><br>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-pencil-square-o bigicon"></i></span>
                                    <div class="col">
                                        <input type="password" id="password" name="psw_usuario" placeholder="Ingresa tu contraseña" class="form-control">
                                    </div>
                                </div><br>


                                <select class="form-select" aria-label="Default select example" name="id_rol">
                                    <c:forEach var="Roles" items="${roles}">
                                        <option value="${Roles.idRol}">${Roles.nomRol}</option>
                                    </c:forEach>
                                </select><br>

                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <button type="submit" name="guardar" value="Guardar" class="btn btn-primary btn-lg" onclick="usuarioE()">Guardar</button>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                        <a href="${pageContext.request.contextPath}/vistas/login/log2.jsp">Login</a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>


