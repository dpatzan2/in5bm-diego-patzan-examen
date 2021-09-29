/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.dao;

import com.diegopatzan.models.domain.Cursos;
import com.diegopatzan.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.diegopatzan.models.idao.ICursosDao;
import java.sql.Time;

/**
 *
 * @author Marcelo Javier Diaz Pineda
 * @date 30/08/2021
 * @time 04:57:53 PM
 */
public class CursoDaoImpl implements ICursosDao {

    private static final String SQL_SELECT = "SELECT curso.curso_id, curso.ciclo, curso.cupo_maximo, curso.cupo_minimo, curso.descripcion, carrera_tecnica.nombre AS carrera, horario.horario_inicio, horario.horario_final, concat(instructor.nombres, ' ', instructor.apellidos) AS instructor, salon.nombre_salon \n"
            + "FROM curso\n"
            + "INNER JOIN horario ON curso.horario_id = horario.horario_id\n"
            + "INNER JOIN instructor ON curso.instructor_id = instructor.instructor_id\n"
            + "INNER JOIN salon ON curso.salon_id = salon.salon_id\n"
            + "INNER JOIN carrera_tecnica ON curso.codigo_carrera = carrera_tecnica.codigo_carrera;";
    private static final String SQL_DELETE = "DELETE FROM curso WHERE curso_id = ?";
    private static final String SQL_INSERT = "INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values(?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT curso.curso_id, curso.ciclo, curso.cupo_maximo, curso.cupo_minimo, curso.descripcion, carrera_tecnica.codigo_carrera, \n"
            + "carrera_tecnica.nombre AS carrera, horario.horario_id, horario.horario_inicio, horario.horario_final, instructor.instructor_id, \n"
            + "concat(instructor.nombres, ' ', instructor.apellidos) AS instructor, salon.salon_id, salon.nombre_salon,  salon.descripcion AS carreraDescripcion FROM curso\n"
            + "INNER JOIN horario ON curso.horario_id = horario.horario_id\n"
            + "INNER JOIN instructor ON curso.instructor_id = instructor.instructor_id\n"
            + "INNER JOIN salon ON curso.salon_id = salon.salon_id\n"
            + "INNER JOIN carrera_tecnica ON curso.codigo_carrera = carrera_tecnica.codigo_carrera WHERE curso_id = ?";
    
    private static final String SQL_UPDATE = "UPDATE curso SET ciclo=?, cupo_Maximo=?,cupo_Minimo=?,descripcion=?,codigo_Carrera=?,horario_id=?,instructor_id=?,salon_id=? WHERE curso_id = ?";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Cursos cursos = null;
    List<Cursos> listaCursos = new ArrayList<>();

    @Override
    public List<Cursos> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idCurso = rs.getInt("curso_id");
                int ciclo = rs.getInt("ciclo");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descripcion");
                String carrera = rs.getString("carrera");
                Time horarioInicio = rs.getTime("horario_inicio");
                Time horarioFinal = rs.getTime("horario_final");
                String instructor = rs.getString("instructor");
                String nombreSalon = rs.getString("nombre_salon");

                cursos = new Cursos(idCurso, ciclo, cupoMaximo, cupoMinimo, descripcion, carrera, horarioInicio, horarioFinal, instructor, nombreSalon);
                listaCursos.add(cursos);
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
        return listaCursos;
    }

    @Override
    public Cursos encontrar(Cursos cursos) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, cursos.getIdCurso());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int ciclo = rs.getInt("ciclo");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descripcion");
                String codigoCarrera = rs.getString("codigo_carrera");
                String carrera = rs.getString("carrera");
                int idHorario = rs.getInt("horario_id");
                Time horarioInicio = rs.getTime("horario_inicio");
                Time horarioFinal = rs.getTime("horario_final");
                int idInstructor = rs.getInt("instructor_id");
                String instructor = rs.getString("instructor");
                int idSalon = rs.getInt("salon_id");
                String nombreSalon = rs.getString("nombre_salon");
                String carreraDescripcion = rs.getString("carreraDescripcion");

                cursos.setCiclo(ciclo);
                cursos.setCupoMaximo(cupoMaximo);
                cursos.setCupoMinimo(cupoMinimo);
                cursos.setDescripcion(descripcion);
                cursos.setCodigoCarrera(codigoCarrera);
                cursos.setCarrera(carrera);
                cursos.setIdHorario(idHorario);
                cursos.setHorarioInicio(horarioInicio);
                cursos.setHorarioFinal(horarioFinal);
                cursos.setIdInstructor(idInstructor);
                cursos.setInstructor(instructor);
                cursos.setIdSalon(idSalon);
                cursos.setNombreSalon(nombreSalon);
                cursos.setCarreraDescripcion(carreraDescripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return cursos;
    }

    @Override
    public int insertar(Cursos cursos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, cursos.getCiclo());
            pstmt.setInt(2, cursos.getCupoMaximo());
            pstmt.setInt(3, cursos.getCupoMinimo());
            pstmt.setString(4, cursos.getDescripcion());
            pstmt.setString(5, cursos.getCodigoCarrera());
            pstmt.setInt(6, cursos.getIdHorario());
            pstmt.setInt(7, cursos.getIdInstructor());
            pstmt.setInt(8, cursos.getIdSalon());

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
    public int actualizar(Cursos cursos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, cursos.getCiclo());
            pstmt.setInt(2, cursos.getCupoMaximo());
            pstmt.setInt(3, cursos.getCupoMinimo());
            pstmt.setString(4, cursos.getDescripcion());
            pstmt.setString(5, cursos.getCodigoCarrera());
            pstmt.setInt(6, cursos.getIdHorario());
            pstmt.setInt(7, cursos.getIdInstructor());
            pstmt.setInt(8, cursos.getIdSalon());
            pstmt.setInt(9, cursos.getIdCurso());

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
    public int eliminar(Cursos cursos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, cursos.getIdCurso());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            return rows;
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
