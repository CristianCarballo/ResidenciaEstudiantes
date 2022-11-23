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


            <div class="site-blocks-cover overlay" style="background-image: url('images/hero_bg_5.jpg');" data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-8 text-center" data-aos="fade-up" data-aos-delay="400">
                            <center>
                                <div class="container-fluid">
                                    <h1 class="mt-4">
                                        Tipo de Habitación
                                    </h1>
                                </div>
                                <p class="mb-4">Agregar o modificar tipo de habitación</p>

                                <form method="POST" action="AgregarTipoHabitacionAdmin">

                                    <input type="text" 
                                           name="txtId" 
                                           hidden="" 
                                           value="${tipoHabitacion.id}" 
                                    class="form-control col-md-4 text-primary bg-dark"
                                    />

                                <p class="mb-0">Descripción</p>
                                <input type="text" 
                                       name="txtDescripcion" 
                                       id="txtDescripcion" 
                                       value="${tipoHabitacion.descripcion}" 
                                       class="form-control col-md-4 text-primary bg-dark"  
                                       placeholder="Descripción"
                                       pattern="[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+{1,40}" 
                                       title="Debe contener entre 1 y 40 caracteres, solo letras"
                                       required/>
                                <br>

                                <p class="mb-0">Capacidad</p>
                                <input type="number" 
                                       name="txtCapacidad" 
                                       id="txtCapacidad" 
                                       value="${tipoHabitacion.capacidad}" 
                                       class="form-control col-md-4 text-primary bg-dark"  
                                       placeholder="Capacidad"
                                       min="1"
                                       max="99"
                                       step="1"
                                       title="Debe contener entre 1 y 2 caracteres, solo números"
                                       maxlength="2"
                                       required/>
                                <br>

                                <p class="mb-0">Precio</p>
                                <input 
                                    type="number" 
                                    name="txtPrecio" 
                                    id="txtPrecio" 
                                    value="${tipoHabitacion.precio}" 
                                    class="form-control col-md-4 text-primary bg-dark" 
                                    placeholder="Precio"
                                    min="0"
                                    max="999999"
                                    step="0.01"
                                    title="Debe contener entre 1 y 7 caracteres, solo números"
                                    maxlength="10"
                                    required/>
                                <br>

                                <button type="submit" class="btn btn-primary text-dark">Guardar cambios</button>
                            </form>
                        </center>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footerAdmin.jsp"></jsp:include>


        <style>
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none; 
                margin: 0; 
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
