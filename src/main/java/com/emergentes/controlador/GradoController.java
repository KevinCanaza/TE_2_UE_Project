package com.emergentes.controlador;

import com.emergentes.dao.GradoDAO;
import com.emergentes.dao.GradoDAOimpl;
import com.emergentes.dao.ParaleloDAO;
import com.emergentes.dao.ParaleloDAOimpl;
import com.emergentes.modelo.Grado;
import com.emergentes.modelo.Paralelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GradoController", urlPatterns = {"/GradoController"})
public class GradoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            GradoDAO dao = new GradoDAOimpl();
            ParaleloDAO daoparalelo = new ParaleloDAOimpl();
            String cod_grado;
            List<Paralelo> lista_paralelo = null;
            Grado g = new Grado();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_paralelo = daoparalelo.getAll();
                    request.setAttribute("lista_paralelo", lista_paralelo);
                    request.setAttribute("action", action);
                    request.setAttribute("grado", g);
                    request.getRequestDispatcher("frm_grado.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_grado = request.getParameter("cod_grado");

                    g = dao.getById(cod_grado);
                    lista_paralelo = daoparalelo.getAll();
                    request.setAttribute("action", action);
                    request.setAttribute("lista_paralelo", lista_paralelo);
                    request.setAttribute("grado", g);
                    request.getRequestDispatcher("frm_grado.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_grado = request.getParameter("cod_grado");

                    dao.delete(cod_grado);

                    response.sendRedirect("GradoController");
                    break;
                case "view":

                    List<Grado> lista = dao.getAll();
                    request.setAttribute("grado", lista);
                    request.getRequestDispatcher("grado.jsp").forward(request, response);
                    break;
                case "buscar":
                    String dato = request.getParameter("txtBuscar");

                    List<Grado> list = dao.buscar(dato);

                    request.setAttribute("grado", list);
                    request.getRequestDispatcher("grado.jsp").forward(request, response);
                    break;

                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error Fatal" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod_grado = request.getParameter("cod_grado");
        String descripcion = request.getParameter("descripcion");
        String cod_paralelo = request.getParameter("cod_paralelo");

        Grado g = new Grado();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        g.setCod_grado(cod_grado);
        g.setDescripcion(descripcion);
        g.setCod_paralelo(cod_paralelo);

        switch (action) {
            case "add":
                //Nuevo
                GradoDAO dao = new GradoDAOimpl();
                try {
                    dao.insert(g);
                    response.sendRedirect("GradoController");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                GradoDAO da = new GradoDAOimpl();
                try {
                    da.update(g);
                    response.sendRedirect("GradoController");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
