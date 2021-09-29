/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diegopatzan.models.dao;
import com.diegopatzan.db.Conexion;
import com.diegopatzan.models.domain.Alumno;
import com.diegopatzan.models.idao.IAlumnoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ricardo Paz <rpaz-2017457@kinal.edu.gt>
   @date 30-ago-2021
   @time 21:24:49
 */
public class AlumnoDaoImpl implements IAlumnoDao{

    private static final String SQL_SELECT = "SELECT carne, apellidos, nombres, email FROM alumno";
    private static final String SQL_DELETE = "DELETE FROM alumno WHERE carne = ?";
    private static final String SQL_INSERT = "INSERT INTO alumno (apellidos, nombres, email) VALUES (? ,? ,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT carne, apellidos, nombres, email FROM alumno WHERE carne = ?";
    private static final String SQL_UPDATE = "UPDATE alumno SET apellidos = ?, nombres = ?, email = ? WHERE carne = ?";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null; 
    private Alumno alumno = null;
    List<Alumno> listaAlumno = new ArrayList<>();
    
    @Override
    public List<Alumno> listar() {
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                String carne = rs.getString("carne");
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");
                String email = rs.getString("email");
                
                alumno = new Alumno(carne,apellidos,nombres,email);
                listaAlumno.add(alumno);
            }
        }catch(SQLException e){
            System.out.println("Un registro de Curso depende de este, elimine primero el registro en curso");
        }finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        
        return listaAlumno;
    }

    @Override
    public Alumno encontrar(Alumno alumno) {
        
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setString(1, alumno.getCarne());
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");
                String email = rs.getString("email");
                
                alumno.setApellidos(apellidos);
                alumno.setNombres(nombres);
                alumno.setEmail(email);
            }
        } catch (SQLException e){
            e.printStackTrace(System.out);
        } catch (Exception e){
            e.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        
        return alumno;
    }

    @Override
    public int insertar(Alumno alumno) {
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, alumno.getApellidos());
            pstmt.setString(2, alumno.getNombres());
            pstmt.setString(3, alumno.getEmail());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        
        return rows;
    }

    @Override
    public int actualizar(Alumno alumno) {
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, alumno.getApellidos());
            pstmt.setString(2, alumno.getNombres());
            pstmt.setString(3, alumno.getEmail());
            pstmt.setString(4, alumno.getCarne());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        
        return rows;
    }

    @Override
    public int eliminar(Alumno alumno) {
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, alumno.getCarne());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
}
