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
                    <a href="">
                        <img src="assets/images/bDatos.png" class="" alt="...">
                    </a>

                    <div class="card-body">
                        <form name="main" action="Login?accion=login" method="POST">
                            <label for="inputPassword5" class="form-label">Digite su pin de seguridad</label>
                            <input name="clave" type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock">
                            <div id="passwordHelpBlock" class="form-text">
                                <button type="submit" class="btn btn-primary">Entrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
