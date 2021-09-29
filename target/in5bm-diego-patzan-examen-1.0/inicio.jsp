<%-- Document : index Created on : 3/09/2021, 11:20:12 AM Author : gabri --%>
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
        <title>Control Academico</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        <div class="card mx-auto mt-4 col-11 col-sm-5" style="z-index: -1;">
            <div id="titulo-bienvenida" class="card-header bg-dark">
                <i class="material-icons md-30 align-middle text-white">school</i>
            </div>
            <img src="./assets/images/estudiantes.jpg" class="card-img-top">
            <div class="card-body">
                <h5 class="card-title">¡Bienvenido al sistema de control académico!</h5>
                <p class="card-text">En este sistema podrá administrar los datos de las diferentes entidades de su institución.</p>
            </div>
        </div>
        <div class="mx-auto mb-4 col-11 col-sm-5">
            <a class="btn btn-success w-100"
               data-target="${pageContext.request.contextPath}/index.jsp" href="${pageContext.request.contextPath}/index.jsp"
               >Cerrar Sesión</a
            >
        </div>       

        <!--Javascript-->
        <script src="assets/js/jquery-3.6.0.js"></script>
        <script src="assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
