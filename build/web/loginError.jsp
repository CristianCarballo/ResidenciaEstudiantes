<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


            <div class="site-blocks-cover overlay" style="background-image: url('images/hero_bg_3.jpg');" data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-8 text-center" data-aos="fade-up" data-aos-delay="400">


                            <center>
                                <div class="container-fluid">
                                    <h1 class="mt-4">
                                        Ingresar con mi Cuenta
                                    </h1>
                                </div>

                                <div class="alert alert-danger col-md-4" role="alert" >
                                    Algo anduvo mal. Ingresá nuevamente.
                                </div>

                                <form method="POST" action="Login">
                                    <div class="form-group">
                                        <p class="mb-4">Administración de Apart.</p>
                                        <input type="email" 
                                               id="email" 
                                               class="form-control col-md-4 text-primary bg-dark"  
                                               name="txtUsuario" 
                                               aria-describedby="emailHelp" 
                                               placeholder="Correo Electrónico"
                                               pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]){8,20}"
                                               title="Debe contener al entre 8 y 20 caracteres, sólo números o letras"
                                               required
                                               />
                                    </div>


                                    <div class="form-group">
                                        <input type="password" 
                                               id="psw" 
                                               class="form-control col-md-4 text-primary bg-dark" 
                                               name="txtPass"
                                               placeholder="Contraseña"
                                               pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]){8,20}"
                                               title="Debe contener al menos un número, una letra mayúscula, una letra minúscula y más de 8 caracteres"
                                               required
                                               />
                                    </div>

                                    <button type="submit" class="btn btn-primary text-dark">Acceder</button>

                                </form>
                            </center>

                        </div>
                    </div>
                </div>
            </div>


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
