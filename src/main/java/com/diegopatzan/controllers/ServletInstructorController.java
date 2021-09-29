
package com.diegopatzan.controllers;

import com.diegopatzan.models.dao.InstructorDaoImpl;
import com.diegopatzan.models.domain.Instructor;
import com.mysql.cj.util.EscapeTokenizer;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

/**
 *
 * @author Axel Javier Guadalupe Alvarez Felipe
 */
@WebServlet("/ServletInstructorController")
public class ServletInstructorController extends HttpServlet {

    private static final String JSP_LISTAR = "instructor/instructor.jsp";
    private static final String JSP_EDITAR = "instructor/editar-instructor.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");

        System.out.println("\nMetodo Post");

        String accion = request.getParameter("accion");

        System.out.println("accion: " + accion);

        if (accion != null) {
            switch (accion) {

                case "insertar":
                    insertarInstructor(request, response);
                    break;

                case "actualizar":
                    actualizarInstructor(request, response);
                    break;

            }
        }
    }
    
    private void actualizarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int idInstructor = Integer.parseInt(request.getParameter("idInstructor"));
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        
        Instructor instructor = new Instructor(idInstructor, apellidos, nombres, direccion, telefono);
        System.out.println(instructor);
        
        int registrosModificados = new InstructorDaoImpl().actualizar(instructor);
        
        listarInstructores(request, response);
    }

    private void insertarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("\ninsertarInstructor");
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        Instructor instructor = new Instructor(apellidos, nombres, direccion, telefono);
        System.out.println(instructor);

        int registrosInsertados = new InstructorDaoImpl().insertar(instructor);
        System.out.println("Registros insertados: " + registrosInsertados);
        listarInstructores(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        System.out.println("\n\ndoGet");
        System.out.println("accion: " + accion);

        if (accion != null) {

            switch (accion) {
                case "listar":
                    listarInstructores(request, response);
                    break;

                case "editar":
                    editarInstructores(request, response);
                    break;

                case "eliminar":
                    eliminarInstructores(request, response);
                    break;

            }
        }

    }

    private void editarInstructores(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idInstructor = Integer.parseInt(request.getParameter("idInstructor"));
        Instructor instructor = new InstructorDaoImpl().encontrar(new Instructor(idInstructor));
        request.setAttribute("instructor", instructor);
        System.out.println(instructor);
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
    }

    private void eliminarInstructores(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idInstructor = Integer.parseInt(request.getParameter("idInstructor"));
        Instructor instructor = new Instructor(idInstructor);
        int registrosEliminados = new InstructorDaoImpl().eliminar(instructor);
        System.out.println("Registros eliminados: " + registrosEliminados);
        listarInstructores(request, response);
    }

    private void listarInstructores(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Instructor> listaInstructor = new InstructorDaoImpl().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoInstructor", listaInstructor);
        response.sendRedirect(JSP_LISTAR);
    }

}