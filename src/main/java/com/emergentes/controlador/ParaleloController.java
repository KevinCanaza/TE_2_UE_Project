package com.emergentes.controlador;

import com.emergentes.dao.ParaleloDAO;
import com.emergentes.dao.ParaleloDAOimpl;
import com.emergentes.modelo.Paralelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ParaleloController", urlPatterns = {"/ParaleloController"})
public class ParaleloController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Paralelo p = new Paralelo();
            String cod_paralelo;
            ParaleloDAO dao = new ParaleloDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("action", action);
                    request.setAttribute("paralelo", p);
                    request.getRequestDispatcher("frmparalelo.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_paralelo = request.getParameter("cod_paralelo");
                    p = dao.getById(cod_paralelo);
                    request.setAttribute("action", action);
                    request.setAttribute("paralelo", p);

                    request.getRequestDispatcher("frmparalelo.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_paralelo = request.getParameter("cod_paralelo");

                    dao.delete(cod_paralelo);

                    response.sendRedirect("ParaleloController");
                    break;
                case "view":

                    List<Paralelo> lista = dao.getAll();

                    request.setAttribute("paralelo", lista);
                    request.getRequestDispatcher("paralelo.jsp").forward(request, response);
                    break;
                case "buscar":
                    String dato = request.getParameter("txtBuscar");

                    List<Paralelo> list = dao.buscar(dato);

                    request.setAttribute("paralelo", list);
                    request.getRequestDispatcher("paralelo.jsp").forward(request, response);
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

        String cod_paralelo = request.getParameter("cod_paralelo");
        String descripcion = request.getParameter("descripcion");

        Paralelo p = new Paralelo();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        p.setCod_paralelo(cod_paralelo);
        p.setDescripcion(descripcion);

        switch (action) {
            case "add":
                //Nuevo
                ParaleloDAO dao = new ParaleloDAOimpl();
                try {
                    dao.insert(p);
                    response.sendRedirect("ParaleloController");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                ParaleloDAO da = new ParaleloDAOimpl();
                try {
                    da.update(p);
                    response.sendRedirect("ParaleloController");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;

        }
    }
}
