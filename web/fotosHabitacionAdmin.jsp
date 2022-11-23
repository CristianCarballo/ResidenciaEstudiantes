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


            <div class="site-blocks-cover overlay" style="background-image: url('images/1545638571_473138_1545638867_noticia_normal.jpg');" data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-8 text-center" data-aos="fade-up" data-aos-delay="400">

                            <center>
                                <div class="container-fluid">
                                    <h1 class="mt-4">
                                        Galería de fotos
                                    </h1>
                                </div>


                            <c:choose>
                                <c:when test="${empty habitacion.fotos}">
                                    <div class="alert alert-danger col-md-4" role="alert" >
                                        Galería de Fotos Vacía
                                    </div>
                                    <form method="post" action="FotosHabitacionAdmin" enctype="multipart/form-data">
                                        <div class="custom-file">
                                            <input type="text" name="txtId" hidden="" value="${habitacion.id}"/>
                                            <input type="file" class="custom-file-input" id="customFile" name="archivo">
                                            <label class="custom-file-label" for="customFile">Agregar foto a esta habitación</label>
                                            <input type="submit" value="Enviar archivo" />
                                        </div>
                                    </form>       
                                </c:when>

                                <c:otherwise>


                                    <div id="images">
                                        <c:forEach items="${habitacion.fotos}" var="foto">
                                            <div class="item">
                                                <img src="fotos/${foto.descripcion}">
                                            </div>
                                        </c:forEach>
                                    </div>


                                    <form method="post" action="FotosHabitacionAdmin" enctype="multipart/form-data">
                                        <div class="custom-file">
                                            <input type="text" name="txtId" hidden="" value="${habitacion.id}"/>
                                            <input type="file" class="custom-file-input" id="customFile" name="archivo">
                                            <label class="custom-file-label" for="customFile">Agregar foto a esta habitación</label>
                                            <input type="submit" value="Enviar archivo" />
                                        </div>
                                    </form>

                                </c:otherwise>
                            </c:choose>

                        </center>
                    </div>
                </div>
            </div>
        </div>


        <jsp:include page="footerAdmin.jsp"></jsp:include>

        <style>
            .item {
                width: 350px;
                float: left;
            }
            .item img {
                display: block;
                width: 100%;
            }
        </style>
        <script>
            $(function () {

                var $container = $('#container').masonry({
                    itemSelector: '.item',
                    columnWidth: 200
                });

                // reveal initial images
                $container.masonryImagesReveal($('#images').find('.item'));
            });

            $.fn.masonryImagesReveal = function ($items) {
                var msnry = this.data('masonry');
                var itemSelector = msnry.options.itemSelector;
                // hide by default
                $items.hide();
                // append to container
                this.append($items);
                $items.imagesLoaded().progress(function (imgLoad, image) {
                    // get item
                    // image is imagesLoaded class, not <img>, <img> is image.img
                    var $item = $(image.img).parents(itemSelector);
                    // un-hide item
                    $item.show();
                    // masonry does its thing
                    msnry.appended($item);
                });

                return this;
            };
        </script>

        <script>
            $(".custom-file-input").on("change", function () {
                var fileName = $(this).val().split("\\").pop();
                $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
            });
        </script>

        <script src="//masonry.desandro.com/masonry.pkgd.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery.imagesloaded/3.0.4/jquery.imagesloaded.js"></script>
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
