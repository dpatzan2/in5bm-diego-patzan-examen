<%-- 
    Document   : login
    Created on : 15/09/2021, 10:37:37 PM
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./assets/css/bootstrap.css"> 
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/barra-navegacion.css">
        <link rel="icon" type="image/png" href="./assets/images/favicon.png">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <script src="https://kit.fontawesome.com/bc893c1d65.js" crossorigin="anonymous"></script>
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid justify-content-center">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"
                   >Control <i class="material-icons fs-2 align-middle">school</i>&nbsp Académico</a
                >
            </div>
        </nav>

        <div class="card col-11 col-sm-5 p-5 position-absolute top-50 start-50 translate-middle bg-dark text-white text-center">
            <div class="card-body">
                <div class="mb-4">
                    <i class="fas fa-user-circle fa-7x"></i>
                </div>
                <form method="POST" action="${pageContext.request.contextPath}/ServletLoginController" class="was-validated">
                    <div class="mb-3">
                        <label class="form-label" for="usuario">Usuario</label>
                        <input type="text" class="form-control" name="usuario" id="usuario" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="clave">Contraseña</label>
                        <input type="password" class="form-control" name="clave" id="clave" required>
                    </div>
                    <p class="text-danger">${mensaje}</p>
                    <button type="submit" class="btn btn-outline-primary">Iniciar Sesión</button>
                </form>
            </div>
        </div>

        <!--Javascript-->
        <script src="assets/js/jquery-3.6.0.js"></script>
        <script src="assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
