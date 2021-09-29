<%-- 
    Document   : editar-cursos
    Created on : 15/09/2021, 08:52:59 PM
    Author     : doazm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>Editar cursos</title>
    </head>

    <body>
        <!cabecera>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
    <main>
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-12">
                    <div class="card mt-5">
                        <div class="card-header bg-black text-light">
                            <h4 class="text-center">Editar Curso</h4>
                        </div>
                        <div class="card-body bg-dark text-light">
                            <form method="POST" action="${pageContext.request.contextPath}/ServletCursosController" class="was-validated">
                                <div class="mb-3">
                                    <label class="form-label" for="ciclo">Ciclo</label>
                                    <input type="number" class="form-control" name="ciclo" id="ciclo" step="1"  min="2021" max="2025" required value="${cursos.ciclo}">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="cupo-maximo">Cupo Maximo</label>
                                    <input type="number" class="form-control" name="cupo-maximo" id="cupo-maximo" step="1" min="10" max="50" required value="${cursos.cupoMaximo}">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="cupo-minimo">Cupo Minimo</label>
                                    <input type="number" class="form-control" name="cupo-minimo" id="cupo-minimo" step="1" min="5" max="10" required value="${cursos.cupoMinimo}">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="descripcion">Descripción</label>
                                    <input type="text" class="form-control" name="descripcion" id="descripcion" value="${cursos.descripcion}" required >
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="carrera">Carrera</label>
                                    <select class="form-select" aria-label="Default select example" name="carrera" id="carrera" required>
                                        <option value="${cursos.codigoCarrera}">${cursos.carrera}</option>
                                        <c:forEach var="carrera" items="${listadoCarrera}">
                                            <option  value="${carrera.codigo_carrera}">${carrera.nombre} </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="horario">Horario</label>
                                    <select class="form-select" aria-label="Default select example" name="horario" id="horario" require>
                                        <option value="${cursos.idHorario}">${cursos.horarioInicio} ${cursos.horarioFinal} </option>
                                        <c:forEach var="horario" items="${listadoHorario}">
                                            <option value="${horario.idHorario}">${horario.horarioInicio} a ${horario.horarioFinal}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="instructor">Instructor</label>
                                    <select class="form-select" aria-label="Default select example" name="instructor" id="instructor" value="${instructor.idInstructor}">
                                        <option value="${cursos.idInstructor}">${cursos.instructor} </option>
                                        <c:forEach var="instructor" items="${listadoInstructor}">
                                            <option value="${instructor.idInstructor}">${instructor.nombres} ${instructor.apellidos}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="salon">Salon</label>
                                    <select class="form-select" aria-label="Default select example" name="salon" id="salon" required value="${salon.salonId}">
                                        <option value="${cursos.idSalon}">${cursos.nombreSalon} | ${cursos.carreraDescripcion} </option>
                                        <c:forEach var="salon" items="${listadoSalon}">
                                            <option value="${salon.salonId}">${salon.nombreSalon} | ${salon.descripcion}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <input type="hidden" name="idCurso" value="${cursos.idCurso}">       
                                <input type="hidden" name="accion" value="actualizar"> 

                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletCursosController?accion=listar">Cancelar</a>
                                <button type="submit" class="btn btn-success">Guardar</button>
                            </form>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!--Javascript-->
    <script src="./assets/js/jquery-3.6.0.js"></script>
    <script src="./assets/js/bootstrap.bundle.js"></script>

</body>
</html>
