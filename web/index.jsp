<%-- 
    Document   : index
    Created on : 12 abr. 2023, 08:38:00
    Author     : fruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesion</title>
        <!-- Layout styles -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <script type="text/javascript" src="assets/js/bootstrap.bundle.min.js"></script>
    </head>
    <body onload="cargarDatos()">
        <div class="container">
            <div class="row justify-content-center align-items-center vh-100">
                <div class="card p-5 col-sm-12 col-md-7 col-xl-5 col-xxl-5 col-lg-5 h-auto">
                    <a href="" class="text-center" onclick="abrirVentana()">
                        <img src="assets/images/bDatos.png" class="" alt="...">
                    </a>

                    <div class="card-body">
                        <form name="main" action="Login?accion=login" method="POST">
                            <label for="txtPin" class="form-label">Digite su pin de seguridad <span class="text-danger">*</span></label>
                            <input name="txtPin" type="password" id="txtPin" class="form-control" aria-describedby="passwordHelpBlock">
                            <div id="passwordHelpBlock " class="form-text m-2">
                                <button type="submit" class="btn btn-primary float-end">Entrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        function abrirVentana() {
            var ancho = 500;
            var alto = 500;
            var izquierda = (window.screen.width / 2) - (ancho / 2);
            var arriba = (window.screen.height / 2) - (alto / 2);
            var vEmergente = window.open("conexionBD.jsp", "Configurar conexion", "width=" + ancho + ",height=" + alto + ",left=" + izquierda + ",top=" + arriba);
            vEmergente.onbeforeunload = function () {
                alert("helou");
                cargarDatos();
                alert("helou");
            }
        }
        function cargarDatos() {
            var usuarioBD = localStorage.getItem("usuarioBD");
            document.getElementById("txtPin").value = usuarioBD;
        }

    </script>
</html>
