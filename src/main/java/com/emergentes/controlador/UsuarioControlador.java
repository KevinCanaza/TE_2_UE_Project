package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Usuario use = new Usuario();
            int cod_usr;
            String dato;
            UsuarioDAO dao = new UsuarioDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("usuario", use);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_usr = Integer.parseInt(request.getParameter("cod_usr"));
                    use = dao.getById(cod_usr);
                    request.setAttribute("usuario", use);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_usr = Integer.parseInt(request.getParameter("cod_usr"));

                    dao.delete(cod_usr);

                    response.sendRedirect("UsuarioControlador");
                    break;
                case "view":
                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("usuario", lista);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<Usuario> list = dao.buscar(dato);

                    request.setAttribute("usuario", list);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int cod_usr = Integer.parseInt(request.getParameter("cod_usr"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        String tipo_usuario = request.getParameter("tipo_usuario");

        Usuario use = new Usuario();

        use.setCod_usr(cod_usr);
        use.setNombre(nombre);
        use.setApellidos(apellidos);
        use.setUsuario(usuario);
        use.setContraseña(contraseña);
        use.setTipo_usuario(tipo_usuario);
        if (cod_usr == 0 && usuario != "") {
            //Nuevo
            UsuarioDAO dao = new UsuarioDAOimpl();
            try {
                // Nuevo registro
                dao.insert(use);
                response.sendRedirect("UsuarioControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
            UsuarioDAO dao = new UsuarioDAOimpl();
            try {
                dao.update(use);
                response.sendRedirect("UsuarioControlador");
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
    }
}
