<%-- 
    Document   : horario-editar
    Created on : Sep 13, 2021, 12:45:23 PM
    Author     : 50245
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/barra-navegacion.css">
        <link rel="stylesheet" href="./assets/css/bootstrap.css"> 
        <link rel="stylesheet" href="./assets/css/clockpicker.css"> 
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="https://kit.fontawesome.com/bc893c1d65.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
         <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>

        <!--Esto es el formulario que llamamos al presionar el boton-->


        <!--Aqui es donde vamos a usar para poder agregar un estudiante 
        y poder hacer el formulario.-->
        <!-- Modal -->
        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="card mt-5">
                            <div class="card-header bg-black text-light">
                                <h4 class="text-center">Editar Horario</h4>
                            </div>
                            <div class="card-body bg-dark text-light">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletHorarioController" class="was-validated">

                                    <label for="horarioInicio" class="form-label text-light">Horario Inicio</label>
                                    <div class="input-group clockpicker" data-placement="top" data-align="top" data-autoclose="true" readonly="">
                                        <input type="time" class="form-control" name="horarioInicio" id="horarioInicio" required value="${horario.horarioInicio}">
                                        <span class="input-group-addon">
                                            <span  class="glyphicon glyphicon-time"></span>
                                        </span>
                                    </div>
                                    
                                    <label for="horarioInicio" class="form-label text-light">Horario Final</label>
                                    <div class="input-group clockpicker" data-placement="top" data-align="top" data-autoclose="true" readonly="">
                                       
                                        <input type="time" class="form-control" name="horarioFinal" id="horarioFinal" required value="${horario.horarioFinal}"
                                               text=" ">
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-time"></span>
                                        </span>
                                    </div>

                                    <input type="hidden"  name="idHorario" value="${horario.idHorario}">
                                    <input type="hidden" name="accion" value="actualizar">

                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href = '${pageContext.request.contextPath}/ServletHorarioController?accion=listar'">
                                        Cancelar
                                    </button>
                                    <button type="submit" class="btn btn-success">
                                        Guardar
                                    </button>
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
    <script src="./assets/js/clockpicker.js"></script>

    <script type="text/javascript">
        $('.clockpicker').clockpicker();
    </script>        
    </body>
</html>
