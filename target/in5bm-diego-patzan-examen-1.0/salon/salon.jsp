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
        <link rel="stylesheet" href="../assets/css/style.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css"> 
        <link rel="icon" type="image/png" href="../assets/images/favicon.png">
        <link rel="icon" type="image/png" href="../assets/images/favicon.png">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <script src="https://kit.fontawesome.com/bc893c1d65.js" crossorigin="anonymous"></script>
        <title>Listado Salones</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <div class="shadow p-3 m-4 fs-3 bg-primary bg-gradient rounded text-center text-white col-11 mx-auto"><i class="fas fa-list"></i> Listado Salones <i class="fas fa-sm fa-chalkboard align-middle"></i></div>
        <div class="col-11 mx-auto">
            <a href="#" class="btn btn-success btn-block" data-bs-toggle="modal" data-bs-target="#addModal">
                <i class="fas fa-plus"></i>
                Agregar Salon 
            </a>    
        </div>  
        
         <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-primary text-white">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Salon</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletSalonController" class="was-validated">
                            <div class="modal-body">
                                <div class="mb-3">
                                    <label class="form-label" for="nombre">Nombre</label>
                                    <input type="text" class="form-control" name="nombre" id="nombre" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="descripcion">Descripción</label>
                                    <input type="text" class="form-control" name="descripcion" id="descripcion" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="capacidad">Capacidad</label>
                                    <input type="number" class="form-control" name="capacidad" id="capacidad" min="5" max="50" value="5" required>
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
                <tr class="table-dark">
                    <th>#</th>
                    <th>capacidad</th>
                    <th>descripcion</th>
                    <th>Nombre del Salon</th>
                    <th></th>
                    <th></th>
                </tr>
                <tbody>
                    <c:forEach var="salon" items="${listadoSalon}">
                        <tr>
                            <td>${salon.salonId}</td>
                            <td>${salon.capacidad}</td>
                            <td>${salon.descripcion}</td>
                            <td>${salon.nombreSalon}</td>
                            <td> <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletSalonController?accion=editar&salonId=${salon.salonId}"><i class="far fa-edit"></i> Editar</a>
                            </td>
                            <td> <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletSalonController?accion=eliminar&salonId=${salon.salonId}"><i class="fas fa-trash"></i>  Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        <!--Javascript-->
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>
    </body>
</html>