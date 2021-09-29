/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.dao;

import com.diegopatzan.db.Conexion;
import com.diegopatzan.models.domain.Horario;
import com.diegopatzan.models.idao.IHorarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristian Noe Cumez Morales
 * Codigo técnico:IN5BM
 * @date 9/1/2021
 * @time 07:55:02
 */

public class HorarioDaoImpl implements IHorarioDao {
    
    private static final String SQL_SELECT = "Select horario_id, horario_inicio,horario_final from horario";
    private static final String SQL_DELETE=  "DELETE FROM horario WHERE horario_id = ?";
    private static final String SQL_INSERT = "INSERT INTO horario (horario_inicio, horario_final) VALUES (?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT horario_id,horario_inicio,horario_final FROM horario WHERE horario_id = ?";
    private static final String SQL_UPDATE = "UPDATE horario SET horario_inicio = ?,horario_final = ? WHERE horario_id = ?";
    
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private Horario horario = null;
    private List<Horario> listaHorario = new ArrayList<>();
     @Override
    public List <Horario> listar(){
        try{
            conn = Conexion.getConnection();
            psmt = conn.prepareStatement(SQL_SELECT);
            rs = psmt.executeQuery();
        
            while(rs.next()){
                int idHorario = rs.getInt("horario_id");
                Time horarioInicio = rs.getTime("horario_inicio");
                Time horarioFinal = rs.getTime("horario_final");
                horario = new Horario(idHorario, horarioInicio,horarioFinal);
                listaHorario.add(horario);
          
        }
       
    
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(psmt);
            Conexion.close(conn);
                
        }
        
        return listaHorario;
       
    }
    
    @Override
    public Horario encontrar(Horario horario) {
        
        try{
            conn = Conexion.getConnection();
            psmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            psmt.setInt(1, horario.getIdHorario());
            rs = psmt.executeQuery();
        
            while(rs.next()){
                Time horarioInicio = rs.getTime("horario_inicio");
                Time horarioFinal = rs.getTime("horario_final");            
            
                horario.setHorarioInicio(horarioInicio);
                horario.setHorarioFinal(horarioFinal);
            
            }
            
        
        
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(psmt);
            Conexion.close(conn);
        }
        
        return horario;
        
        
    }
       
    
    
  
    /*
    preparedStatement.setTime (1, new Time(date.getTime()));
    preparedStatement.executeUpdate ();
    */
    @Override
    public int insertar(Horario horario) {
        int rows = 0;
        try{
        
            conn = Conexion.getConnection();
            psmt = conn.prepareStatement(SQL_INSERT);
            psmt.setTime(1, new Time(horario.getDateIncio().getTime()));
            psmt.setTime(2, new Time(horario.getDateFinal().getTime()));
            System.out.println(psmt.toString());
            
            rows = psmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexion.close(psmt);
            Conexion.close(conn);
        }    
        
        return rows;
    }

    @Override
    public int actualizar(Horario horario) {
       int rows = 0;
        try{
        
            conn = Conexion.getConnection();
            psmt = conn.prepareStatement(SQL_UPDATE);
            psmt.setTime(1, horario.getHorarioInicio());
            psmt.setTime(2, horario.getHorarioFinal());
            psmt.setInt(3,horario.getIdHorario());
            System.out.println(psmt.toString());
            
            rows = psmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexion.close(psmt);
            Conexion.close(conn);
        }    
        
        return rows;
    }

    @Override
    public int eliminar(Horario horario) {
              int rows = 0;
        try{
            conn = Conexion.getConnection();
            psmt = conn.prepareStatement(SQL_DELETE);
            psmt.setInt(1,horario.getIdHorario());
            rows = psmt.executeUpdate();    
        
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(psmt);
            Conexion.close(conn);
        }
        return rows;   
    }
}
    
    
    

