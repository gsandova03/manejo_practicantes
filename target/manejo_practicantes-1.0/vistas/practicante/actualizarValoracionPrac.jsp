<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Valoracion practicantes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container d-flex justify-content-center align-items-center">
            <form action="${pageContext.request.contextPath}/controladorValoracionPracticante?accion=update" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Id del practicante</label>
                    <input type="text" name="idPracticante" class="form-control" id="exampleInputEmail1" value="${Practicante.getBcsUsuario().getCodUsuario()}" readonly>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Nombre del practicante</label>
                    <input type="text" name="nombrePracticante" class="form-control" id="exampleInputEmail1" value="${Practicante.getBcsUsuario().getNomUsuario()}" readonly>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Id del Ciclo</label>
                    <input type="text" name="idCiclo" class="form-control" id="exampleInputEmail1" value="${Ciclo.idCiclo}" readonly>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Nombre del Ciclo</label>
                    <input type="text" name="nombreCiclo" class="form-control" id="exampleInputEmail1" value="${Ciclo.getDesCiclo()}" readonly>
                </div>
                <div class="mb-3">
                    <div class="mb-3">
                        <label for="disabledSelect" class="form-label">Valoracion</label>
                        <select id="disabledSelect" class="form-select" name="idValoracion" required>
                            <c:forEach var="ListaValoracion" items="${listaValoracion}">
                                <option value="${ListaValoracion.getIdValoracion()}">${ListaValoracion.getDesDescripcion()}</option>                            
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </div>
            </form>
        </div>
    </body>
</html>