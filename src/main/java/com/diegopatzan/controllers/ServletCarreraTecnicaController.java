package com.diegopatzan.controllers;

import com.diegopatzan.models.dao.CarreraTecnicaDaoImpl;
import com.diegopatzan.models.domain.CarreraTecnica;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Gabriel Enrique Hurtarte Garcia Codigo técnico:IN5BM
 * @date 1/09/2021
 * @time 10:32:05 PM
 */
@WebServlet("/ServletCarreraTecnicaController")
public class ServletCarreraTecnicaController extends HttpServlet {

    private static final String JSP_LISTAR = "carrera-tecnica/carrera-tecnica.jsp";
    private static final String JSP_EDITAR = "carrera-tecnica/editar-carrera-tecnica.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarCarrera(request, response);
                    break;
                case "editar":
                    editarCarrera(request, response);
                    break;
                case "eliminar":
                    eliminarCarrera(request, response);
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
                    insertarCarrera(request, response);
                    break;
                case "actualizar":
                    actualizarCarrera(request, response);
                    break;
            }

        }
    }

    private void insertarCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insertar carrera");

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");

        CarreraTecnica carreraTecnica = new CarreraTecnica(codigo, nombre);

        int registrosInsertados = new CarreraTecnicaDaoImpl().insertar(carreraTecnica);
        System.out.println("Registros insertados: " + registrosInsertados);
        listarCarrera(request, response);
    }

    private void listarCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<CarreraTecnica> listaCarrera = new CarreraTecnicaDaoImpl().listar();
        System.out.println(listaCarrera);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCarrera", listaCarrera);
        response.sendRedirect(JSP_LISTAR);
    }

    private void eliminarCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigo_carrera = request.getParameter("codigo_carrera");

        CarreraTecnica carreraTecnica = new CarreraTecnica(codigo_carrera);
        int carreraEliminada = new CarreraTecnicaDaoImpl().eliminar(carreraTecnica);
        System.out.println("CANTIDAD DE CARRERAS ELIMINADOS: " + carreraEliminada);
        listarCarrera(request, response);
    }

    private void editarCarrera(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("editar carrera");

        String codigo = request.getParameter("codigo_carrera");

        CarreraTecnica carrera = new CarreraTecnicaDaoImpl().encontrar(new CarreraTecnica(codigo));

        request.setAttribute("carrera", carrera);

        System.out.println(carrera);

        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
    }

    private void actualizarCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("editar carrera");

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");

        CarreraTecnica carreraTecnica = new CarreraTecnica(codigo, nombre);
        int registrosInsertados = new CarreraTecnicaDaoImpl().actualizar(carreraTecnica);
        System.out.println("Registros insertados: " + registrosInsertados);
        listarCarrera(request, response);
    }
}
