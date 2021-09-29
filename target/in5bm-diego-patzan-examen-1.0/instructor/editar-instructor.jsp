<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/bootstrap.css"> 
        <link rel="icon" type="image/png" href="../assets/images/favicon.png">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <script src="https://kit.fontawesome.com/bc893c1d65.js" crossorigin="anonymous"></script>
        <title>Editar instructores</title>
    </head> 

    <body>

        <!-- cabecera -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>



        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="card mt-5">
                            <div class="card-header bg-black text-light">
                                <h4 class="text-center">Editar Instructor</h4>
                            </div>
                            <div class="card-body bg-dark text-light">

                                <form method="POST" action="${pageContext.request.contextPath}/ServletInstructorController" class="was-validated">


                                    <div class="mb-3">
                                        <label for="apellidos" class="form-label">Apellidos </label>
                                        <input type="text" class="form-control" name="apellidos" id="apellidos" required value="${instructor.apellidos}">                                   
                                    </div>

                                    <div class="mb-3">
                                        <label for="nombres" class="form-label">Nombres </label>
                                        <input type="text" class="form-control" name="nombres" id="nombres" required value="${instructor.nombres}">                                   
                                    </div>

                                    <div class="mb-3">
                                        <label for="direccion" class="form-label">Dirección </label>
                                        <input type="text" class="form-control" name="direccion" id="direccion" required value="${instructor.direccion}">                                   
                                    </div>

                                    <div class="mb-3">
                                        <label for="telefono" class="form-label">Teléfono </label>
                                        <input type="tel" class="form-control" name="telefono" id="telefono" required value="${instructor.telefono}">                                   
                                    </div>   


                                    <input type="hidden" name="idInstructor" value="${instructor.idInstructor}">
                                    <input type="hidden" name="accion" value="actualizar">


                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href = '${pageContext.request.contextPath}/ServletInstructorController?accion=listar'">
                                        Cancelar
                                    </button>
                                    <button type="submit" class="btn btn-success">Guardar cambios</button>                            

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- footer -->
        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>

        <!-- JavaScript -->
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>

    </body>

</html>