<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:formatDate pattern = "yyyy-MM-dd hh:mm:ss" 
                value = "${now}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/bootstrap.css"> 
        <link rel="icon" type="image/png" href="./assets/images/favicon.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"rel="stylesheet">
        <script src="https://kit.fontawesome.com/bc893c1d65.js" crossorigin="anonymous"></script>




        <title>Editar Asignaciones</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="card mt-5">
                            <div class="card-header bg-black text-light">
                                <h4 class="text-center">Editar Asignación</h4>
                            </div>
                            <div class="card-body bg-dark">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletAsignacionAlumnoController" class="was-validated">

                                    <div class="mb-3">
                                        <label for="id" class="form-label text-light">Id asignación</label>
                                        <input type="text" class="form-control " name="idAsignacion" id="id" value="${asignacionAlumno.idAsignacion}" readonly>
                                    </div>
                                    <div class="mb-3">
                                        <label for="carne" class="form-label text-light">Carné del alumno</label>
                                        <select class="form-select"   name="carne" id="mibuscador carne" data-placeholder="- Seleccione un alumno -"  required>
                                            <option value="${asignacionAlumno.carne}">Carné: ${asignacionAlumno.carne} | Alumno: ${asignacionAlumno.nombres} ${asignacionAlumno.apellidos} </option>
                                            <c:forEach var="alumno" items="${listadoAlumno}">
                                                <option value="${alumno.carne}">Carné: ${alumno.carne} | Alumno: ${alumno.nombres} ${alumno.apellidos}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="curso" class="form-label text-light">Curso</label>
                                        <select class="form-select" name="idCurso" id="curso" required>
                                            <option selected value="${asignacionAlumno.idCurso}">ID: ${asignacionAlumno.idCurso} | Curso: ${asignacionAlumno.descripcion}</option>
                                            <c:forEach var="curso" items="${listadoCursos}">
                                                <option value="${curso.idCurso}">ID: ${curso.idCurso} | ${curso.descripcion}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div >
                                        <label for="fecha_asignacion" class="form-label text-light">Fecha Asignación</label>
                                        <input type="datetime-local" class="form-control" id="fecha_asignacion" name="fecha_asignacion" value="${asignacionAlumno.fecha_asignacion}" fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss">
                                    </div>
                                    <input type="hidden" name="idAsignacion" value="${asignacionAlumno.idAsignacion}">
                                    <input type="hidden" name="accion" value="actualizar">


                                     <a class="btn btn-secondary"
                                         href="${pageContext.request.contextPath}/ServletAsignacionAlumnoController?accion=listar"
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
