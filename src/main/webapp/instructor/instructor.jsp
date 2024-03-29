<%-- 
    Document   : estudiante
    Created on : 2/09/2021, 11:06:38 AM
    Author     : Axel Javier Guadalupe Alvarez Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../assets/css/style.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css"> 
        <link rel="icon" type="image/png" href="../assets/images/favicon.png">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <script src="https://kit.fontawesome.com/bc893c1d65.js" crossorigin="anonymous"></script>
        <title>Listado Instructores</title>
    </head>

    <body>

        <!-- cabecera -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>

        <div class="shadow p-3 m-4 fs-3 bg-primary bg-gradient rounded text-center text-white col-11 mx-auto">
            <i class="fas fa-list"></i> Listado instructores <i class="fas fa-sm fa-chalkboard-teacher"></i>
        </div>

        <div class="col-11 mx-auto">
            <a href="#" class="btn btn-success btn-block" data-bs-toggle="modal" data-bs-target="#addModal">
                <i class="fas fa-plus"></i>
                Agregar Instructor 
            </a>    
        </div>  

        <!-- Modal -->
        <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-primary text-white">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar instructor</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    
                    <form method="POST" action="${pageContext.request.contextPath}/ServletInstructorController" class="was-validated">

                        <div class="modal-body">

                            <div class="mb-3">
                                <label for="apellidos" class="form-label">Apellidos </label>
                                <input type="text" class="form-control" name="apellidos" id="apellidos" required>                                   
                            </div>

                            <div class="mb-3">
                                <label for="nombres" class="form-label">Nombres </label>
                                <input type="text" class="form-control" name="nombres" id="nombres" required>                                   
                            </div>

                            <div class="mb-3">
                                <label for="direccion" class="form-label">Dirección </label>
                                <input type="text" class="form-control" name="direccion" id="direccion" required>                                   
                            </div>

                            <div class="mb-3">
                                <label for="telefono" class="form-label">Teléfono </label>
                                <input type="tel" class="form-control" name="telefono" id="telefono" required>                                   
                            </div>   
                            
                            <input type="hidden" name="accion" value="insertar">
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-success">Guardar</button>                            
                        </div>
                    </form>
                </div>
            </div>
        </div>  

        <div class="table-responsive my-3 col-11 mx-auto">
            <table class="table table-secondary table-hover table-responsive align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Apellidos</th>
                        <th>Nombres</th>
                        <th>Direccion</th>
                        <th>Telefono</th>
                        <th> </th>
                        <th> </th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="instructor" items="${listadoInstructor}">
                        <tr>
                            <td>${instructor.idInstructor}</td>
                            <td>${instructor.apellidos}</td>
                            <td>${instructor.nombres}</td>
                            <td>${instructor.direccion}</td>
                            <td>${instructor.telefono}</td>
                            <td>
                                <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletInstructorController?accion=editar&idInstructor=${instructor.idInstructor}">
                                    <i class="far fa-edit"></i> Editar
                                </a>
                            </td>
                            <td>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletInstructorController?accion=eliminar&idInstructor=${instructor.idInstructor}">
                                    <i class="fas fa-trash"></i> Eliminar
                                </a>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
                    
        <!-- footer -->
        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        
        <!--Javascript-->
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>
        
    </body>
    
</html>