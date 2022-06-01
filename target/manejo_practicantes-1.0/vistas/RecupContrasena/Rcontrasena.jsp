|<%-- 
    Document   : Rcontrasena
    Created on : 31 may 2022, 8:17:56
    Author     : jfilot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>   
        <link rel="stylesheet" href="../css/index-login.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/RecordarContrase_a" method="POST">
            <div style="display: grid;width: 100%;justify-content: center;">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Correo Corporativo</label>
                <input name="usuario" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Correo Corporativo" tyle="text-align: center">
                
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña" style="text-align: center">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            </<div>
                <p>${CampoVacio}</p>
        </form>

    </body>
</html>
