package com.diegopatzan.db;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 * @author Gabriel Enrique Hurtarte Garcia
 * Codigo técnico:IN5BM
 * @date 30/08/2021
 * @time 08:47:37 AM
 */
public class Conexion {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DB = "control_academico";
    private static final String USER = "root";
    private static final String PASS = "admin";

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB + "?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false&useTimezone=true";

    public static BasicDataSource basicDataSource;

    public static DataSource getDataSource() {

        if (basicDataSource == null) {
            basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(URL);
            basicDataSource.setUsername(USER);
            basicDataSource.setPassword(PASS);
            basicDataSource.setInitialSize(25);
        }

        return basicDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement pstmt) {
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
