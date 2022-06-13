<%@include file="../../top.jsp" %>
<div class="container text-center">
    <table class="table table-hover table-bordered" style="width: 80% !important;">
        <thead style="background-color: #0a58ca; color: #fff" >
            <tr>
                <th>Comentario</th>
                <th>Fecha</th>
                <th>Accion</th>
            </tr>
        </thead>
        <c:forEach var="comentarioPract" items="${comentariosPracticante}" varStatus = "status">                
            <tbody>
                <tr style="font">
                <tr>
                    <td class="text-start">
                        ${comentarioPract.getDesComentario()} <br/> <br/>
                        <b>Comentario dado por:</b> ${comentarioPract.getIdUsuarioCreaComentario().getCodUsuario()}<br/>
                        <b>Practicante: </b>${comentarioPract.getCodUsuarioComentario().getBcsUsuario().getNomUsuario()}<br/>
                    </td>
                    <td>${comentarioPract.getFecComentario()}</td>
                    <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/controladorComentarios?accion=delete&id=${comentarioPract.getIdComentarios()}">Borrar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../../bottom.jsp" %>
