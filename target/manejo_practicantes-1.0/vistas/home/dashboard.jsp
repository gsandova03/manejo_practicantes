<%-- 
    Document   : dashboard
    Created on : 27 may 2022, 11:27:48
    Author     : jfilot
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <script src="../js/js-login.js"></script>
    </head>
    <body>         
        <h1>Inicio de Session</h1>
        <button id="TbnPrueba">Presiona Aqui!</button>
    </body>
</html>

<script src="js/js-login.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="../js/js-login.js"></script>       

<script type="text/javascript">
    
        $(document).ready(function() {
           
            document.getElementById("TbnPrueba").addEventListener('click', function() {

                alert("Esto funciona invesil");

              });
        });
        
    </script>
