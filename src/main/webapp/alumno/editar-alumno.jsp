<%-- 
    Document   : editar-alumno
    Created on : 14 sep 2021, 17:00:54
    Author     : ricar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/barra-navegacion.css">
        <link rel="stylesheet" href="./assets/css/bootstrap.css"> 
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <script src="https://kit.fontawesome.com/bc893c1d65.js" crossorigin="anonymous"></script>
        <title>Editar Alumnos</title>
    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="card mt-5">
                            <div class="card-header bg-black text-light">
                                <h4 class="text-center">Editar Alumno</h4>
                            </div>
                            <div class="card-body bg-dark text-white">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletAlumnoController" class="was-validated">
                                    <div class="mb-3">
                                        <label for="apellidos" class="form-label">Apellidos</label>
                                        <input type="text" class="form-control" name="apellidos" id="apellidos" required value="${alumno.apellidos}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="nombres" class="form-label">Nombres</label>
                                        <input type="text" class="form-control" name="nombres" id="nombres" required value="${alumno.nombres}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="email" class="form-label">Email</label>
                                        <input type="email" class="form-control" name="email" id="email" required value="${alumno.email}">
                                    </div>

                                    <input type="hidden" name="carne" value="${alumno.carne}">
                                    <input type="hidden" name="accion" value="actualizar">
                                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletAlumnoController?accion=listar">Cancelar</a>

                                    <button type="submit" class="btn btn-success">Guardar</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        <!--Javascript-->
        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
