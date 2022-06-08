<%@include file="../../top.jsp" %>
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
            <option selected>Selecionar un rol</option>
            <option value="">Rol..</option>
            <option value="1">Practicante</option>
            <option value="2">Administrador</option>
            <option value="3">Lider</option>
            <option value="4">Visualizador</option>
        </select><br>

        <div class="form-group">
            <div class="col-md-12 text-center">
                <button type="submit" name="guardar" value="Guardar" class="btn btn-primary btn-lg" onclick="usuarioE()">Guardar</button>
            </div>
        </div>
    </fieldset>
</form>
<%@include file="../../bottom.jsp" %>


