package com.emergentes.controlador;

import com.emergentes.utiles.ConexionDataBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");

        action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
        if (action.equals("logout")) {
            HttpSession ses = request.getSession();
            //Eliminar  la sesion
            ses.invalidate();
        }

        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String sql = "select * from usuarios where usuario=? and contraseña=?";
            ResultSet rs;

            ConexionDataBase canal = new ConexionDataBase();
            Connection cn = canal.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                //crear las variables de session para el uso en la aplicacion
                HttpSession ses = request.getSession();
                ses.setAttribute("logueado", "OK");
                /*ses.setAttribute("usuario", rs.getString("nombres") + rs.getString("apellidos"));*/
                response.sendRedirect("UsuarioControlador");
            } else {
                response.sendRedirect("login.jsp");
            }

        } catch (SQLException ex) {
            System.out.println("Error al entrar a la base de datos" + ex.getMessage());
        }
    }

}
