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

            <div class="site-blocks-cover overlay" style="background-image: url('images/contrato-de-transaccion.jpg');" data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-8 text-center" data-aos="fade-up" data-aos-delay="400">

                            <center>
                                <div class="container-fluid">
                                    <h1 class="mt-4">
                                        Lista de Alquileres
                                    </h1>
                                </div>


                            <c:choose>
                                <c:when test="${empty listaDetalleAlquiler}">
                                    <div class="alert alert-danger col-md-4" role="alert" >
                                        Lista de Alquileres Vacía
                                    </div>
                                </c:when>

                                <c:otherwise>


                                    <div>
                                        <table class="table text-primary bg-dark table-wrapper-scroll-y my-custom-scrollbar">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Id</th>
                                                    <th scope="col">Inquilino</th>
                                                    <th scope="col">Habitación</th>
                                                    <th scope="col">Fecha</th>
                                                    <th scope="col">Precio</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach items="${listaDetalleAlquiler}" var="detalleAlquiler">
                                                    <tr>
                                                        <th scope="row">${detalleAlquiler.alquiler.id}</th>
                                                        <td>${detalleAlquiler.inquilino}</td>
                                                        <td>${detalleAlquiler.alquiler.habitacion.tipoHabitacion.descripcion}</td>
                                                        <td>${detalleAlquiler.alquiler.fecha}</td>
                                                        <td>${detalleAlquiler.alquiler.precio}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>

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
