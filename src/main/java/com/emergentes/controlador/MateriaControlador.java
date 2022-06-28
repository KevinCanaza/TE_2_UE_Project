package com.emergentes.controlador;

import com.emergentes.dao.MateriaDAO;
import com.emergentes.dao.MateriaDAOimpl;
import com.emergentes.modelo.Materia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MateriaControlador", urlPatterns = {"/MateriaControlador"})
public class MateriaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Materia mat = new Materia();
            String cod_mat;
            String dato;
            MateriaDAO dao = new MateriaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("materia", mat);
                    request.setAttribute("action", action);
                    request.getRequestDispatcher("frmmateria.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_mat = request.getParameter("cod_mat");
                    mat = dao.getById(cod_mat);
                    request.setAttribute("action", action);
                    request.setAttribute("materia", mat);
                    request.getRequestDispatcher("frmmateria.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_mat = request.getParameter("cod_mat");
                    dao.delete(cod_mat);
                    response.sendRedirect("MateriaControlador");
                    break;
                case "view":
                    List<Materia> lista = dao.getAll();
                    request.setAttribute("materia", lista);
                    request.getRequestDispatcher("materia.jsp").forward(request, response);
                    break;
                default:
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<Materia> list = dao.buscar(dato);

                    request.setAttribute("materia", list);
                    request.getRequestDispatcher("materia.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod_mat = request.getParameter("cod_mat");
        String descripcion = request.getParameter("descripcion");
        String sigla = request.getParameter("sigla");

        Materia mat = new Materia();

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        mat.setCod_mat(cod_mat);
        mat.setDescripcion(descripcion);
        mat.setSigla(sigla);

        switch (action) {
            case "add":
                //Nuevo
                MateriaDAO dao = new MateriaDAOimpl();
                try {
                    dao.insert(mat);
                    response.sendRedirect("MateriaControlador");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                MateriaDAO da = new MateriaDAOimpl();
                try {
                    da.update(mat);
                    response.sendRedirect("MateriaControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }
    }
}
