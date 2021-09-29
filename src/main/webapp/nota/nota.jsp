<%-- 
    Document   : nota
    Created on : 26/09/2021, 12:40:09 AM
    Author     : Diego Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="../assets/css/style.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css"> 
        <link rel="icon" type="image/png" href="../assets/images/favicon.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"rel="stylesheet">
        <script src="https://kit.fontawesome.com/bc893c1d65.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">



        <title>Listado notas</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <div class="shadow p-3 m-4 fs-3 bg-primary bg-gradient rounded text-center text-white col-11 mx-auto"><i class="fas fa-list"></i> Listado notas <i class="fas fa-sm fa-user-clock align-middle"></i></div>

        <!-- Boton para agregar -->
        <div class="col-11 mx-auto">
            <a href="#" class="btn btn-success btn-block" data-bs-toggle="modal" data-bs-target="#addModal">
                <i class="fas fa-plus"></i>
                Agregar Nota 
            </a>    
        </div>  

        <!-- Modal -->
        <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-primary text-white">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar una nueva nota</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletNotaController" class="was-validated">
                        <div class="modal-body">

                            <div class="mb-3">
                                <label for="nombreActividad" class="form-label">Nombre de la actividad</label>
                                <input type="text" class="form-control" name="nombreActividad" id="nombreActividad" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="notaActividad">Nota de actividad</label>
                                <input type="number" class="form-control" name="notaActividad" id="notaActividad" step="1" value="0" min="0" max="100" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="fechaEntrega">Fecha de entrega</label>
                                <input class="form-control" type="date" id="fechaEntrega" name="fechaEntrega">
                            </div>
                            <div class="mb-3">
                                <label for="idAsignacion" class="form-label">Asignación</label>
                                <select class="form-select" name="idAsignacion" id="idAsignacion" required>

                                    <c:forEach var="asignacionAlumno" items="${listadoAsginacion}">
                                        <option value="${asignacionAlumno.idAsignacion}">ID: ${asignacionAlumno.idAsignacion} | Carne: ${asignacionAlumno.carne} | Curso: ${asignacionAlumno.idCurso} | Fecha asignación: ${asignacionAlumno.fecha_asignacion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <input type="hidden" name="accion" value="insertar">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Guardar</button>
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
                        <th>Actividad</th>
                        <th>Nota</th>
                        <th>Fecha de entrega</th>
                        <th>ID asignación</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="nota" items="${listadoNota}">
                        <tr>
                            <td>${nota.idNota}</td>
                            <td>${nota.nombreActividad}</td>
                            <td>${nota.notaActividad}</td>
                            <td>${nota.fechaEntrega}</td>
                            <td>${nota.asignacionAlumno.getIdAsignacion()}</td>
                            
                            <td>
                                <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletNotaController?accion=editar&idNota=${nota.idNota}"><i class="far fa-edit"></i>  Editar</a>
                            </td>
                            <td>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletNotaController?accion=eliminar&idNota=${nota.idNota}"><i class="fas fa-trash"></i>  Eliminar</a>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12 col-md-4">
                    <div class="card text-center bg-secondary text-white mb-3">
                        <div class="card-body">
                            <h3>Promedio de notas</h3>
                            <h4 class="display-4">
                                <i class="fas fa-clipboard"></i> ${promedioTotal}
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-4">
                    <div class="card text-center bg-success text-white mb-3">
                        <div class="card-body">
                            <h3>Cantidad de actividades aprobadas</h3>
                            <h4 class="display-4">
                                <i class="fas fa-check"></i> ${aprobados}
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-4">
                    <div class="card text-center bg-danger text-white mb-3">
                        <div class="card-body">
                            <h3>Cantidad de actividades reprobados</h3>
                            <h4 class="display-4">
                                <i class="fas fa-times"></i> ${reprobados}
                            </h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        <!--Javascript-->
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

        
        <script>
            flatpickr("input[type=date]", {});
        </script>







    </body>
</html>
