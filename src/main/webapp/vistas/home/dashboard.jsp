


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/vistas/css/estilos-globales.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../css/estilosAlertas.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <title>Manejo Practicantes</title>
    </head>

    <body>
        <div class="sidebar">
            <a class="logo-details" href="${pageContext.request.contextPath}/index.jsp">
                <img src="${pageContext.request.contextPath}/vistas/img/GBM7.png" alt="LOGOgbm">
                <span class="logo_name"></span>
            </a>
            <ul class="nav-links">
                <li>
                    <a href="${pageContext.request.contextPath}/Valoraciones?accion=listar">
                        <i class='bx bx-grid-alt'></i>
                        <span class="link_name">Dashboard</span>
                    </a>
                    <ul class="sub-menu blank">
                        <li><a href="#" class="link_name">Dashboard</a></li>
                    </ul>
                </li>
                <li>
                    <div class="iocn-links">
                        <a href="#">
                            <i class='bx bx-user'></i>
                            <span class="link_name">Usuario</span>
                        </a>
                        <i class='bx bxs-chevron-down arrow'></i>
                    </div>
                    <ul class="sub-menu">
                        <li><a href="#" class="link_name">Usuario</a></li>
                        <li><a href="${pageContext.request.contextPath}/BscUsuarioControlador?accion=read">Listar Usuarios</a></li>
                        <li><a href="${pageContext.request.contextPath}/vistas/login/registro_usuario.jsp">Agregar Usuario</a></li>
                    </ul>
                </li>
                <li>
                    <div class="iocn-links">
                        <a href="#">
                            <i class='bx bx-group'></i>
                            <span class="link_name">Practicantes</span>
                        </a>
                        <i class='bx bxs-chevron-down arrow'></i>
                    </div>
                    <ul class="sub-menu">
                        <li><a href="#" class="link_name">Practicantes</a></li>
                        <li><a href="${pageContext.request.contextPath}/Practicante?accion=listar">Listar practicante</a></li>
                        <li><a href="${pageContext.request.contextPath}/Practicante?accion=leer">Agregar practicante</a></li>
                        <li><a href="${pageContext.request.contextPath}/Valoraciones?accion=read">Mostrar valoraciones</a></li>
                    </ul>
                </li>
                <li>
                    <div class="iocn-links">
                        <a href="${pageContext.request.contextPath}/vistas/matenimiento/index.jsp">
                            <i class='bx bx-wrench'></i>
                            <span class="link_name">Mantenimiento</span>
                        </a>
                        <i class='bx bxs-chevron-down arrow'></i>
                    </div>
                    <ul class="sub-menu">
                        <li><a href="#" class="link_name">Mantenimiento</a></li>
                        <li><a href="${pageContext.request.contextPath}/controladorCarrera?accion=read">Carreras</a></li>
                        <li><a href="${pageContext.request.contextPath}/controladorCiclos?accion=read">Ciclos</a></li>
                        <li><a href="${pageContext.request.contextPath}/controladorEspecialidad?accion=read">Especialidades</a></li>
                        <li><a href="${pageContext.request.contextPath}/ControladorEstado?accion=read">Estados</a></li>
                        <li><a href="${pageContext.request.contextPath}/controladorGenero?accion=read">Generos</a></li>
                        <li><a href="${pageContext.request.contextPath}/controladorInstitucion?accion=read">Instituciones</a></li>
                        <li><a href="${pageContext.request.contextPath}/ControladorRol?accion=read">Roles</a></li>
                        <li><a href="${pageContext.request.contextPath}/controladorTipoPracticas?accion=read">Tipo de practicas</a></li>
                        <li><a href="${pageContext.request.contextPath}/controladorValoraciones?accion=read">Valoraciones</a></li>
                        <li><a href="${pageContext.request.contextPath}/controladorCont?accion=read">Contenido</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-comment'></i>
                        <span class="link_name">Comentarios</span>
                    </a>
                    <ul class="sub-menu blank">
                        <li><a href="#" class="link_name">Comentarios</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/vistas/usuario/bitacoraUsuario.jsp">
                        <i class='bx bx-history'></i>
                        <span class="link_name">Bitacora</span>
                    </a>
                    <ul class="sub-menu blank">
                        <li><a href="#" class="link_name">Bitacora</a></li>
                    </ul>
                </li>
                <div class="profile-details">
                    <div class="profile-content">
                        <img src="${pageContext.request.contextPath}/vistas/img/usuario.jpg" alt="usuario">
                    </div>
                    <div class="name-job">
                        <div class="profile_name personal-info">${Usuario}</div>
                        <div class="job personal-info">${Rol}</div>
                    </div>
                    <a href="${pageContext.request.contextPath}/BcsLoginControlador">
                        <i class='bx bx-log-out personal-info'></i>
                    </a>
                </div>
            </ul>
        </div>
        <section class="home-section">
            <div class="home-content">
                <i class='bx bx-menu'></i>
                <span class="text">Control de practicantes</span>
            </div>
            <div class="container-content">
                <div class="contenedor-graficas">
                    <div class="row">
                        <div class="grafica col-md-12">
                            <h3 class="text-center" style="color: #11101d">Valoraciones ciclo 1</h3>
                            <canvas id="pastel1" style="max-width: 700px"></canvas>
                        </div>
                        <div class="grafica col-md-12">
                            <h3 class="text-center" style="color: #11101d">Valoraciones ciclo 2</h3>
                            <canvas id="pastel2" style="max-width: 700px"></canvas>
                        </div>
                        <div class="row">
                            <h3 class="text-center" style="color: #11101d">Valoraciones ciclo 3</h3>
                            <div class="grafica col-md-12">
                                <canvas id="pastel3" style="max-width: 700px"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script>
            let arrow = document.querySelectorAll(".arrow");
            for (var i = 0; i < arrow.length; i++) {
                arrow[i].addEventListener("click", (e) => {
                    let arrowParent = e.target.parentElement.parentElement;
                    arrowParent.classList.toggle("showMenu");
                });
            }

            let sidebar = document.querySelector(".sidebar");
            let sidebarBtn = document.querySelector(".bx-menu");


            sidebarBtn.addEventListener("click", () => {
                sidebar.classList.toggle("close");
            });

        </script>
        <script>
            var ctx = document.getElementById("pastel1").getContext("2d");
            
            var myChart = new Chart(ctx, {
            
                type: "pie",
                data: {
                    labels: ['alto', 'medio', 'bajo'],
                    datasets: [{

                            label: 'Grafica De Barras',
                            
                    data: [${Ciclo1_alto}, ${Ciclo1_medio}, ${Ciclo1_bajo}],

                            backgroundColor: [
                                'rgb(217, 136, 128)',
                                'rgb(241, 148, 138)',
                                'rgb( 195, 155, 211 )'
                            ]
                        }]
                },
                options: {
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZaero: true
                                }
                            }]
                    }
                }
            });
        </script>

        <!-- Grafica Redonda -->
        <script class="clasepie">
            var ctx = document.getElementById("pastel2").getContext("2d");
            var myChart = new Chart(ctx, {

                type: "pie",
                data: {
                    labels: ['alto', 'medio', 'bajo'],
                    datasets: [{

                            data: [${Ciclo2_alto}, ${Ciclo2_medio}, ${Ciclo2_bajo}],
                            backgroundColor: [
                                'rgb(217, 136, 128)',
                                'rgb(241, 148, 138)',
                                'rgb( 195, 155, 211 )',
                                'rgb( 133, 193, 233 )',
                                'rgb( 118, 215, 196 )',
                                'rgb(125, 206, 160)',
                                'rgb(247, 220, 111)',
                                'rgb( 240, 178, 122 )',
                                'rgb( 215, 219, 221 )',
                                'rgb( 133, 146, 158 )',
                            ]
                        }]
                },
                options: {
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZaero: true
                                }
                            }]
                    }
                }
            });
        </script>
        <script>

            var ctx = document.getElementById("pastel3").getContext("2d");
            var myChart = new Chart(ctx, {

                type: "pie",
                data: {
                    labels: ['alto', 'medio', 'bajo'],
                    datasets: [{
                            label: 'Grafica En linea',
                            data: [${Ciclo3_alto}, ${Ciclo3_medio}, ${Ciclo3_bajo}],
                            backgroundColor: [

                                'rgb(217, 136, 128)',
                                'rgb(241, 148, 138)',
                                'rgb( 195, 155, 211 )',
                                'rgb( 133, 193, 233 )',
                                'rgb( 118, 215, 196 )',
                                'rgb(125, 206, 160)',
                                'rgb(247, 220, 111)',
                                'rgb( 240, 178, 122 )',
                                'rgb( 215, 219, 221 )',
                                'rgb( 133, 146, 158 )',
                            ]
                        }]
                },
                options: {
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZaero: true
                                }
                            }]
                    }
                }
            });
        </script>
    </body>

</html>        