package com.diegopatzan.controllers;

import com.diegopatzan.db.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Gabriel Enrique Hurtarte Garcia Codigo técnico:IN5BM
 * @date 15/09/2021
 * @time 11:33:23 PM
 */
@WebServlet("/ServletLoginController")
public class ServletLoginController extends HttpServlet {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private String passDB;
    private String userDB;
    private String nombreDB;
    private final String ERROR = "El usuario o la contraseña son incorrectos";
    private String mensaje = "";
    private static final String SQL_SELECT = "SELECT nombre, usuario, clave FROM usuario WHERE usuario=?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession sesion = request.getSession();
        String user = request.getParameter("usuario");
        String pass = request.getParameter("clave");
        pass.trim();
        getPassword(user);
        if (this.passDB != null) {
            String pass64 = new String(Base64.getDecoder().decode(this.passDB));
            if (user.equals(this.userDB) && pass.equals(pass64)) {
                response.sendRedirect("inicio.jsp");
                this.mensaje = "";
            } else {
                this.mensaje = this.ERROR;
                response.sendRedirect("login.jsp");
            }
        } else {
            this.mensaje = this.ERROR;
            response.sendRedirect("login.jsp");
        }

        sesion.setAttribute("mensaje", mensaje);
    }

    private void getPassword(String user) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            pstmt.setString(1, user);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                this.nombreDB = rs.getString("nombre");
                this.userDB = rs.getString("usuario");
                this.passDB = rs.getString("clave");
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

    }

}
