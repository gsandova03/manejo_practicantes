<%@include file="../../top.jsp" %>
<table class="table table-hover table-bordered" style="width: 80% !important;">
    <thead style="background-color: #0a58ca; color: #fff" >
        <tr>
            <th>Comentario</th>
            <th>Fecha</th>
            <th>Accion</th>
        </tr>
    </thead>
    <c:forEach var="comentario" items="${comentarios}" varStatus = "status">                
        <tbody>
            <tr style="font">
            <tr>
                <td class="text-start">
                    ${comentario.getDesComentario()} <br/> <br/>
                    <b>Comentario dado por:</b> ${comentario.getIdUsuarioCreaComentario().getCodUsuario()}<br/>
                    <b>Practicante: </b>${comentario.getCodUsuarioComentario().getBcsUsuario().getNomUsuario()}<br/>
                </td>
                <td>${comentario.getFecComentario()}</td>
                <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/controladorComentarios?accion=delete&id=${comentario.getIdComentarios()}">Borrar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../../bottom.jsp" %>
