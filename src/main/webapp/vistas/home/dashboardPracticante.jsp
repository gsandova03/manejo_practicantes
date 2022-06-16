<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <title>Manejo Practicantes</title>
    </head>

    <body>
        <div class="sidebar">
            <a class="logo-details" href="${pageContext.request.contextPath}/vistas/home/dashboardPracticante.jsp">
                <img src="${pageContext.request.contextPath}/vistas/img/GBM7.png" alt="LOGOgbm">
                <span class="logo_name"></span>
            </a>
            <ul class="nav-links">
                <li>
                    <a href="${pageContext.request.contextPath}/controladorDashboardPracticante?accion=mostarResumenGeneral">
                        <i class='bx bx-grid-alt'></i>
                        <span class="link_name">Dashboard</span>
                    </a>
                    <ul class="sub-menu blank">
                        <li><a href="#" class="link_name">Dashboard</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/controladorDashboardPracticante?accion=verComentarios">
                        <i class='bx bx-comment'></i>
                        <span class="link_name">Comentarios</span>
                    </a>
                    <ul class="sub-menu blank">
                        <li><a href="#" class="link_name">Comentarios</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/controladorDashboardPracticante?accion=editar">
                        <i class='bx bx-cog'></i>
                        <span class="link_name">Editar Perfil</span>
                    </a>
                    <ul class="sub-menu blank">
                        <li><a href="" class="link_name">Editar Perfil</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/controladorDashboardPracticante?accion=mostrarAsignacion">
                        <i class='bx bx-history'></i>
                        <span class="link_name">Ver Asignación</span>
                    </a>
                    <ul class="sub-menu blank">
                        <li><a href="#" class="link_name">Ver Asignación</a></li>
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
                <section class="container  zona1 mb-5">
                    <h3 style="color: #296dc0;" class="mb-3 text-center"> Resumen de asignaciones</h3>

                    <div class="list-group">
                        <div id="scroll">
                            <c:forEach var="contenido" items="${listaHistorialContenido}">
                                <div class="list-group-item p-3" aria-current="true">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1">${contenido.getCprCiclos().getDesCiclo()}</h5>
                                        <small class="text-muted">Hace # días</small>
                                    </div>
                                    <p class="mb-1">${contenido.getIdContenido().getDesContenido()}</p>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                </section>


                <section class="container zona2" , style="text-align: center ;">
                    <h1 style="text-align:left; color: #296dc0;">Evolución por ciclo</h1>

                    <div class="ct-chart ct-perfect-fourth" style="height: 500px;"></div>

                </section>



                <section class="container  zona1 mb-5">

                    <h3 style="color: #296dc0;" class="mb-3 text-center"> Ultimos comentarios </h3>

                    <div class="list-group">
                        <div id="scroll">
                            <c:forEach var="comentario" items="${listaComentarios}" varStatus="status">
                                <div class="list-group-item p-3" aria-current="true">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1">Comentario ${status.count}</h5>
                                        <small>${comentario.getFecComentario()}</small>
                                    </div>
                                    <p class="mb-1">${comentario.getDesComentario()}</p>
                                    <small>${comentario.getIdUsuarioCreaComentario().getNomUsuario()}</small>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </section>
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



            var data = {
                labels: ['Week1', 'Week2', 'Week3', 'Week4', 'Week5', 'Week6'],
                series: [
                    [5, 4, 3, 7, 5, 10],
                    [3, 2, 9, 5, 4, 6],
                    [2, 1, -3, -4, -2, 0]
                ]
            };

            // We are setting a few options for our chart and override the defaults
            var options = {
                // Don't draw the line chart points
                showPoint: false,
                // Disable line smoothing
                lineSmooth: false,
                // X-Axis specific configuration
                axisX: {
                    // We can disable the grid for this axis
                    showGrid: false,
                    // and also don't show the label
                    showLabel: false
                },
                // Y-Axis specific configuration
                axisY: {
                    // Lets offset the chart a bit from the labels
                    offset: 60,
                    // The label interpolation function enables you to modify the values
                    // used for the labels on each axis. Here we are converting the
                    // values into million pound.
                    labelInterpolationFnc: function (value) {
                        return '$' + value + 'm';
                    }
                }
            };

            // All you need to do is pass your configuration as third parameter to the chart function
            new Chartist.Line('.ct-chart', data, options);

        </script>
    </body>

</html>