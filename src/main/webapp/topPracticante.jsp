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
                        <li><a href="#" class="link_name">Editar Perfil</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/controladorDashboardPracticante?accion=mostrarAsignacion">
                        <i class='bx bx-history'></i>
                        <span class="link_name">Ver Asignaci??n</span>
                    </a>
                    <ul class="sub-menu blank">
                        <li><a href="#" class="link_name">Ver Asignaci??n</a></li>
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