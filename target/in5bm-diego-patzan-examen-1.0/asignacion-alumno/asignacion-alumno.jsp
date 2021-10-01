<%-- 
    Document   : AsignacionAlumno
    Created on : 31/08/2021, 10:05:12 AM
    Author     : Windows 10
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
        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>



        <title>Listado Asignaciones</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <div class="shadow p-3 m-4 fs-3 bg-primary bg-gradient rounded text-center text-white col-11 mx-auto"><i class="fas fa-list"></i> Listado Asignaciones <i class="fas fa-sm fa-user-clock align-middle"></i></div>

        <!-- Boton para agregar -->
        <div class="col-11 mx-auto">
            <a href="#" class="btn btn-success btn-block" data-bs-toggle="modal" data-bs-target="#addModal">
                <i class="fas fa-plus"></i>
                Agregar Asignacion 
            </a>    
        </div>  
        <!-- Modal -->
        <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-primary text-white">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar un nuevo estudiante</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletAsignacionAlumnoController" class="was-validated">
                        <div class="modal-body">
                            
                            <div class="mb-3">
                                <label for="carne" class="form-label">Carné del alumno</label>
                                <select class="form-select"   name="carne" id="mibuscador carne" data-placeholder="- Seleccione un alumno -" required>
                                    <c:forEach var="alumno" items="${listadoAlumno}">
                                        <option value="${alumno.carne}">Carné: ${alumno.carne} | Alumno: ${alumno.nombres} ${alumno.apellidos}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="curso" class="form-label">Curso</label>
                                <select class="form-select" name="idCurso" id="curso" required>
                                    
                                    <c:forEach var="curso" items="${listadoCursos}">
                                        <option value="${curso.idCurso}">ID: ${curso.idCurso} | ${curso.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">*Fecha Asignación generado automaticamente*</label>
                                
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
                        <th>Alumno</th>
                        <th>Curso</th>
                        <th>Fecha de asignacion</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="asignacionAlumno" items="${listadoAsignacionAlumno}">
                        <tr>
                            <td>${asignacionAlumno.idAsignacion}</td>
                            <td>${asignacionAlumno.carne}</td>
                            <td>${asignacionAlumno.idCurso}</td>
                            <td>${asignacionAlumno.fecha_asignacion}</td>
                            <td>
                                <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletAsignacionAlumnoController?accion=editar&idAsignacion=${asignacionAlumno.idAsignacion}"><i class="far fa-edit"></i>  Editar</a>
                            </td>
                            <td>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletAsignacionAlumnoController?accion=eliminar&idAsignacion=${asignacionAlumno.idAsignacion}"><i class="fas fa-trash"></i>  Eliminar</a>
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




        <script type="text/javascript">
            $(document).ready(function () {
                $('#mibuscador').select2();
            });
        </script>


    </body>
</html>