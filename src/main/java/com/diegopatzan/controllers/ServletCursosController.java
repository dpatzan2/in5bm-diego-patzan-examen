/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.controllers;

import com.diegopatzan.models.dao.CarreraTecnicaDaoImpl;
import com.diegopatzan.models.dao.CursoDaoImpl;
import com.diegopatzan.models.dao.HorarioDaoImpl;
import com.diegopatzan.models.dao.InstructorDaoImpl;
import com.diegopatzan.models.dao.SalonDaoImpl;
import com.diegopatzan.models.domain.CarreraTecnica;
import com.diegopatzan.models.domain.Cursos;
import com.diegopatzan.models.domain.Horario;
import com.diegopatzan.models.domain.Instructor;
import com.diegopatzan.models.domain.Salon;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

/**
 *
 * @author Marcelo Javier Diaz Pineda
 * @date 30/08/2021
 * @time 05:45:55 PM
 */
@WebServlet("/ServletCursosController")
public class ServletCursosController extends HttpServlet {

    private static final String JSP_LISTAR = "cursos/cursos.jsp";
    private static final String JSP_EDITAR="cursos/editar-cursos.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarCursos(request, response);
                    break;
                case "editar":
                    editarCursos(request,response);
                    break;
                case "eliminar":
                    eliminarCursos(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        System.out.println("estoy dentro de doPost");
        System.out.println("accion: " + accion);
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCurso(request, response);
                    break;
                case "actualizar":
                    actualizarCurso(request, response);
                    break;
            }

        }
    }
    
    private void insertarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insertar curso");

        String cicloStr = request.getParameter("ciclo");
        String cupoMaximoStr = request.getParameter("cupo-maximo");
        String cupoMinimoStr = request.getParameter("cupo-minimo");
        String descripcion = request.getParameter("descripcion");
        String carrera = request.getParameter("carrera");
        String horarioStr = request.getParameter("horario");
        String instructorStr = request.getParameter("instructor");
        String salonStr = request.getParameter("salon");
        int ciclo = 0;
        int cupoMaximo = 0;
        int cupoMinimo = 0;
        int horario = 0;
        int instructor = 0;
        int salon = 0;

        if ((cicloStr != null) && (!cicloStr.equals(""))) {
            ciclo = Integer.parseInt(request.getParameter("ciclo"));
        }
        if ((cupoMaximoStr != null) && (!cupoMaximoStr.equals(""))) {
            cupoMaximo = Integer.parseInt(request.getParameter("cupo-maximo"));
        }
        if ((cupoMinimoStr != null) && (!cupoMinimoStr.equals(""))) {
            cupoMinimo = Integer.parseInt(request.getParameter("cupo-minimo"));
        }
        if ((horarioStr != null) && (!horarioStr.equals(""))) {
            horario = Integer.parseInt(request.getParameter("horario"));
        }
        if ((instructorStr != null) && (!instructorStr.equals(""))) {
            instructor = Integer.parseInt(request.getParameter("instructor"));
        }
        if ((salonStr != null) && (!salonStr.equals(""))) {
            salon = Integer.parseInt(request.getParameter("salon"));
        }

        Cursos curso = new Cursos(ciclo, cupoMaximo, cupoMinimo, descripcion, carrera, horario, instructor, salon);
        System.out.println(curso);

        int registrosInsertados = new CursoDaoImpl().insertar(curso);
        System.out.println("Registros insertados: " + registrosInsertados);
        listarCursos(request, response);
    }

    private List<CarreraTecnica> listarCarrera() {
        List<CarreraTecnica> listaCarrera = new CarreraTecnicaDaoImpl().listar();
        return listaCarrera;
    }

    private List<Horario> listarHorarios() {
        List<Horario> listaHorario = new HorarioDaoImpl().listar();
        return listaHorario;
    }

    private List<Instructor> listarInstructores() {
        List<Instructor> listaInstructor = new InstructorDaoImpl().listar();
        return listaInstructor;
    }

    private List<Salon> listarSalones() {
        List<Salon> listaSalon = new SalonDaoImpl().listar();
        return listaSalon;
    }

    private void listarCursos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Cursos> listaCursos = new CursoDaoImpl().listar();
        System.out.println(listaCursos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCursos", listaCursos);
        sesion.setAttribute("listadoCarrera", listarCarrera());
        sesion.setAttribute("listadoHorario", listarHorarios());
        sesion.setAttribute("listadoInstructor", listarInstructores());
        sesion.setAttribute("listadoSalon", listarSalones());
        response.sendRedirect(JSP_LISTAR);
    }

    private void eliminarCursos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCursos = Integer.parseInt(request.getParameter("idCurso"));

        Cursos cursos = new Cursos(idCursos);

        int cursosEliminados = new CursoDaoImpl().eliminar(cursos);

        if (cursosEliminados == 0) {
            System.out.println("Este registro pertenece a uno de asignacion, porfavor elimine el otro registro");
        } else {
            System.out.println("Cantidad de registros eliminados: " + cursosEliminados);
        }

        listarCursos(request, response);
    }
    
    private void editarCursos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //Recuperar el id de cursos
        int idCursos = Integer.parseInt(request.getParameter("idCurso"));
        
        Cursos cursos = new CursoDaoImpl().encontrar(new Cursos(idCursos));
        
        request.setAttribute("cursos", cursos);
        
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
        
        System.out.println(cursos);
        
        
    }

    private void actualizarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insertar curso");
        String cicloStr = request.getParameter("ciclo");
        String cupoMaximoStr = request.getParameter("cupo-maximo");
        String cupoMinimoStr = request.getParameter("cupo-minimo");
        String descripcion = request.getParameter("descripcion");
        String carrera = request.getParameter("carrera");
        String horarioStr = request.getParameter("horario");
        String instructorStr = request.getParameter("instructor");
        String salonStr = request.getParameter("salon");
        String idCursoStr = request.getParameter("idCurso");
        int ciclo = 0;
        int cupoMaximo = 0;
        int cupoMinimo = 0;
        int horario = 0;
        int instructor = 0;
        int salon = 0;
        int idCurso=0;

        if ((cicloStr != null) && (!cicloStr.equals(""))) {
            ciclo = Integer.parseInt(request.getParameter("ciclo"));
        }
        if ((cupoMaximoStr != null) && (!cupoMaximoStr.equals(""))) {
            cupoMaximo = Integer.parseInt(request.getParameter("cupo-maximo"));
        }
        if ((cupoMinimoStr != null) && (!cupoMinimoStr.equals(""))) {
            cupoMinimo = Integer.parseInt(request.getParameter("cupo-minimo"));
        }
        if ((horarioStr != null) && (!horarioStr.equals(""))) {
            horario = Integer.parseInt(request.getParameter("horario"));
        }
        if ((instructorStr != null) && (!instructorStr.equals(""))) {
            instructor = Integer.parseInt(request.getParameter("instructor"));
        }
        if ((salonStr != null) && (!salonStr.equals(""))) {
            salon = Integer.parseInt(request.getParameter("salon"));
        }
        
        if((idCursoStr != null) && (!idCursoStr.equals(""))) {
            idCurso = Integer.parseInt(request.getParameter("idCurso"));
        }

         Cursos curso = new Cursos(idCurso, ciclo, cupoMaximo, cupoMinimo, descripcion, carrera, horario, instructor, salon);
        System.out.println(curso);
        
        //Se modifica el objeto en la base de datos 
        int registrosModificados  = new  CursoDaoImpl().actualizar(curso);
        
        listarCursos(request, response);
    }

}
