/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.controllers;

import com.diegopatzan.models.dao.AsignacionAlumnoDaoImpl;
import com.diegopatzan.models.dao.NotaDaoImpl;
import com.diegopatzan.models.dao.NotaDaoJPA;
import com.diegopatzan.models.domain.AsignacionAlumno;
import com.diegopatzan.models.domain.Nota;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego Fernando
 */
@WebServlet("/ServletNotaController")
public class ServletNotaController extends HttpServlet{
    
    private static final String JSP_LISTAR = "nota/nota.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch(accion){
                case "listar":
                    listarNota(request, response);
                    break;
                case "editar":
                    editarNota(request, response);
                    break;
                case "eliminar":
                    eliminarNota(request, response);
                    break;
            }
        }
    
    }
    
    private void editarNota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idNota = Integer.parseInt(request.getParameter("idNota"));
        
        Nota nota = new NotaDaoJPA().encontrar(new Nota(idNota));
        AsignacionAlumno asignacionAlumno = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(nota.getAsignacionAlumno().getIdAsignacion()));
        System.out.println(asignacionAlumno);
        request.setAttribute("nota", nota);
        request.setAttribute("asignacionId", asignacionAlumno.getIdAsignacion());
        request.getRequestDispatcher("nota/editar-nota.jsp").forward(request, response);
    }
    
    private List<AsignacionAlumno> listarAsignacionAlumno(){
        List<AsignacionAlumno> listaAsginacionAlumno = new AsignacionAlumnoDaoImpl().listar();
        return listaAsginacionAlumno;
    }
    
    private void listarNota(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //List<Nota> listaNota = new NotaDaoImpl().listar();
        List<Nota> listaNota = new NotaDaoJPA().listar();
        
        List<AsignacionAlumno> listaAsignacionAlumno = new AsignacionAlumnoDaoImpl().listar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoNota", listaNota);
        sesion.setAttribute("listadoAsginacion", listarAsignacionAlumno());
        sesion.setAttribute("promedioTotal", calcularPromedio());
        sesion.setAttribute("aprobados", aprobados());
        sesion.setAttribute("reprobados", reprobados());
        response.sendRedirect(JSP_LISTAR);
    }
    
    private double calcularPromedio(){
        
        double promedioTotal = 0;
        double sumaNotas = 0;
        List<Nota> listaNota = new NotaDaoJPA().listar();
        int estudiantes = listaNota.size();
        for(Nota nota : listaNota){
            sumaNotas = sumaNotas + nota.getNotaActividad();
            promedioTotal = sumaNotas / listaNota.size();
            promedioTotal = Math.round(promedioTotal *100d)/100d;
        }
        return promedioTotal;
    }
    
    private int aprobados(){
        int aprobados = 0;
        List<Nota> listaNota = new NotaDaoJPA().listar();
        for(Nota nota : listaNota){
            if (nota.getNotaActividad() >= 70) {
                aprobados++;
            }
        }
        return aprobados;
    }
    
    private int reprobados(){
        int reprobados = 0;
        List<Nota> listaNota = new NotaDaoJPA().listar();
        for(Nota nota: listaNota){
            if (nota.getNotaActividad() < 70) {
                reprobados++;
            }
        }
        return reprobados;
    }
    
    private void eliminarNota(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idNota = Integer.parseInt(request.getParameter("idNota"));
        
        Nota nota = new NotaDaoJPA().encontrar(new Nota(idNota));
        int registrosEliminados = new NotaDaoJPA().eliminar(nota);
        listarNota(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch(accion){
                case "insertar":
                   insertarNota(request, response);
                    break;
                case "actualizar":
                    actualizarNota(request, response);
                    break;
            }
        }
        
    }
    
   private void actualizarNota(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idNota = Integer.parseInt(request.getParameter("idNota"));
        String nombreActividad = request.getParameter("nombreActividad");
        String notaActividadStr = request.getParameter("notaActividad");
        
        int notaActividad = 0;
        
        if ((notaActividadStr != null) && (!notaActividadStr.equals(""))) {
            notaActividad = Integer.parseInt(request.getParameter("notaActividad"));
        }
        
        String fecha = request.getParameter("fechaEntrega");
        Date fechaEntrega;
        if (fecha.equals("")) {
            LocalDate ActualFecha = LocalDate.now();
            fechaEntrega = Date.valueOf(ActualFecha);
        }else{
            fechaEntrega = Date.valueOf(request.getParameter("fechaEntrega"));
        }
        String idAsignacion = request.getParameter("idAsignacion");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(idAsignacion));
        
        Nota nota = new Nota(idNota, nombreActividad, notaActividad, fechaEntrega, asignacionAlumno);
        int registrosModificados = new NotaDaoJPA().actualizar(nota);
        System.out.println("estoy por llamar al listar");
        listarNota(request, response);
        System.out.println("Ya llame al listar");
    }
    
    private void insertarNota(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nombreActividad = request.getParameter("nombreActividad");
        String notaActividadStr = request.getParameter("notaActividad");
        
        int notaActividad = 0;
        
        if ((notaActividadStr != null) && (!notaActividadStr.equals(""))) {
            notaActividad = Integer.parseInt(request.getParameter("notaActividad"));
        }
        
        String fecha = request.getParameter("fechaEntrega");
        Date fechaEntrega;
        if (fecha.equals("")) {
            LocalDate ActualFecha = LocalDate.now();
            fechaEntrega = Date.valueOf(ActualFecha);
        }else{
            fechaEntrega = Date.valueOf(request.getParameter("fechaEntrega"));
        }
        String idAsignacion = request.getParameter("idAsignacion");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(idAsignacion));
        
        Nota nota = new Nota(nombreActividad, notaActividad, fechaEntrega, asignacionAlumno);
        int registrosModificados = new NotaDaoJPA().insertar(nota);
        listarNota(request, response);
    }
    
}
