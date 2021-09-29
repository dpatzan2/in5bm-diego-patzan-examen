<%-- 
    Document   : Cursos
    Created on : 30/08/2021, 06:43:15 PM
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
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
        <title>Listado Cursos</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>

        <div class="shadow p-3 m-4 fs-3 bg-primary bg-gradient rounded text-center text-white col-11 mx-auto"><i class="fas fa-list"></i> Listado Cursos <i class="fas fa-sm fa-book align-middle"></i></div>

        <div class="col-11 mx-auto">
            <a href="#" class="btn btn-success btn-block" data-bs-toggle="modal" data-bs-target="#addModal">
                <i class="fas fa-plus"></i>
                Agregar Curso 
            </a>    
        </div>  

        <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-primary text-white">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar Curso</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletCursosController" class="was-validated">
                        <div class="modal-body">
                            <div class="mb-3">
                                <label class="form-label" for="ciclo">Ciclo</label>
                                <input type="number" class="form-control" name="ciclo" id="ciclo" step="1" value="2021" min="2021" max="2025" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="cupo-maximo">Cupo Maximo</label>
                                <input type="number" class="form-control" name="cupo-maximo" id="cupo-maximo" step="1" value="10" min="10" max="50" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="cupo-minimo">Cupo Minimo</label>
                                <input type="number" class="form-control" name="cupo-minimo" id="cupo-minimo" step="1" value="5" min="5" max="10" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="descripcion">Descripción</label>
                                <input type="text" class="form-control" name="descripcion" id="descripcion" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="carrera">Carrera</label>
                                <select class="form-select" aria-label="Default select example" name="carrera" id="carrera" required>
                                    <c:forEach var="carrera" items="${listadoCarrera}">
                                        <option  value="${carrera.codigo_carrera}">${carrera.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="horario">Horario</label>
                                <select class="form-select" aria-label="Default select example" name="horario" id="horario" required>
                                    <c:forEach var="horario" items="${listadoHorario}">
                                        <option value="${horario.idHorario}">${horario.horarioInicio} a ${horario.horarioFinal}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="instructor">Instructor</label>
                                <select class="form-select" aria-label="Default select example" name="instructor" id="instructor" required >
                                    <c:forEach var="instructor" items="${listadoInstructor}">
                                        <option value="${instructor.idInstructor}">${instructor.nombres} ${instructor.apellidos}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="salon">Salon</label>
                                <select class="form-select" aria-label="Default select example" name="salon" id="salon" required >
                                    <c:forEach var="salon" items="${listadoSalon}">
                                        <option value="${salon.salonId}">${salon.nombreSalon} | ${salon.descripcion}</option>
                                    </c:forEach>
                                </select>
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

        <div class="table-responsive my-3 col-11 mx-auto" >
            <table class="table table-secondary table-hover table-responsive align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Ciclo</th>
                        <th>Cupo Maximo</th>
                        <th>Cupo Minimo</th>
                        <th>Descripción</th>
                        <th>Carrera</th>
                        <th>Horario inicio</th>
                        <th>Horario final</th>
                        <th>Instructor</th>
                        <th>Salon</th>
                        <th></th>
                        <th></th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var="curso" items="${listadoCursos}">
                        <tr>
                            <td>${curso.idCurso}</td>
                            <td>${curso.ciclo}</td>
                            <td>${curso.cupoMaximo}</td>
                            <td>${curso.cupoMinimo}</td>
                            <td>${curso.descripcion}</td>
                            <td>${curso.carrera}</td>
                            <td>${curso.horarioInicio}</td>
                            <td>${curso.horarioFinal}</td>
                            <td>${curso.instructor}</td>
                            <td>${curso.nombreSalon}</td>
                            <td>
                                <a class="btn btn-warning"  href="${pageContext.request.contextPath}/ServletCursosController?accion=editar&idCurso=${curso.idCurso}">
                                    <i class="far fa-edit"></i> Editar</a>
                            </td>
                            <td>
                                <a class="btn btn-danger"  href="${pageContext.request.contextPath}/ServletCursosController?accion=eliminar&idCurso=${curso.idCurso}"><i class="fas fa-trash"></i>  Eliminar</a></td>
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