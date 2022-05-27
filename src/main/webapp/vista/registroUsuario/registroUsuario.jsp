<%-- 
    Document   : registroUsuario
    Created on : 26 may 2022, 17:42:48
    Author     : jfilot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <link rel="stylesheet" href="recursos/estilo.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Registrar Usuario</h1>
        <form action="${pageContext.request.contextPath}/BscUsuarioControler" name="form1" method="POST">
            <fieldset>
                <legend>Datos de Registro Usuario</legend>
                    Nombre Usuario:<input type="text" id="nombre_usuario" name="nom_usuario" placeholder="Ingrese el nombre de usuario..."><br>
                    Cedula del Usuario<input type="text" id="cc_usuario" name="ced_usuario" placeholder="Ingrese la cedula del usuario..."><br>
                    <label>Fecha de nacimiento: </label>
                    <input type="date" id="fechNac_usuario" name="fec_nacimiento" placeholder="Ingrese la fecha de nacimiento del usuario..."><br>
                    Direccion Fisica: <input type="text" id="dr_usuario" name="dir_fisica" placeholder="Ingrese la dirección del usuario..."><br/>
                    Correo Coorporativo: <input type="email" id="email" name="emi_corporativo" placeholder="Ingrese su correo coorporativo"><br>
                    Correo Personal: <input type="email" id="email" name="emi_persoanl" placeholder="Ingrese su correo personal"><br/>
                    Foto: <input type="file" name="foto_usuario"><br/>
                    Password Usuario: <input type="password" id="password" name="psw_usuario" placeholder="Igrese su contraseña"><br>
                    <label>Seleccione su rol: </label>
                    
                <select name="id_rol">
                    <option value=" " >rol...</option>
                    <option value="1" >Practicante</option>
                    <option value="2" >Administrador</option>
                    <option value="3" >Lider</option>                
                    <option value="4" >Visualizador</option>                
                </select><br/>
            </fieldset><br/>

            <input type="submit" name="guardar" value="Guardar">
        </form>
            <div>
                <p>${UsuarioExistente}</p>
                <p>${UsuarioNuevo}</p>
            </div>
    </body>
</html>


