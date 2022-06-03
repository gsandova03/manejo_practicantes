<%-- 
    Document   : index
    Created on : 26/05/2022, 11:14:27 a. m.
    Author     : gsandoval
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo practicantes</title>
    </head>
   
    <body>      
        <h1>Manejo practicantes</h1>
        <br/>
        <a href="${pageContext.request.contextPath}/vistas/login/registro_usuario.jsp">Registrar usuario</a><br/>
        <br/>
        <a href="${pageContext.request.contextPath}/BscUsuarioControlador?accion=read">Lista de usuarios</a>
        <br/>
        <a href="${pageContext.request.contextPath}/vistas/login/log2.jsp">Login</a>
        <br/>
        <a href="${pageContext.request.contextPath}/Practicante?accion=listar">listar practicante</a>
        <br/>
        <form action="${pageContext.request.contextPath}/Practicante?accion=crear" method="post">
            id: <input type="number" name="cod_usuario"/>
            <br/>
            codigo generacion: <input type="text" name="cod_generacion"/>
            <br/>
            fecha ingreso: <input type="text" name="fec_ingreso"/>
            <br/>
            Duracion practica: <input type="text" name="dur_practica"/>
            <br/>
            lider administrativo: <input type="text" name="ldr_administrativo"/>
            <br/>
            lider entrenamiento: <input type="text" name="ldr_entrenamiento"/>
            <br/>
            lider funcional: <input type="text" name="ldr_funcional"/>
            <br/>
            cantidad de materias pendientes: <textarea name="can_materias_pendientes" rows="10" cols="50">
            </textarea>
            <br/>
            descripcion de materias pendientes: <textarea name="des_materias_pendientes" rows="10" cols="50"/>
            </textarea>
            <br/>
            revision de materias pendientes: <textarea name="rev_materias_pendientes" rows="10" cols="50"/>
            </textarea>
            <br/>
            fecha actualizacion expediente: <input name="fec_actualizacion_expediente" type="text" />
            <br/>
            usuario cambio expediente: <input name="usuario_cambio_expediente" type="text" />
            <br/>
            genero: <select name="id_genero">
                <option value=" ">Seleccionar</option>
                <option value="1">masculino</option>
                <option value="2">femenino</option>
                <option value="3">otro</option>
            </select>
            <br/>
            institucion: <select name="id_institucion">
                <option value=" ">Seleccionar</option>
                <option value="1">masculino</option>
                <option value="2">femenino</option>
                <option value="3">otro</option>
            </select>
            <br/>
            carrera: <select name="id_carrera">
                <option value=" ">Seleccionar</option>
                <option value="1">masculino</option>
                <option value="2">femenino</option>
                <option value="3">otro</option>
            </select>
            <br/>
            especialidad: <select name="id_especialidad">
                <option value=" ">Seleccionar</option>
                <option value="1">masculino</option>
                <option value="2">femenino</option>
                <option value="3">otro</option>
            </select>
            <br/>
            tipo practica: <select name="id_practica">
                <option value=" ">Seleccionar</option>
                <option value="1">masculino</option>
                <option value="2">femenino</option>
                <option value="3">otro</option>
            </select>
            estado: <select name="id_estado">
                <option value=" ">Seleccionar</option>
                <option value="1">masculino</option>
                <option value="2">femenino</option>
                <option value="3">otro</option>
            </select>
            <br/>
            <br/>
            <button type="submit">Enviar formulario</button>
        </form>
        <a href="${pageContext.request.contextPath}/vistas/RecupContrasena/Rcontrasena">Recordar Contraseña</a>
    </body>
</html>
