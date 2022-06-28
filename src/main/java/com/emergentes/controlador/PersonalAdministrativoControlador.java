package com.emergentes.controlador;

import com.emergentes.dao.PersonalAdministrativoDAO;
import com.emergentes.dao.PersonalAdministrativoDAOimpl;
import com.emergentes.modelo.PersonalAdministrativo;
import com.google.protobuf.TextFormat.ParseException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersonalAdministrativoControlador", urlPatterns = {"/PersonalAdministrativoControlador"})
public class PersonalAdministrativoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PersonalAdministrativo per = new PersonalAdministrativo();
            String cod_admi;
            String dato;
            PersonalAdministrativoDAO dao = new PersonalAdministrativoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("personal", per);
                    request.setAttribute("action", action);
                    request.getRequestDispatcher("frmpersonal_administrativo.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_admi = request.getParameter("cod_admi");
                    per = dao.getById(cod_admi);
                    request.setAttribute("action", action);
                    request.setAttribute("personal", per);
                    request.getRequestDispatcher("frmpersonal_administrativo.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_admi = request.getParameter("cod_admi");

                    dao.delete(cod_admi);

                    response.sendRedirect("PersonalAdministrativoControlador");
                    break;
                case "view":
                    List<PersonalAdministrativo> lista = dao.getAll();
                    request.setAttribute("personal", lista);
                    request.getRequestDispatcher("personal_administrativo.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<PersonalAdministrativo> list = dao.buscar(dato);

                    request.setAttribute("personal", list);
                    request.getRequestDispatcher("personal_administrativo.jsp").forward(request, response);
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

        String cod_admi = request.getParameter("cod_admi");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String ci = request.getParameter("ci");
        String fecha_nac = request.getParameter("fecha_nac");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String cargo = request.getParameter("cargo");

        PersonalAdministrativo per = new PersonalAdministrativo();

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        per.setCod_admi(cod_admi);
        per.setNombre(nombre);
        per.setApellidos(apellidos);
        per.setCi(ci);
        per.setFecha_nac(convierteFecha(fecha_nac));
        per.setDireccion(direccion);
        per.setTelefono(telefono);
        per.setCargo(cargo);

        switch (action) {
            case "add":
                //Nuevo
                PersonalAdministrativoDAO dao = new PersonalAdministrativoDAOimpl();
                try {
                    dao.insert(per);
                    response.sendRedirect("PersonalAdministrativoControlador");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                PersonalAdministrativoDAO da = new PersonalAdministrativoDAOimpl();
                try {
                    da.update(per);
                    response.sendRedirect("PersonalAdministrativoControlador");
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
        } catch (Exception ex) {
        }
        return fechaBD;
    }
}
