package com.emergentes.controlador;

import com.emergentes.dao.TurnoDAO;
import com.emergentes.dao.TurnoDAOimpl;
import com.emergentes.modelo.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurnoController", urlPatterns = {"/TurnoController"})
public class TurnoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Turno t = new Turno();
            String cod_turno;
            TurnoDAO dao = new TurnoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("turno", t);
                    request.setAttribute("action", action);
                    request.getRequestDispatcher("frm_turno.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_turno = request.getParameter("cod_turno");

                    t = dao.getById(cod_turno);
                    request.setAttribute("action", action);
                    request.setAttribute("turno", t);

                    request.getRequestDispatcher("frm_turno.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_turno = request.getParameter("cod_turno");

                    dao.delete(cod_turno);

                    response.sendRedirect("TurnoController");
                    break;
                case "view":

                    List<Turno> lista = dao.getAll();

                    request.setAttribute("turno", lista);
                    request.getRequestDispatcher("turno.jsp").forward(request, response);
                    break;
                case "buscar":
                    String dato = request.getParameter("txtBuscar");

                    List<Turno> list = dao.buscar(dato);

                    request.setAttribute("turno", list);
                    request.getRequestDispatcher("turno.jsp").forward(request, response);
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
        String cod_turno = request.getParameter("cod_turno");
        String turno = request.getParameter("turno");
        String inicio = request.getParameter("inicio");
        String fin = request.getParameter("fin");

        Turno t = new Turno();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        t.setCod_turno(cod_turno);
        t.setTurno(turno);
        t.setInicio(inicio);
        t.setFin(fin);

        switch (action) {
            case "add":
                //Nuevo
                TurnoDAO dao = new TurnoDAOimpl();
                try {
                    dao.insert(t);
                    response.sendRedirect("TurnoController");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                TurnoDAO da = new TurnoDAOimpl();
                try {
                    da.update(t);
                    response.sendRedirect("TurnoController");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
