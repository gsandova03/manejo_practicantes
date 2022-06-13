<%@include file="../../top.jsp" %>


<form action="${pageContext.request.contextPath}/BscUsuarioControlador?accion=update" name="form1" method="POST" class="form-horizontal">
    <fieldset>
        <h3 class="text-center header">Actualizar Usuario</h3>

        <div class="form-group">
            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
            <div class="col">
                <label>Nombre: </label>
                <input type="text" id="nombre_usuario" name="nom_usuario" placeholder="Ingrese el nombre de usuario..." value="${usuarioEncontrado.nomUsuario}" class="form-control">
            </div>
        </div>
        <br/>

        <div class="form-group">
            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
            <div class="col">
                <label>Cedula: </label>
                <input type="text" id="cc_usuario" name="ced_usuario" placeholder="Cedula Usuario" class="form-control"  value="${usuarioEncontrado.cedUsuario}" readonly class="form-control">
            </div>
        </div>
        <br/>

        <div class="form-group">
            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
            <div class="col">
                <label>Direccion: </label>
                <input type="text" id="cc_usuario" name="dir_fisica" placeholder="Direccion fisica" class="form-control"  value="${usuarioEncontrado.dirFisica}" class="form-control">
            </div>
        </div>
        <br/>

        <div class="form-group">
            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
            <div class="col">
                <label>Email coorporativo: </label>
                <input type="email" id="email" name="emi_corporativo" placeholder="Email Coorporativo" class="form-control" value="${usuarioEncontrado.emiCoorporativo}" readonly>
            </div>
        </div>
        <br/>

        <div class="form-group">
            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
            <div class="col">
                <label>Email personal: </label>
                <input ype="email" id="email" name="emi_persoanl" placeholder="Email Personal" class="form-control" value="${usuarioEncontrado.emiPersonal}">
            </div>
        </div>
        <br/>

        <input type="text" name="cod_usuario" value="${usuarioEncontrado.codUsuario}" hidden>
        <input type="text" name="fec_nacimiento" value="${usuarioEncontrado.fecNacimiento}" hidden>
        <input type="text" name="pass_usuario" value="${usuarioEncontrado.pswUsuario}" hidden>
        <input type="text" name="rol_usuario" value="${usuarioEncontrado.idRol.idRol}" hidden >

        <button type="submit" class="btn btn-primary">Actualizar</button>
        
    </fieldset>
</form>
<div>
    <p>${UsuarioExistente}</p>
    <p>${UsuarioNuevo}</p>
</div>
<a href="${pageContext.request.contextPath}/vistas/login/login.jsp">Login</a>


<%@include file="../../bottom.jsp" %>


