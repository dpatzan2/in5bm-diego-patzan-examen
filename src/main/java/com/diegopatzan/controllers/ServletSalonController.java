package com.diegopatzan.controllers;

import com.diegopatzan.models.domain.Salon;
import com.diegopatzan.models.dao.SalonDaoImpl;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author @date 2/09/2021
 * @time 06:45:22 PM
 */
@WebServlet("/ServletSalonController")
public class ServletSalonController extends HttpServlet {

    private static final String JSP_LISTAR = "salon/salon.jsp";
    private static final String JSP_EDITAR = "salon/editar-salon.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarSalon(request, response);
                    break;
                case "editar":
                     editarSalon(request, response);
                    break;
                case "eliminar":
                    eliminarSalon(request, response);
                    break;
            }
        }

    }

    private void listarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Salon> listaSalon = new SalonDaoImpl().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoSalon", listaSalon);
        response.sendRedirect(JSP_LISTAR);
    }

    private void eliminarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int salonId = Integer.parseInt(request.getParameter("salonId"));
        Salon salones = new Salon(salonId);
        int registrosEliminados = new SalonDaoImpl().eliminar(salones);
        System.out.println("Cantidad de registros eliminados:" + registrosEliminados);
        listarSalon(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        System.out.println("estoy dentro de doPost");
        System.out.println("accion: " + accion);
        if (accion != null) {

            switch (accion) {
                case "insertar":
                    insertarSalon(request, response);
                    break;
                case "actualizar":
                    actualizarSalon(request, response);
                    break;
            }

        }
    }

    private void insertarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insertar salon");

        String capacidadStr = request.getParameter("capacidad");
        String apellido = request.getParameter("descripcion");
        String nombre = request.getParameter("nombre");
        int capacidad = 0;

        if ((capacidadStr != null) && (!capacidadStr.equals(""))) {
            capacidad = Integer.parseInt(request.getParameter("capacidad"));
        }

        Salon salon = new Salon(capacidad, apellido, nombre);
        System.out.println(salon);

        int registrosInsertados = new SalonDaoImpl().insertar(salon);
        System.out.println("Registros insertados: " + registrosInsertados);
        listarSalon(request, response);
    }

    private void actualizarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("actulizar salon");

        int salonId = Integer.parseInt(request.getParameter("salonId"));
        String capacidadStr = request.getParameter("capacidad");
        String apellido = request.getParameter("descripcion");
        String nombre = request.getParameter("nombre");
        int capacidad = 0;

        if ((capacidadStr != null) && (!capacidadStr.equals(""))) {
            capacidad = Integer.parseInt(request.getParameter("capacidad"));
        }

        Salon salon = new Salon(salonId, capacidad, apellido, nombre);
        System.out.println(salon);

        int registrosInsertados = new SalonDaoImpl().actualizar(salon);
        listarSalon(request, response);
    }

    private void editarSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         System.out.println("editar estudiante");

        int idSalon = Integer.parseInt(request.getParameter("salonId"));
        
        Salon salon = new SalonDaoImpl().encontrar(new Salon(idSalon));
        
        request.setAttribute("salon", salon);
        
        System.out.println(salon);
        
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
    }
}
