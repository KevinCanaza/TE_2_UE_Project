package com.emergentes.controlador;

import com.emergentes.dao.PPFFDAO;
import com.emergentes.dao.PPFFDAOimpl;
import com.emergentes.modelo.PPFF;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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

@WebServlet(name = "PpffController", urlPatterns = {"/PpffController"})
public class PpffController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            PPFF p = new PPFF();
            String cod_ppff;
            PPFFDAO dao = new PPFFDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("action", action);
                    request.setAttribute("ppff", p);
                    request.getRequestDispatcher("frm_ppff.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_ppff = request.getParameter("cod_ppff");

                    p = dao.getById(cod_ppff);
                    request.setAttribute("action", action);
                    request.setAttribute("ppff", p);

                    request.getRequestDispatcher("frm_ppff.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_ppff = request.getParameter("cod_ppff");

                    dao.delete(cod_ppff);

                    response.sendRedirect("PpffController");
                    break;
                case "view":

                    List<PPFF> lista = dao.getAll();

                    request.setAttribute("ppff", lista);
                    request.getRequestDispatcher("ppff.jsp").forward(request, response);
                    break;

                case "buscar":
                    String dato = request.getParameter("txtBuscar");

                    List<PPFF> list = dao.buscar(dato);

                    request.setAttribute("ppff", list);
                    request.getRequestDispatcher("ppff.jsp").forward(request, response);
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
        String cod_ppff = request.getParameter("cod_ppff");
        int ci = Integer.parseInt(request.getParameter("ci"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        String direccion = request.getParameter("direccion");
        String tipo_pariente = request.getParameter("tipo_pariente");
        int telefono = Integer.parseInt(request.getParameter("telefono"));

        PPFF p = new PPFF();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        p.setCod_ppff(cod_ppff);
        p.setCi(ci);
        p.setNombre(nombre);
        p.setApellidos(apellidos);
        p.setFecha_nacimiento(convierteFecha(fecha_nacimiento));
        p.setDireccion(direccion);
        p.setTipo_pariente(tipo_pariente);
        p.setTelefono(telefono);

        switch (action) {
            case "add":
                //Nuevo
                PPFFDAO dao = new PPFFDAOimpl();
                try {
                    dao.insert(p);
                    response.sendRedirect("PpffController");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                PPFFDAO da = new PPFFDAOimpl();
                try {
                    da.update(p);
                    response.sendRedirect("PpffController");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }
    }

    public Date convierteFecha(String fecha) {
        Date fechaBD = null;

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fechaTMP;
        try {

            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(PpffController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaBD;

    }

}
