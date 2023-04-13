<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@page import="com.restaurante.entidades.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Service Express</title>
        <!-- Layout styles -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <script type="text/javascript" src="assets/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%
            response.addHeader("Cache-Control", "no-cache");
            response.addHeader("Cache-Control", "no-store");
            
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        %>
        <div class="row col-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <b><a class="navbar-brand" href="${pageContext.servletContext.contextPath}/Principal">Inicio</a></b>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link ${tpv}" aria-current="page" href="${pageContext.servletContext.contextPath}/TPV">TPV</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${pingredientes}" aria-current="page" href="#">Productos e ingredientes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${compras}" href="#">Compras</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${salones}" aria-current="page" href="#">Salones</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${finanzas}" href="#">Finanzas</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${personal}" aria-current="page" href="#">Personal</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${reportes}" href="#">Reportes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${respaldos}" aria-current="page" href="#">Respaldos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${configuraciones}" aria-current="page" href="#">Configuraciones</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${sesion}" aria-current="page" href="#">Sesion</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${cxc}" aria-current="page" href="#">CxC</a>
                            </li>
                            <li class="nav-item">
                                <a class="col-lg-12 btn btn-danger" href="${pageContext.servletContext.contextPath}/Principal?accion=logout">
                                <p class="preview-subject mb-1">Cerrar Sesión</p>
                            </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- <div class="alert alert-primary" role="alert">
                A simple primary alert—check it out!
            </div>-->
            <div class="col-lg-12">
                <div class="col-lg-1" style="background-color: red">

                </div>
            </div>

