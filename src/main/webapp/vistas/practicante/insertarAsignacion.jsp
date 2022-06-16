<%@include file="../../top.jsp" %>

<div class="container">
    <form action="${pageContext.request.contextPath}/controladorHistPracticante?accion=insert" method="POST">

        <div class="row">

            <div class="col">
                <select class="form-select" aria-label="Default select example" name="contenido">
                    <option selected>Seleccione un contenido</option>
                    <c:forEach var="Contenidos" items="${contenidos}">
                        <option value="${Contenidos.getIdContenido()}">${Contenidos.getDesContenido()}</option>
                    </c:forEach>
                </select>

            </div>

            <div class="col">
                <select class="form-select" aria-label="Default select example" name="ciclo">
                    <option selected>Seleccione un ciclo</option>
                    <c:forEach var="Ciclos" items="${ciclos}">
                        <option value="${Ciclos.getIdCiclo()}">${Ciclos.getDesCiclo()}</option>
                    </c:forEach>
                </select>

            </div>

        </div>    

        <div style="margin-bottom: 100px"></div>

        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">Nombre</span>
            <input type="text" name="nombrePracticante" class="form-control" placeholder="Nombre de usuario" aria-label="Username" aria-describedby="basic-addon1" value="${practicante.getBcsUsuario().getNomUsuario()}" readonly>
        </div>

        <div class="input-group mb-3">
            <input type="text" name="idPracticante" class="form-control" placeholder="Id del usuario" aria-label="Recipient's username" aria-describedby="basic-addon2" value="${practicante.getCodUsuarioPract()}" readonly>
            <span class="input-group-text" id="basic-addon2">ID</span>
        </div>

        <input type="submit" class="btn btn-primary" value="Enviar">
    </form>
</div>


<%@include file="../../bottom.jsp" %>
