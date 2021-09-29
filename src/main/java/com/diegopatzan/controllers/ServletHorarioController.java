
package com.diegopatzan.controllers;


import com.diegopatzan.models.dao.HorarioDaoImpl;
import com.diegopatzan.models.domain.Horario;
import java.io.IOException;
import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author Cristian Noe Cumez Morales
 * Codigo técnico:IN5BM
 * @date 9/1/2021
 * @time 07:55:02
 */

@WebServlet("/ServletHorarioController")
public class ServletHorarioController extends HttpServlet {
    private static final String JSP_LISTAR = "horario/horario.jsp";
    private static final String JSP_EDITAR = "horario/editar-horario.jsp";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String accion = request.getParameter("accion");
            if(accion != null){
                switch(accion){
                    case "insertar":
                    {
                       
                        agregarHorarios(request, response);
                        break;
                    }
                    
                    case "actualizar":
                    {
                        actualizarHorario(request, response);
                        break;
                    
                    
                    }
                
                
                
                }
            
            
            } 
  
    }
    
        private void actualizarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException {
            System.out.println("Estoy en modificar");
            int idHorario = Integer.parseInt(request.getParameter("idHorario"));
            String horarioInicioStr = request.getParameter("horarioInicio");
            String horarioFinalStr = request.getParameter("horarioFinal");
            
            Time horarioInicio=Time.valueOf(horarioInicioStr+":00");
            Time horarioFinal= Time.valueOf(horarioFinalStr+":00");

            Horario horario = new Horario(idHorario,horarioInicio,horarioFinal);
            
            int registrosHorarios = new HorarioDaoImpl().actualizar(horario);
            System.out.println(registrosHorarios);
            listarHorarios(request,response);
            
        }

    
        private void agregarHorarios(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Estoy dentro de DOPost");
        
        
        
        String horarioInicio = request.getParameter("horarioInicio");
        String horarioFinal = request.getParameter("horarioFinal");
        
    
        
        
           
            Date dateInicio = null;
            Date dateFinal = null;

            try {
                dateInicio = new SimpleDateFormat("HH:mm").parse(horarioInicio);
                dateFinal = new SimpleDateFormat("HH:mm").parse(horarioFinal);
                
            } catch (ParseException e) {
                request.setAttribute("time_error", "Please enter time in format HH:mm");
            }
            
            dateInicio = new java.sql.Time(dateInicio.getTime());
        
     
        
       Horario horario =  new Horario(dateInicio,dateFinal);
        
      
        
        
        int registroInsertados = new HorarioDaoImpl().insertar(horario);
       // System.out.println("Cantidad" + registroInsertados);
        //Aqui lleva trows allow exception
        listarHorarios(request,response);
        
       
    }
    
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String accion = request.getParameter("accion");
            if(accion != null){
                switch(accion){
                    case "listar":
                        listarHorarios(request,response);
                        break;
                    case "agregar":
                    {
                       
                    }
                                            
                    case "editar":
                    {
                      
                        editarHorario(request,response);
                        
                        
                    }
                        break;

                        
                    case "eliminar":
                        eliminarHorarios(request,response);
                }           
            }
        
    }
    
    
 
    private void listarHorarios(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Horario> listaHorarios = new HorarioDaoImpl().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoHorarios", listaHorarios);
        response.sendRedirect(JSP_LISTAR);
        
        
    }
    
    private void eliminarHorarios(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        Horario horario = new Horario(idHorario);
       
        int registrosHorarios = new HorarioDaoImpl().eliminar(horario);
        
          if (registrosHorarios== 0) {
            System.out.println("Este registro pertenece a uno de asignacion, porfavor elimine el otro registro");
        } else {
            System.out.println("Cantidad de registros eliminados: " + registrosHorarios);
        }
        System.out.println(registrosHorarios);
        listarHorarios(request,response);
        
    
        
        
        
    }

    private void editarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //aqui es donde vamos a modificar todos los datos asignados
       int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        
        Horario horario = new HorarioDaoImpl().encontrar(new Horario(idHorario));
        request.setAttribute("horario", horario);
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
        
    }

   


}
