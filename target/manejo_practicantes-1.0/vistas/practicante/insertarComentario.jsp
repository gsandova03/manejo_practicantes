<%@include file="../../top.jsp" %>
<div class="container d-flex justify-content-center">
    <% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");%>
    <form action="${pageContext.request.contextPath}/controladorComentarios?accion=insert" method="POST" name="formComentario">
        <h1>Crear comentario</h1>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">ID Usuario</span>
            <input type="text" name="idPracticante" value="${comentarioPracticante.getBcsUsuario().getCodUsuario()}" class="form-control" placeholder="Id del practicante" aria-label="Id del practicante" aria-describedby="basic-addon1" readonly>
        </div>

        <div class="input-group mb-3">
            <input type="text" name="nomPracticante" value="${comentarioPracticante.getBcsUsuario().getNomUsuario()}" class="form-control" placeholder="Nombre del practicante" aria-label="Nombre del practicante" aria-describedby="basic-addon2" readonly>
            <span class="input-group-text" id="basic-addon2">Nombre Practicante</span>
        </div>

        <div class="input-group mb-3">
            <input type="text" name="fechaComentario" value="<%= dtf.format(LocalDateTime.now())%>" class="form-control" placeholder="Nombre del practicante" aria-label="Nombre del practicante" aria-describedby="basic-addon2" readonly>
            <span class="input-group-text" id="basic-addon2">Fecha</span>
        </div>    

        <div class="input-group p-3">
            <span class="input-group-text">Comentario</span>
            <textarea class="form-control" name="comentarioPracticante" aria-label="Comentario" style="height: 100px !important"></textarea>
        </div>

        <div class="d-grid gap-2 col-6 mx-auto">
            <input type="submit" name="enviarDatos" class="btn btn-primary">
        </div>
</div>
<%@include file="../../bottom.jsp" %>
