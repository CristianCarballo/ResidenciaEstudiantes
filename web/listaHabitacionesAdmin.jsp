<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    HttpSession sesion = request.getSession();
    Object usuario = sesion.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("/ResidenciaEstudiantes/Login?accion=cerrar");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Apart.</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700,900|Oswald:400,700"> 
        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/mediaelementplayer.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="css/fl-bigmug-line.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/style.css">

    </head>

    <body>

        <jsp:include page="headerAdmin.jsp"></jsp:include>


            <div class="site-blocks-cover overlay" style="background-image: url('images/partizan_flow_6336_v2.ab686c5864f020e08f96284f6c36aa84.jpg');" data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-8 text-center" data-aos="fade-up" data-aos-delay="400">

                            <center style="width: 800px;">
                                <div class="container-fluid">
                                    <h1 class="mt-4">
                                        Lista de Habitaciones
                                    </h1>
                                </div>


                            <c:choose>
                                <c:when test="${empty listaHabitaciones}">
                                    <div class="alert alert-danger col-md-4" role="alert" >
                                        Lista de Habitaciones Vacía
                                    </div>
                                </c:when>

                                <c:otherwise>

                                    <table class="table text-primary bg-dark table-wrapper-scroll-y my-custom-scrollbar">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Tipo</th>
                                                <th scope="col">Descripción</th>
                                                <th scope="col">Servicios</th>
                                                <th scope="col">Fotos</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach items="${listaHabitaciones}" var="habitacion">
                                                <tr>
                                                    <th scope="row">${habitacion.id}</th>
                                                    <td>${habitacion.tipoHabitacion.descripcion}</td> 
                                                    <td>${habitacion.descripcion}</td>
                                                    <td><button type="button" class="btn btn-info btn-sm" onclick="window.location.href = '/ResidenciaEstudiantes/ListaServiciosAdmin?id=${habitacion.id}'">Servicios</button></td>
                                                    <td><button type="button" class="btn btn-info btn-sm" onclick="window.location.href = '/ResidenciaEstudiantes/FotosHabitacionAdmin?id=${habitacion.id}'">Fotos</button></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                </c:otherwise>
                            </c:choose>

                        </center>
                    </div>
                </div>
            </div>
        </div>


        <jsp:include page="footerAdmin.jsp"></jsp:include>
        
        <style>
            .my-custom-scrollbar {
                position: relative;
                height: 540px;
                overflow: auto;
                overflow-y: scroll;
                overflow-x: hidden;
            }
            .table-wrapper-scroll-y {
                display: block;
            }
        </style>
        
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/mediaelement-and-player.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>
