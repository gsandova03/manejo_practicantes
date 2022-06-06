<%-- 
    Document   : formulario_usuario
    Created on : 26/05/2022, 3:22:36 p. m.
    Author     : gsandoval
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/vistas/css/estilosPracticante.css" type="text/css" rel="stylesheet">
        <title>Crear practicante</title>
    </head>
    <body>
        <div class="formulario-modal">
            <form action="${pageContext.request.contextPath}/Practicante?accion=verificar" method="post">
                <div class="grupo-input">
                    <label>Cedula: </label>
                    <input class="form-control" type="text" name="ced_usuario"/>
                </div>
                <a class="btn btn-warning"> Verificar cedula</a>
                <div class="grupo-input">
                    <label>Nombre: </label>
                    <input class="form-control" value="" type="text" name="nom_usuario" readonly/>
                </div>
                <div class="grupo-input">
                    <label>Fecha nacimiento: </label>
                    <input class="form-control" type="date" name="fecha_nacimiento" readonly/>
                </div>
                <div class="grupo-input">
                    <label>Foto: </label>
                    <input class="form-control" type="file" name="foto_usuario" readonly/>
                </div>
                <div class="grupo-input">
                    <label>Codigo generacion: </label>
                    <input class="form-control" type="text" name="cod_generacion"/>
                </div>
                <div class="grupo-input">
                    <label>Fecha ingreso: </label>
                    <input class="form-control" type="date" name="fec_ingreso"/>
                </div>
                <div class="grupo-input">
                    <label>Duracion practica: </label>
                    <input class="form-control" type="text" name="dur_practica"/>
                </div>
                <div class="grupo-input">
                    <label>Lider administrativo: </label>
                    <input class="form-control" type="text" name="ldr_administrativo"/>
                </div>
                <div class="grupo-input">
                    <label>Lider entrenamiento: </label>
                    <input class="form-control" type="text" name="ldr_entrenamiento"/>
                </div>
                <div class="grupo-input">
                    <label>Lider funcional: </label>
                    <input class="form-control" type="text" name="ldr_funcional"/>
                </div>
                <div class="form-floating">
                    <textarea class="form-control" placeholder="ingrese un comentario" 
                              id="textoFlotante1" style="height: 100px" name="can_materias_pendientes">
                    </textarea>
                    <label for="textoFlotante1">Cantidad de materias pendientes</label>
                </div>
                <div class="form-floating">
                    <textarea class="form-control" name="des_materias_pendientes"
                              id="textoFlotante2" style="height: 100px" placeholder="ingrese un comentario">
                    </textarea>
                    <label for="textoFlotante2">Descripcion de materias pendientes: </label>
                </div>
                <div class="form-floating">
                    <textarea class="form-control" name="rev_materias_pendientes"
                              id="textoFlotante3" style="height: 100px" placeholder="ingrese un comentario">
                    </textarea>
                <label for="textoFlotante3">Revision de materias pendientes: </label>
                </div>
                <div class="grupo-input">
                    <label>Fecha actualizacion expediente: </label>
                    <input class="form-control" name="fec_actualizacion_expediente" type="date" />
                </div>
                <div class="grupo-input">
                    <label>Usuario cambio expediente: </label>
                    <input class="form-control" name="usuario_cambio_expediente" type="text" />
                </div>
                <div class="grupo-input">
                    <label>Genero: </label>
                    <input class="form-control" type="text" name="id_genero"/>
                    <select class="form-select" name="id_genero">
                        <option selected>Seleccionar</option>
                        <c:forEach var="generos" items = "${Generos}" varStatus= "status">
                            <option value="${generos.idGenero}">${generos.desGenero}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="grupo-input">
                    <label>Institucion: </label>
                    <select class="form-select" name="id_institucion">
                        <option selected>Seleccionar</option>
                        <c:forEach var="instituciones" items = "${Intituciones}" varStatus= "status">
                            <option value="${instituciones.idInstitucion}">${instituciones.desInstitucion}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="grupo-input">
                    <label>Carrera: </label>
                    <select class="form-select" name="id_carrera">
                        <option selected>Seleccionar</option>
                        <c:forEach var="carreras" items = "${Carreras}" varStatus= "status">
                            <option value="${carreras.idCarrera}">${carreras.desCarrera}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="grupo-input">
                    <label>Especialidad: </label>
                    <select class="form-select" name="id_especialidad">
                        <option selected>Seleccionar</option>
                        <c:forEach var="especialidades" items = "${Especialidades}" varStatus= "status">
                            <option value="${especialidades.idEspecialidad}">${especialidades.desEspecialidad}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="grupo-input">
                    <label>Tipo practica: </label>
                    <select class="form-select" name="id_practica">
                        <option selected>Seleccionar</option>
                        <c:forEach var="practicas" items = "${Tipo_practica}" varStatus= "status">
                            <option value="${practicas.idPractica}">${practicas.idPractica}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="grupo-input">
                    <label>Estado: </label>
                    <select class="form-select" name="id_estado">
                        <option selected>Seleccionar</option>
                        <c:forEach var="estados" items = "${Estados}" varStatus= "status">
                            <option value="${estados.idEstado}">${estados.desEstados}</option>
                        </c:forEach>
                    </select>
                </div>
                <br/>
                <button class="btn btn-primary" type="submit">Crear practicante</button>
            </form>
        </div>
    </body>
</html>
