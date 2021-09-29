/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.dao;

import com.diegopatzan.db.Conexion;
import com.diegopatzan.models.domain.Nota;
import com.diegopatzan.models.idao.INotaDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Fernando
 */
public class NotaDaoImpl implements INotaDao {

    private static final String SQL_SELECT = "SELECT nota.id_nota, nota.nombre_actividad, nota.nota_actividad, nota.fecha_entrega, nota.asignacion_id\n"
            + "FROM nota\n";
    
    private static final String SQL_DELETE = "DELETE FROM nota WHERE id_nota = ?";
    
    private static final String SQL_INSERT = "INSERT INTO nota(nombre_actividad, nota_actividad, fecha_entrega, asignacion_id) VALUES(?, ?, ?, ?)";
    private static final String SQL_SELECT_BY_ID = "SELECT nota.id_nota, nota.nombre_actividad, nota.nota_actividad, nota.fecha_entrega, nota.asignacion_id, alumno.carne, alumno.nombres, alumno.apellidos, curso.descripcion, asignacion_alumno.fecha_asignacion\n" +
"FROM nota\n" +
"INNER JOIN asignacion_alumno ON asignacion_alumno.asignacion_id = nota.asignacion_id\n" +
"INNER JOIN alumno ON alumno.carne = asignacion_alumno.carne\n" +
"INNER JOIN curso ON curso.curso_id = asignacion_alumno.curso_id WHERE id_nota = ?";
    
    private static final String SQL_UPDATE = "UPDATE nota SET nombre_actividad = ?, nota_actividad = ?, fecha_entrega = ?, asignacion_id = ? WHERE id_nota = ?;";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Nota nota = null;
    private List<Nota> listaNota = new ArrayList<>();

    @Override
    public List<Nota> listar() {

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {                
                int idNota = rs.getInt("nota.id_nota");
                String nombreActividad = rs.getString("nota.nombre_actividad");
                int notaActividad = rs.getInt("nota.nota_actividad");
                Date fechaEntrega = rs.getDate("nota.fecha_entrega");
                String idAsignacion = rs.getString("nota.asignacion_id");
               
                
               // nota = new Nota(idNota, nombreActividad, notaActividad, fechaEntrega, idAsignacion);
                listaNota.add(nota);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaNota;
    }

    @Override
    public Nota encontrar(Nota nota) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, nota.getIdNota());
            rs = pstmt.executeQuery();
            
            while (rs.next()) {                
                String nombreActividad = rs.getString("nota.nombre_actividad");
                int notaActividad = rs.getInt("nota.nota_actividad");
                Date fechaEntrega = rs.getDate("nota.fecha_entrega");
                String idAsignacion = rs.getString("nota.asignacion_id");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String descripcion = rs.getString("descripcion");
                Timestamp fecha_asignacion = rs.getTimestamp("fecha_asignacion");
               
                nota.setNombreActividad(nombreActividad);
                nota.setNotaActividad(notaActividad);
                nota.setFechaEntrega(fechaEntrega);
                //nota.setIdAsignacion(idAsignacion);
/*                nota.setNombres(nombres);
                nota.setApellidos(apellidos);
                nota.setDescripcion(descripcion);
                nota.setFecha_asignacion(fecha_asignacion);*/
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return nota;
    }

    @Override
    public int insertar(Nota nota) {
        int rows = 0;
        /*try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, nota.getNombreActividad());
            pstmt.setInt(2, nota.getNotaActividad());
            pstmt.setDate(3, nota.getFechaEntrega());
            pstmt.setString(4, nota.getIdAsignacion());
            rows = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }*/
        return rows;
    }

    @Override
    public int actualizar(Nota nota) {
         int rows = 0;

        /*try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, nota.getNombreActividad());
            pstmt.setInt(2, nota.getNotaActividad());
            pstmt.setDate(3, nota.getFechaEntrega());
            pstmt.setString(4, nota.getIdAsignacion());
            pstmt.setInt(5, nota.getIdNota());
            System.out.println(pstmt.toString());

            rows = pstmt.executeUpdate();
            System.out.println(pstmt.toString());
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }*/
        return rows;
    }

    @Override
    public int eliminar(Nota nota) {
        int rows = 0;
        /*try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, nota.getIdNota());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }*/
        return rows;
    }

}
