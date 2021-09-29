<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">




        <title>Editar Notas</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="card mt-5">
                            <div class="card-header bg-black text-light">
                                <h4 class="text-center">Editar Notas</h4>
                            </div>
                            <div class="card-body bg-dark">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletNotaController" class="was-validated">

                                    <div class="mb-3">
                                        <label for="nombreActividad" class="form-label text-white">Nombre de la actividad</label>
                                        <input type="text" class="form-control" name="nombreActividad" id="nombreActividad"  value="${nota.nombreActividad}"required>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label text-white" for="notaActividad">Nota de actividad</label>
                                        <input type="number" class="form-control" name="notaActividad" id="notaActividad" step="1" value="${nota.notaActividad}" min="0" max="100" required>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label text-white" for="fechaEntrega">Fecha de entrega</label>
                                        <input class="form-control" type="date" id="fechaEntrega" name="fechaEntrega" value="${nota.fechaEntrega}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="idAsignacion" class="form-label text-white">Asignación</label>
                                        <select class="form-select" name="idAsignacion" id="idAsignacion" required>
                                            <option value="${nota.idAsignacion}">ID: ${nota.idAsignacion} </option>
                                            <c:forEach var="asignacionAlumno" items="${listadoAsginacion}">
                                                <option value="${asignacionAlumno.idAsignacion}">ID: ${asignacionAlumno.idAsignacion} |Alumno: ${asignacionAlumno.nombres} ${asignacionAlumno.apellidos} |Curso: ${asignacionAlumno.descripcion} |Fecha asignación: ${asignacionAlumno.fecha_asignacion}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <input type="hidden" name="idNota" value="${nota.idNota}">
                                    <input type="hidden" name="accion" value="actualizar">


                                    <a class="btn btn-secondary"
                                       href="${pageContext.request.contextPath}/ServletNotaController?accion=listar"
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
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

        <script>
            flatpickr("input[type=date]", {});
        </script>

    </body>
</html>
