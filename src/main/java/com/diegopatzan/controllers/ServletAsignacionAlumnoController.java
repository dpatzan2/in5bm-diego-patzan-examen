/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.controllers;

import com.diegopatzan.models.dao.AsignacionAlumnoDaoImpl;
import com.diegopatzan.models.dao.CursoDaoImpl;
import com.diegopatzan.models.domain.AsignacionAlumno;
import com.diegopatzan.models.domain.Cursos;
import com.diegopatzan.controllers.ServletCursosController;
import com.diegopatzan.models.dao.AlumnoDaoImpl;
import com.diegopatzan.models.domain.Alumno;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

/**
 *
 * @author Windows 10
 */
@WebServlet("/ServletAsignacionAlumnoController")
public class ServletAsignacionAlumnoController extends HttpServlet {

    private static final String JSP_LISTAR = "asignacion-alumno/asignacion-alumno.jsp";
    private static final String JSP_EDITAR = "asignacion-alumno/editar-asignacion-alumno.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarAsignacionAlumno(request, response);
                    //listarCursos(request, response);
                    break;
                case "editar":
                    editarAsignacionAlumno(request, response);
                    break;
                case "eliminar":
                    eliminarAsignacionAlumno(request, response);
                    break;
            }
        }

    }

    private void editarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idAsignacion = request.getParameter("idAsignacion");

        AsignacionAlumno asignacionAlumno = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(idAsignacion));

        request.setAttribute("asignacionAlumno", asignacionAlumno);

        request.getRequestDispatcher("asignacion-alumno/editar-asignacion-alumno.jsp").forward(request, response);
    }

    private List<Cursos> listarCursos() {
        List<Cursos> listaCursos = new CursoDaoImpl().listar();
        return listaCursos;
    }

    private List<Alumno> listarAlumno() {
        List<Alumno> listaAlumno = new AlumnoDaoImpl().listar();
        return listaAlumno;
    }

    private void listarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AsignacionAlumno> listaAsignacionAlumno = new AsignacionAlumnoDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoAsignacionAlumno", listaAsignacionAlumno);
        sesion.setAttribute("listadoCursos", listarCursos());
        sesion.setAttribute("listadoAlumno", listarAlumno());
        response.sendRedirect(JSP_LISTAR);
    }

    private void eliminarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idAsignacion = request.getParameter("idAsignacion");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(idAsignacion);
        int registrosEliminados = new AsignacionAlumnoDaoImpl().eliminar(asignacionAlumno);
        listarAsignacionAlumno(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAsignacion(request, response);
                    break;
                case "actualizar":
                    actualizarAsignacionAlumno(request, response);
                    break;
            }
        }
    }

    private void actualizarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idAsignacion = request.getParameter("idAsignacion");
        String carne = request.getParameter("carne");
        String idCurso2 = request.getParameter("idCurso");
        int idCurso = 0;
        if (idCurso2.equals("Curso")) {
            idCurso = 1;
        } else {
            idCurso = Integer.parseInt(request.getParameter("idCurso"));
        }

        /*LocalDateTime ActualesFechaHora = LocalDateTime.now();

        Timestamp fecha_asignacion = Timestamp.valueOf(ActualesFechaHora);*/
        String fecha_hora_str = request.getParameter("fecha_asignacion");
        Timestamp fecha_asignacion;
        if (fecha_hora_str.equals("")) {
            LocalDateTime ActualesFechaHora = LocalDateTime.now();

         fecha_asignacion = Timestamp.valueOf(ActualesFechaHora);
        }else{
         fecha_asignacion = Timestamp.valueOf(fecha_hora_str.replace("T"," ") + ":00.00");
        }
        
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(idAsignacion, carne, idCurso, fecha_asignacion);
        
        int registrosModificados = new AsignacionAlumnoDaoImpl().actualizar(asignacionAlumno);
        listarAsignacionAlumno(request, response);
    }

    private void insertarAsignacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idAsignacion = UUID.randomUUID().toString().toUpperCase().substring(0, 5);
        String carne = request.getParameter("carne");
        String idCurso2 = request.getParameter("idCurso");
        int idCurso = 0;
        if (idCurso2.equals("Curso")) {
            idCurso = 1;
        } else {
            idCurso = Integer.parseInt(request.getParameter("idCurso"));
        }

        LocalDateTime ActualesFechaHora = LocalDateTime.now();

        Timestamp fecha_asignacion = Timestamp.valueOf(ActualesFechaHora);

        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(idAsignacion, carne, idCurso, fecha_asignacion);

        int registrosInsertados = new AsignacionAlumnoDaoImpl().insertar(asignacionAlumno);
        listarAsignacionAlumno(request, response);
    }
}
