<%@include file="../../top.jsp" %>
<div class="formulario-modal">
    <form action="${pageContext.request.contextPath}/Practicante?accion=verificar" method="post">
        <div class="grupo-input">
            <label>Cedula: </label>
            <input class="form-control" type="text" name="ced_usuario"/>
        </div>
        <button class="btn btn-warning" type="submit"> Verificar cedula</button>
    </form>

    <form action="${pageContext.request.contextPath}/Practicante?accion=crear" method="post">
        <div class="row">
            <div class="grupo-input">
                <label>Nombre: </label>
                <input class="form-control" value="${Usuario.nomUsuario}" type="text" name="nom_usuario" readonly/>
            </div>
            <div class="grupo-input" hidden>
                <label>cod: </label>
                <input class="form-control" value="${Usuario.codUsuario}" type="text" name="cod_usuario"/>
            </div>
            <div class="grupo-input">
                <label>Cedula: </label>
                <input class="form-control" value="${Usuario.cedUsuario}" type="text" name="ced_usuario" readonly/>
            </div>
            <div class="grupo-input">
                <label>Fecha nacimiento: </label>
                <input class="form-control" value="${Usuario.fecNacimiento}" type="date" name="fecha_nacimiento" readonly/>
            </div>
        </div>
        <div class="grupo-input">
            <label>Foto: </label>
            <input class="form-control" value="${Usuario.fotoUsuario}" type="file" name="foto_usuario" readonly/>
        </div>
        <div class="grupo-input">
            <label>Codigo generacion: </label>
            <input class="form-control" type="text" name="cod_generacion" required/>
        </div>
        <div class="grupo-input">
            <label>Fecha ingreso: </label>
            <input class="form-control" type="date" name="fec_ingreso" required/>
        </div>
        <div class="grupo-input">
            <label>Duracion practica: </label>
            <input class="form-control" type="text" name="dur_practica" required/>
        </div>
        <div class="grupo-input">
            <label>Lider administrativo: </label>
            <input class="form-control" type="text" name="ldr_administrativo" required/>
        </div>
        <div class="grupo-input">
            <label>Lider entrenamiento: </label>
            <input class="form-control" type="text" name="ldr_entrenamiento" required/>
        </div>
        <div class="grupo-input">
            <label>Lider funcional: </label>
            <input class="form-control" type="text" name="ldr_funcional" required/>
        </div>
        <div class="grupo-input">
            <label for="textoFlotante1">Cantidad de materias pendientes</label>
            <input class="form-control" type="number" id="textoFlotante1" name="can_materias_pendientes"/>
        </div>
        <div class="grupo-input">
            <label for="textoFlotante2">Descripcion de materias pendientes: </label>
            <input class="form-control" type="text" name="des_materias_pendientes"
                   id="textoFlotante2" style="height: 100px" placeholder="ingrese un comentario"/>
        </div>
        <div class="grupo-input">
            <label for="textoFlotante3">Revision de materias pendientes: </label>
            <input class="form-control" type="text" name="rev_materias_pendientes"
                      id="textoFlotante3" style="height: 100px" placeholder="ingrese un comentario"/>
        </div>
        <div class="grupo-input">
            <label>Fecha actualizacion expediente: </label>
            <input class="form-control" name="fec_actualizacion_expediente" type="date" required/>
        </div>
        <div class="grupo-input">
            <label>Usuario cambio expediente: </label>
            <input class="form-control" name="usuario_cambio_expediente" type="text" required/>
        </div>
        <div class="grupo-input">
            <label>Genero: </label>
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
                <c:forEach var="instituciones" items = "${Instituciones}" varStatus= "status">
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
                    <option value="${practicas.idPractica}">${practicas.desPractica}</option>
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
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/Practicante?accion=listar">Cancelar</a>
    </form>
</div>
<%@include file="../../bottom.jsp" %>