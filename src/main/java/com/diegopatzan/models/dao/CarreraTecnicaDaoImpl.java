package com.diegopatzan.models.dao;

import com.diegopatzan.db.Conexion;
import com.diegopatzan.models.domain.CarreraTecnica;
import com.diegopatzan.models.idao.ICarreraTecnicaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel Enrique Hurtarte Garcia Codigo técnico:IN5BM
 * @date 1/09/2021
 * @time 10:24:56 PM
 */
public class CarreraTecnicaDaoImpl implements ICarreraTecnicaDao {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre FROM carrera_tecnica";
    private static final String SQL_DELETE = "DELETE FROM carrera_tecnica WHERE codigo_carrera = ?";
    private static final String SQL_INSERT = "INSERT INTO carrera_tecnica (codigo_carrera, nombre) values (?, ?)";
    private static final String SQL_UPDATE = "UPDATE carrera_tecnica SET nombre=? where codigo_carrera=?";
    private static final String SQL_SELECT_BY_ID = "SELECT nombre FROM carrera_tecnica where codigo_carrera=?";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private CarreraTecnica carreraTecnica = null;
    List<CarreraTecnica> listaCarrera = new ArrayList<>();

    @Override
    public List<CarreraTecnica> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String codigo_carrera = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre");

                carreraTecnica = new CarreraTecnica(codigo_carrera, nombre);
                listaCarrera.add(carreraTecnica);
            }
        } catch (SQLException e) {
            System.out.println("Un registro de Curso depende de este, elimine primero el registro en curso");
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return listaCarrera;
    }

    @Override
    public CarreraTecnica encontrar(CarreraTecnica carreraTecnica) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setString(1, carreraTecnica.getCodigo_carrera());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");

                carreraTecnica.setNombre(nombre);
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
        return carreraTecnica;
    }

    @Override
    public int insertar(CarreraTecnica carreraTecnica) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, carreraTecnica.getCodigo_carrera());
            pstmt.setString(2, carreraTecnica.getNombre());

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
    public int actualizar(CarreraTecnica carreraTecnica) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(2, carreraTecnica.getCodigo_carrera());
            pstmt.setString(1, carreraTecnica.getNombre());

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
    public int eliminar(CarreraTecnica carreraTecnica) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, carreraTecnica.getCodigo_carrera());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return rows;
    }

}
