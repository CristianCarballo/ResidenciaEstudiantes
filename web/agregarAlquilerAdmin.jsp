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
                                        Alquiler
                                    </h1>
                                </div>
                                <p class="mb-4">Nuevo alquiler</p>

                            <form method="POST" action="AgregarAlquilerAdmin">

                                <p class="mb-0">Inquilino</p>
                                <select class="form-control col-md-4 text-primary bg-dark" id="idInquilino" name="idInquilino" required>
                                <c:forEach items="${listaInquilinosNoAlojados}" var="inquilino">
                                    <option value="${inquilino.id}">${inquilino}</option>
                                </c:forEach>
                                </select>
                                <small class="text-primary">¿Inquilino nuevo? ¡Necesitamos registrarlo!</small>
                                <p><a href="/ResidenciaEstudiantes/AgregarInquilinoAdmin" class="btn btn-dark btn-sm small">Agregar nuevo inquilino</a></p>

                                <p class="mb-0">Habitación</p>
                                <select class="form-control col-md-4 text-primary bg-dark" id="idHabitacion" name="idHabitacion" required>
                                    <c:forEach items="${listaHabitacionesDisponibles}" var="habitacionDisponible">
                                        <option value="${habitacionDisponible.id}">${habitacionDisponible}</option>
                                    </c:forEach>
                                </select>
                                <br>

                                <p class="mb-0">Fecha ingreso</p>
                                <input type="date" class="form-control col-md-4 text-primary bg-dark" name="dtpFechaIngreso" id="dtpFechaIngreso" min="2000-01-01" max="2100-12-31" step="1" required>
                                <br> <br>

                                <p class="mb-0">Fecha salida</p>
                                <input type="date" class="form-control col-md-4 text-primary bg-dark" name="dtpFechaSalida" id="dtpFechaSalida" min="2000-01-01" max="2100-12-31" step="1" required>
                                <br> <br>

                                <button type="submit" class="btn btn-primary text-dark" onclick="return validarFecha()">Aceptar</button>

                            </form>

                        </center>
                    </div>
                </div>
            </div>
        </div>


        <jsp:include page="footerAdmin.jsp"></jsp:include>

        <style>
            input[type=date]::-webkit-inner-spin-button, 
            input[type=date]::-webkit-outer-spin-button { 
                -webkit-appearance: none; 
                margin: 0; 
            }

            input[type="date"] {
                -webkit-align-items: center;
                display: -webkit-inline-flex;
                overflow: hidden;
                padding: 0px;
                -webkit-padding-start: 13px;
            }

            input[type="date"]::-webkit-clear-button {
                -webkit-appearance: none;
                display: none;
            }

            input[type="date"]::-webkit-datetime-edit {
                -webkit-flex: 1;
                -webkit-user-modify: read-only !important;
                display: inline-block;
                min-width: 0;
                overflow: hidden;
            }

            input[type="date"]::-webkit-datetime-edit-fields-wrapper {
                -webkit-user-modify: read-only !important;
                display: inline-block;
                padding: 1px 0;
                white-space: pre;
            }
        </style>

        <script>
            function validarFecha() {
                var ingreso = document.getElementById("dtpFechaIngreso").value;
                var salida = document.getElementById("dtpFechaSalida").value;
                var hoy = new Date();
                if (ingreso >= salida || ingreso < hoy) {
                    alert("Hay algún error con la fecha!!");
                    return false;
                }
                return true;
            }
        </script>

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
