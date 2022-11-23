<%-- 
    Document   : headerAdmin
    Created on : 08/11/2019, 10:28:35
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="site-wrap">

    <div class="site-navbar mt-4">
        <div class="container py-1">
            <div class="row align-items-center">
                <div class="col-8 col-md-8 col-lg-4">
                    <h1 class="mb-0"><a href="/ResidenciaEstudiantes/menuAdministracion.jsp" class="text-white h2 mb-0"><strong>Apart<span class="text-primary">.</span></strong></a></h1>
                </div>
                <div class="col-4 col-md-4 col-lg-8">
                    <nav class="site-navigation text-right text-md-right" role="navigation">

                        <div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>

                        <ul class="site-menu js-clone-nav d-none d-lg-block">
                            <li class="has-children">
                                <a>Contabilidad</a>
                                <ul class="dropdown arrow-top">
                                    <li><a href="/ResidenciaEstudiantes/AgregarAlquilerAdmin">Nuevo alquiler</a></li>
                                    <li><a href="/ResidenciaEstudiantes/ListaAlquileresAdmin">Alquileres</a></li>
                                    <li><a href="/ResidenciaEstudiantes/AgregarPagoAdmin">Pagos</a></li>
                                    <li><a href="/ResidenciaEstudiantes/ListaRecaudacionPorHabitacionAdmin">Recaudación por habitación</a></li>
                                    <li><a href="/ResidenciaEstudiantes/ListaRecaudacionPorInquilinoAdmin">Recaudación por inquilino</a></li>
                                </ul>
                            </li>
                            <li class="has-children">
                                <a>Inquilinos</a>
                                <ul class="dropdown arrow-top">
                                    <li><a href="/ResidenciaEstudiantes/AgregarInquilinoAdmin">Nuevo inquilino</a></li>
                                    <li><a href="/ResidenciaEstudiantes/ListaInquilinosAdmin">Lista de inquilinos</a></li>
                                </ul>
                            </li>
                            <li class="has-children">
                                <a>Habitaciones</a>
                                <ul class="dropdown arrow-top">
                                    <li><a href="/ResidenciaEstudiantes/ListaHabitacionesAdmin">Lista de habitaciones</a></li>
                                    <li class="has-children">
                                        <a>Tipos de habitación</a>
                                        <ul class="dropdown">
                                            <li><a href="/ResidenciaEstudiantes/AgregarTipoHabitacionAdmin">Nuevo tipo de habitación</a></li>
                                            <li><a href="/ResidenciaEstudiantes/ListaTiposHabitacionesAdmin">Lista de tipos de habitación</a></li>
                                        </ul>
                                    </li>
                                    <li class="has-children">
                                        <a>Servicios</a>
                                        <ul class="dropdown">
                                            <li><a href="/ResidenciaEstudiantes/AgregarServicioAdmin">Nuevo servicio</a></li>
                                            <li><a href="/ResidenciaEstudiantes/ListaServiciosAdmin">Lista de servicios</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="/ResidenciaEstudiantes/Login?accion=cerrar">Cerrar sesión</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="site-mobile-menu">
    <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>
        </div>
    </div>
    <div class="site-mobile-menu-body"></div>
</div> <!-- .site-mobile-menu -->