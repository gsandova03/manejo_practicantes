
<%@include file="../../topPracticante.jsp" %>
<div class="formulario-modal">
    <form action="${pageContext.request.contextPath}/controladorDashboardPracticante?accion=actualizarDatos" method="post">
        <div class="grupo-input">
            <label>COD Practicante </label>
            <input class="form-control" value="${practicante.getCodUsuarioPract()}" type="text" name="cod_practicante" readonly/>
        </div>
        <div class="grupo-input">
            <label>Nombre </label>
            <input class="form-control" value="${practicante.getBcsUsuario().getNomUsuario()}" type="text" name="nom_practicante"/>
        </div>
        <div class="grupo-input">
            <label>Dirección </label>
            <input class="form-control" value="${practicante.getBcsUsuario().getDirFisica()}" type="text" name="dir_practicante"/>
        </div>
        <div class="grupo-input">
            <label>Correo Personal </label>
            <input class="form-control" value="${practicante.getBcsUsuario().getEmiPersonal()}" type="text" name="email_personal"/>
        </div>
        <br/>
        <button class="btn btn-primary" type="submit">Actualizar informacion</button>
        <a class="btn btn-danger" href="/vistas/home/indexPracticante.jsp">Cancelar</a>
    </form>
<%@include file="../../bottom.jsp" %>