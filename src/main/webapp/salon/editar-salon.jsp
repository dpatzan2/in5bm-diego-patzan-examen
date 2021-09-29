<%-- 
    Document   : Salon
    Created on : 2/09/2021, 07:39:41 PM
 Author     : Cesar Rosales // Codigo Técnico: IN5BM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/bootstrap.css"> 
        <link rel="icon" type="image/png" href="./assets/images/favicon.png">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <script src="https://kit.fontawesome.com/bc893c1d65.js" crossorigin="anonymous"></script>
        <title>Editar Salones</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>


        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="card mt-5">
                            <div class="card-header bg-black text-light">
                                    <h4 class="text-center">Editar Salon</h4>
                            </div>
                            <div class="card-body bg-dark text-light">

                                <form method="POST" action="${pageContext.request.contextPath}/ServletSalonController" class="was-validated">
                                    <div class="mb-3">
                                        <label class="form-label" for="nombre">Nombre</label>
                                        <input value="${salon.nombreSalon}" type="text" class="form-control" name="nombre" id="nombre" required>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="descripcion">Descripción</label>
                                        <input value="${salon.descripcion}" type="text" class="form-control" name="descripcion" id="descripcion" required>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="capacidad">Capacidad</label>
                                        <input value="${salon.capacidad}" type="number" class="form-control" name="capacidad" id="capacidad" min="5" max="50" value="5" required>
                                    </div>
                                    <input type="hidden" name="salonId" value="${salon.salonId}">
                                    <input type="hidden" name="accion" value="actualizar">

                                    <a class="btn btn-secondary"
                                       href="${pageContext.request.contextPath}/ServletSalonController?accion=listar"
                                       >Cancelar</a
                                    >

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
