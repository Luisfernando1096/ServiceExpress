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
    <body>
        <div class="container">
            <div class="row justify-content-center align-items-center vh-100">
                <div class="card p-5" style="width: 20rem;">
                    <div class="card-body">
                        <label for="usuarioBD" class="form-label">Usuario:</label>
                        <input name="usuarioBD" type="text" id="usuarioBD" value="${usuario}" class="form-control" aria-describedby="passwordHelpBlock">
                        <div id="passwordHelpBlock" class="form-text">
                            <button onclick="cerrarVentana()" class="btn btn-primary">Entrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        function cerrarVentana() {
            // Cerrar la ventana emergente
            window.close();
            window.opener.cargarDatos();
        }
        var miInput = document.getElementById("usuarioBD");
        miInput.value = localStorage.getItem("usuarioBD");
        miInput.addEventListener("change", function () {
            localStorage.setItem("usuarioBD", miInput.value);
        });


    </script>
</html>
