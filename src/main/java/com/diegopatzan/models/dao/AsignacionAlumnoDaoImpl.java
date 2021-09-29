/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.dao;

import com.diegopatzan.db.Conexion;
import com.diegopatzan.models.domain.AsignacionAlumno;
import com.diegopatzan.models.domain.Cursos;
import com.diegopatzan.models.idao.IAsignacionAlumnoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 *
 * @author Windows 10
 */
public class AsignacionAlumnoDaoImpl implements IAsignacionAlumnoDao {

    private static final String SQL_SELECT = "SELECT asignacion_alumno.asignacion_id, "
            + "asignacion_alumno.carne, asignacion_alumno.curso_id, asignacion_alumno.fecha_asignacion, "
            + "alumno.nombres, alumno.apellidos, curso.descripcion FROM asignacion_alumno "
            + "INNER JOIN alumno on asignacion_alumno.carne = alumno.carne "
            + "INNER JOIN curso on asignacion_alumno.curso_id = curso.curso_id;";
    private static final String SQL_DELETE = "DELETE FROM asignacion_alumno WHERE asignacion_id = ?";
    private static final String SQL_INSERT = "INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) VALUES(?, ?, ?, ?)";
    private static final String SQL_SELECT_BY_ID = "SELECT asignacion_alumno.asignacion_id, "
            + "asignacion_alumno.carne, asignacion_alumno.curso_id, asignacion_alumno.fecha_asignacion, "
            + "alumno.nombres, alumno.apellidos, curso.descripcion, curso.ciclo, curso.cupo_maximo, curso.cupo_minimo FROM asignacion_alumno "
            + "INNER JOIN alumno on asignacion_alumno.carne = alumno.carne "
            + "INNER JOIN curso on asignacion_alumno.curso_id = curso.curso_id WHERE asignacion_id = ?;";
    private static final String SQL_UPDATE = "UPDATE asignacion_alumno SET carne=?, curso_id=?, fecha_asignacion=? WHERE asignacion_id = ?;";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private AsignacionAlumno asignacionAlumno = null;
    private List<AsignacionAlumno> listaAsignacionAlumno = new ArrayList<>();

    @Override
    public List<AsignacionAlumno> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String idAsignacion = rs.getString("asignacion_alumno.asignacion_id");
                String carne = rs.getString("asignacion_alumno.carne");
                int idCurso = rs.getInt("asignacion_alumno.curso_id");
                Timestamp fecha_asignacion = rs.getTimestamp("asignacion_alumno.fecha_asignacion");

                asignacionAlumno = new AsignacionAlumno(idAsignacion, carne, idCurso, fecha_asignacion);
                listaAsignacionAlumno.add(asignacionAlumno);
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
        return listaAsignacionAlumno;
    }

    @Override
    public AsignacionAlumno encontrar(AsignacionAlumno asignacionAlumno) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setString(1, asignacionAlumno.getIdAsignacion());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String carne = rs.getString("carne");
               
                int idCurso = rs.getInt("curso_id");
                
                Timestamp fecha_asignacion = rs.getTimestamp("fecha_asignacion");

                asignacionAlumno.setCarne(carne);
                asignacionAlumno.setIdCurso(idCurso);
                asignacionAlumno.setFecha_asignacion(fecha_asignacion);

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
        return asignacionAlumno;
    }

    @Override
    public int insertar(AsignacionAlumno asignacionAlumno) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, asignacionAlumno.getIdAsignacion());
            pstmt.setString(2, asignacionAlumno.getCarne());
            pstmt.setInt(3, asignacionAlumno.getIdCurso());
            pstmt.setTimestamp(4, asignacionAlumno.getFecha_asignacion());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int actualizar(AsignacionAlumno asignacionAlumno) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, asignacionAlumno.getCarne());
            pstmt.setInt(2, asignacionAlumno.getIdCurso());
            pstmt.setTimestamp(3, asignacionAlumno.getFecha_asignacion());
            pstmt.setString(4, asignacionAlumno.getIdAsignacion());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int eliminar(AsignacionAlumno asignacionAlumno) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, asignacionAlumno.getIdAsignacion());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
