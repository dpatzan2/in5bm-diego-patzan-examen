/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.controllers;

import com.diegopatzan.models.dao.AlumnoDaoImpl;
import com.diegopatzan.models.domain.Alumno;
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
 * @author Ricardo Paz <rpaz-2017457@kinal.edu.gt>
 * @date 30-ago-2021
 * @time 22:25:45
 */
@WebServlet("/ServletAlumnoController")
public class ServletAlumnoController extends HttpServlet {

    private static final String JSP_LISTAR = "alumno/alumno.jsp";
    private static final String JSP_EDITAR = "alumno/editar-alumno.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarAlumno(request, response);
                    break;
                case "editar":
                    editarAlumno(request, response);
                    break;
                case "eliminar":
                    eliminarAlumno(request, response);
                    break;
            }
        }
    }

    private void listarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Alumno> listaAlumno = new AlumnoDaoImpl().listar();
        System.out.println(listaAlumno);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoAlumno", listaAlumno);
        response.sendRedirect(JSP_LISTAR);
    }

    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String carne = request.getParameter("carne");

        Alumno alumno = new Alumno(carne);
        int alumnoEliminado = new AlumnoDaoImpl().eliminar(alumno);
        System.out.println("CANTIDAD DE ALUMNOS ELIMINADOS: " + alumnoEliminado);
        listarAlumno(request, response);
    }

    private void insertarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insertarAlumno");

        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        String email = request.getParameter("email");

        //OBJETO ALUMNO
        Alumno alumno = new Alumno(apellidos, nombres, email);
        System.out.println(alumno);

        //INSERTAR EN DB
        int alumnoInsertado = new AlumnoDaoImpl().insertar(alumno);
        System.out.println("Alumno Insertado:" + alumnoInsertado);

        listarAlumno(request, response);
    }

    private void editarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String carne = request.getParameter("carne");

        Alumno alumno = new AlumnoDaoImpl().encontrar(new Alumno(carne));
        request.setAttribute("alumno", alumno);
        System.out.println(alumno);

        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
    }

    private void actualizarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insertarAlumno");

        String carne = request.getParameter("carne");
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        String email = request.getParameter("email");

        //OBJETO ALUMNO
        Alumno alumno = new Alumno(carne, apellidos, nombres, email);
        System.out.println(alumno);

        //ACTUALIZAR EN DB
        int alumnoModificado = new AlumnoDaoImpl().actualizar(alumno);
        System.out.println("Alumno Modificado:" + alumnoModificado);

        listarAlumno(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        System.out.println("Estoy En El Metodod POST");

        String accion = request.getParameter("accion");
        System.out.println("accion: " + accion);

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAlumno(request, response);
                    break;
                case "actualizar":
                    actualizarAlumno(request, response);
                    break;
            }
        }
    }
}
