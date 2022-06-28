package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAO;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.dao.PPFFDAO;
import com.emergentes.dao.PPFFDAOimpl;
import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.PPFF;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstudianteController", urlPatterns = {"/EstudianteController"})
public class EstudianteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EstudiantesDAO dao = new EstudiantesDAOimpl();
            PPFFDAO daoppff = new PPFFDAOimpl();
            String rude;
            String dato;
            List<PPFF> lista_ppff = null;
            Estudiantes es = new Estudiantes();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":

                    lista_ppff = daoppff.getAll();

                    request.setAttribute("lista_ppff", lista_ppff);
                    request.setAttribute("action", action);
                    request.setAttribute("estudiante", es);
                    request.getRequestDispatcher("frm_estudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    rude = request.getParameter("rude");

                    es = dao.getById(rude);
                    lista_ppff = daoppff.getAll();
                    request.setAttribute("action", action);
                    request.setAttribute("lista_ppff", lista_ppff);
                    request.setAttribute("estudiante", es);
                    request.getRequestDispatcher("frm_estudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    rude = request.getParameter("rude");

                    dao.delete(rude);

                    response.sendRedirect("EstudianteController");
                    break;
                case "view":

                    List<Estudiantes> lista = dao.getAll();
                    request.setAttribute("estudiante", lista);
                    request.getRequestDispatcher("estudiante.jsp").forward(request, response);
                    break;
                case "buscar":
                     dato= request.getParameter("txtBuscar");

                    List<Estudiantes> list = dao.buscar(dato);

                    request.setAttribute("estudiante", list);
                    request.getRequestDispatcher("estudiante.jsp").forward(request, response);
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

        String rude = request.getParameter("rude");
        int ci = Integer.parseInt(request.getParameter("ci"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        String direccion = request.getParameter("direccion");
        String estado = request.getParameter("estado");
        String cod_ppff = request.getParameter("cod_ppff");

        Estudiantes es = new Estudiantes();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        es.setRude(rude);
        es.setCi(ci);
        es.setNombre(nombre);
        es.setApellidos(apellidos);
        es.setFecha_nacimiento(convierteFecha(fecha_nacimiento));
        es.setDireccion(direccion);
        es.setEstado(estado);
        es.setCod_ppff(cod_ppff);

        switch (action) {
            case "add":
                //Nuevo
                EstudiantesDAO dao = new EstudiantesDAOimpl();
                try {
                    dao.insert(es);
                    response.sendRedirect("EstudianteController");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                EstudiantesDAO da = new EstudiantesDAOimpl();
                try {
                    da.update(es);
                    response.sendRedirect("EstudianteController");
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
            Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaBD;
    }

}
