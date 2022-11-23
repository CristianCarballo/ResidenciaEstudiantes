<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

        <jsp:include page="header.jsp"></jsp:include>

        <div class="site-blocks-cover overlay" style="background-image: url('images/hero_bg_4.jpg');" data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-8 text-center" data-aos="fade-up" data-aos-delay="400">
                        <h1 class="mb-4">Un excelente lugar para tu siguiente carrera</h1>
                        <p class="mb-5">Maestro M. Lopez esq. Cruz Roja Argentina - Ciudad Universitaria<br>Córdoba Capital - Argentina</p>
                        <p><a href="/ResidenciaEstudiantes/ListaHabitaciones" class="btn btn-primary px-5 py-3 text-dark">Ver Habitaciones</a></p>

                    </div>
                </div>
            </div>
        </div>



        <ul class="property-list-details mb-5">
            <c:forEach items="${listaServicios}" var="servicio">
                <li class="list-unstyled">
                    <div class="container">
                        <div class="featured-property-half d-flex">
                            <div class="text">
                                <ul class="property-list-details mb-5">
                                    <li>Descripción: <strong>${servicio.descripcion}</strong></li>
                                    <li>Precio: <strong>${servicio.precio}</strong></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>


        <jsp:include page="footer.jsp"></jsp:include>

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
