<%@include file="../../top.jsp" %>
<h3 class="text-center">Administracion de datos</h3>
<br/>
<ul class="list-group list-group-flush">
    <li class="list-group-item d-flex justify-content-between">
        <h5>Instituciones</h5>
        <div>
            <a href="Vista/insertarInstitucion.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/controladorInstitucion?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
    <li class="list-group-item d-flex justify-content-between">
        <h5>Especialidades</h5>
        <div>
            <a href="Vista/insertarEspecialidad.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/controladorEspecialidad?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
    <li class="list-group-item d-flex justify-content-between">
        <h5>Tipo de practicas</h5>
        <div>
            <a href="Vista/insertarTipopractica.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/controladorTipoPracticas?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
    <li class="list-group-item d-flex justify-content-between">
        <h5>Generos</h5>
        <div>
            <a href="Vista/insertarGenero.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/controladorGenero?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
    <li class="list-group-item d-flex justify-content-between">
        <h5>Roles</h5>
        <div>
            <a href="Vista/insertarRol.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/ControladorRol?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
    <li class="list-group-item d-flex justify-content-between">
        <h5>Estados</h5>
        <div>
            <a href="Vista/insertarEstado.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/ControladorEstado?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
    <li class="list-group-item d-flex justify-content-between">
        <h5>Carreras</h5>
        <div>
            <a href="Vista/insertarCarrera.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/controladorCarrera?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
    <li class="list-group-item d-flex justify-content-between">
        <h5>Ciclos</h5>
        <div>
            <a href="Vista/insertarCiclos.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/controladorCiclos?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
    <li class="list-group-item d-flex justify-content-between">
        <h5>Valoraciones</h5>
        <div>
            <a href="Vista/insertarValoracion.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/controladorValoraciones?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
    <li class="list-group-item d-flex justify-content-between">
        <h5>Contenidos</h5>
        <div>
            <a href="Vista/insertarContenido.jsp" class="btn btn-primary">Registrar</a>
            <a href="${pageContext.request.contextPath}/controladorCont?accion=read" class="btn btn-primary">Mostrar</a>
        </div>
    </li>
</ul>
<%@include file="../../bottom.jsp" %>