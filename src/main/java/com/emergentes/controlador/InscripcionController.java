package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAO;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.dao.GradoDAO;
import com.emergentes.dao.GradoDAOimpl;
import com.emergentes.dao.InscripcionDAO;
import com.emergentes.dao.InscripcionDAOimpl;
import com.emergentes.dao.TurnoDAO;
import com.emergentes.dao.TurnoDAOimpl;
import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.Grado;
import com.emergentes.modelo.Inscripcion;
import com.emergentes.modelo.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InscripcionController", urlPatterns = {"/InscripcionController"})
public class InscripcionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            InscripcionDAO dao = new InscripcionDAOimpl();
            EstudiantesDAO daoestudiante = new EstudiantesDAOimpl();
            GradoDAO daogrado = new GradoDAOimpl();
            TurnoDAO daoturno = new TurnoDAOimpl();
            String cod_inscripcion;
            List<Grado> lista_grado = null;
            List<Turno> lista_turno = null;
            List<Estudiantes> lista_estudiante = null;
            Inscripcion in = new Inscripcion();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":

                    lista_estudiante = daoestudiante.getAll();
                    request.setAttribute("lista_estudiante", lista_estudiante);

                    lista_grado = daogrado.getAll();
                    request.setAttribute("lista_grado", lista_grado);

                    lista_turno = daoturno.getAll();
                    request.setAttribute("lista_turno", lista_turno);
                    request.setAttribute("action", action);
                    request.setAttribute("inscripcion", in);
                    request.getRequestDispatcher("frm_inscripcion.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_inscripcion = request.getParameter("cod_inscripcion");
                    request.setAttribute("action", action);
                    in = dao.getById(cod_inscripcion);
                    lista_grado = daogrado.getAll();
                    lista_turno = daoturno.getAll();
                    lista_estudiante = daoestudiante.getAll();
                    request.setAttribute("lista_estudiante", lista_estudiante);
                    request.setAttribute("lista_grado", lista_grado);
                    request.setAttribute("lista_turno", lista_turno);
                    request.setAttribute("inscripcion", in);
                    request.getRequestDispatcher("frm_inscripcion.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_inscripcion = request.getParameter("cod_inscripcion");

                    dao.delete(cod_inscripcion);

                    response.sendRedirect("InscripcionController");
                    break;
                case "view":

                    List<Inscripcion> lista = dao.getAll();
                    request.setAttribute("inscripcion", lista);
                    request.getRequestDispatcher("inscripcion.jsp").forward(request, response);
                    break;
                case "buscar":
                    String dato = request.getParameter("txtBuscar");

                    List<Inscripcion> list = dao.buscar(dato);

                    request.setAttribute("inscripcion", list);
                    request.getRequestDispatcher("inscripcion.jsp").forward(request, response);
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

        String cod_inscripcion = request.getParameter("cod_inscripcion");
        String rude1 = request.getParameter("rude1");
        String cod_grado1 = request.getParameter("cod_grado1");
        String cod_turno = request.getParameter("cod_turno");
        String fecha = request.getParameter("fecha");
        String tipo_inscripcion = request.getParameter("tipo_inscripcion");

        Inscripcion in = new Inscripcion();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        in.setCod_inscripcion(cod_inscripcion);
        in.setRude1(rude1);
        in.setCod_grado1(cod_grado1);
        in.setCod_turno(cod_turno);
        in.setFecha(convierteFecha(fecha));
        in.setTipo_inscripcion(tipo_inscripcion);

        switch (action) {
            case "add":
                //Nuevo
                InscripcionDAO dao = new InscripcionDAOimpl();
                try {
                    dao.insert(in);
                    response.sendRedirect("InscripcionController");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                InscripcionDAO da = new InscripcionDAOimpl();
                try {
                    da.update(in);
                    response.sendRedirect("InscripcionController");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

    public java.sql.Date convierteFecha(String fecha) {
        java.sql.Date fechaBD = null;

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fechaTMP;
        try {

            fechaTMP = formato.parse(fecha);
            fechaBD = new java.sql.Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(InscripcionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaBD;
    }

}
