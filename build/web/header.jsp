<%-- 
    Document   : header
    Created on : 08/11/2019, 10:25:16
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="site-wrap">

    <div class="site-navbar mt-4">
        <div class="container py-1">
            <div class="row align-items-center">
                <div class="col-8 col-md-8 col-lg-4">
                    <h1 class="mb-0"><a href="/ResidenciaEstudiantes/Index" class="text-white h2 mb-0"><strong>Apart<span class="text-primary">.</span></strong></a></h1>
                </div>
                <div class="col-4 col-md-4 col-lg-8">
                    <nav class="site-navigation text-right text-md-right" role="navigation">

                        <div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>

                        <ul class="site-menu js-clone-nav d-none d-lg-block">
                            <li class="active">
                                <a href="/ResidenciaEstudiantes/Index">Inicio</a>
                            </li>
                            <li class="has-children">
                                <a>Habitaciones</a>
                                <ul class="dropdown arrow-top">
                                    <li><a href="/ResidenciaEstudiantes/ListaHabitaciones">Ver Habitaciones</a></li>
                                    <li><a href="/ResidenciaEstudiantes/ListaServicios">Ver Servicios</a></li>
                                </ul>
                            </li>
                            <li><a href="/ResidenciaEstudiantes/Login">Ingresá con tu usuario (sólo para personal)</a></li>
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
