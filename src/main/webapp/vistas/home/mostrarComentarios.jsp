<%@include file="../../topPracticante.jsp" %>
<div class="container text-center">
    <table class="table table-hover table-bordered" style="width: 80% !important;">
        <thead style="background-color: #0a58ca; color: #fff" >
            <tr>
                <th>Comentario</th>
                <th>Fecha</th>
            </tr>
        </thead>
        <c:forEach var="comentarioPract" items="${comentariosPracticante}" varStatus = "status">                
            <tbody>
                <tr style="font">
                <tr>
                    <td class="text-start">
                        ${comentarioPract.getDesComentario()} <br/> <br/>
                        <b>Comentario dado por:</b> ${comentarioPract.getIdUsuarioCreaComentario().getNomUsuario()}<br/>
                        <b>Practicante: </b>${comentarioPract.getCodUsuarioComentario().getBcsUsuario().getNomUsuario()}<br/>
                    </td>
                    <td>${comentarioPract.getFecComentario()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../../bottom.jsp" %>
