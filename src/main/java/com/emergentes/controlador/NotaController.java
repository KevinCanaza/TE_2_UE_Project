package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAO;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.dao.NotaDAO;
import com.emergentes.dao.NotaDAOimpl;
import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.Nota;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NotaController", urlPatterns = {"/NotaController"})
public class NotaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            NotaDAO dao = new NotaDAOimpl();
            EstudiantesDAO daoestudiante = new EstudiantesDAOimpl();
            String cod_nota;
            List<Estudiantes> lista_estudiante = null;
            Nota n = new Nota();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":

                    lista_estudiante = daoestudiante.getAll();

                    request.setAttribute("lista_estudiante", lista_estudiante);
                    request.setAttribute("action", action);
                    request.setAttribute("nota", n);
                    request.getRequestDispatcher("frm_nota.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_nota = request.getParameter("cod_nota");

                    n = dao.getById(cod_nota);
                    lista_estudiante = daoestudiante.getAll();
                    request.setAttribute("action", action);
                    request.setAttribute("lista_estudiante", lista_estudiante);
                    request.setAttribute("nota", n);
                    request.getRequestDispatcher("frm_nota.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_nota = request.getParameter("cod_nota");

                    dao.delete(cod_nota);
                    response.sendRedirect("NotaController");
                    break;
                case "view":

                    List<Nota> lista = dao.getAll();
                    request.setAttribute("nota", lista);
                    request.getRequestDispatcher("nota.jsp").forward(request, response);
                    break;
                case "buscar":
                    String dato = request.getParameter("txtBuscar");

                    List<Nota> list = dao.buscar(dato);

                    request.setAttribute("nota", list);
                    request.getRequestDispatcher("nota.jsp").forward(request, response);
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

        String cod_nota = request.getParameter("cod_nota");
        String rude = request.getParameter("rude");
        int primer_trimestre = Integer.parseInt(request.getParameter("primer_trimestre"));
        int segundo_trimestre = Integer.parseInt(request.getParameter("segundo_trimestre"));
        int tercero_trimestre = Integer.parseInt(request.getParameter("tercer_trimestre"));
        //int promedio = Integer.parseInt(request.getParameter("promedio"));

        Nota n = new Nota();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        n.setCod_nota(cod_nota);
        n.setRude(rude);
        n.setPrimer_trimestre(primer_trimestre);
        n.setSegundo_trimestre(segundo_trimestre);
        n.setTercer_trimestre(tercero_trimestre);
        //n.setPromedio(promedio);

        switch (action) {
            case "add":
                //Nuevo
                NotaDAO dao = new NotaDAOimpl();
                try {
                    dao.insert(n);
                    response.sendRedirect("NotaController");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                NotaDAO da = new NotaDAOimpl();
                try {
                    da.update(n);
                    response.sendRedirect("NotaController");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }
}
