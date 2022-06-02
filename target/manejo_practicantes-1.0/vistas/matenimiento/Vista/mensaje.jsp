
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div aria-live="polite" aria-atomic="true" class="d-flex justify-content-center align-items-center w-100">
            
            <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" style="opacity: 1 !important">
                <div class="toast-header">

                    <div class="spinner-border text-primary" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>

                    <strong class="me-auto">&nbsp ${tituloMensaje}</strong>
                    <small>Control Practicantes</small>
             
                </div>
                <div class="toast-body">
                    ${cuerpoMensaje}.
                </div>

                <div class="mt-2 pt-2 border-top">
                    <a href="${pageContext.request.contextPath}${urlMensaje}" class="btn btn-primary btn-sm">Aceptar</a>
                </div>
            </div>
                
        </div>
    </body>
</html>
