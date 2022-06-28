package com.emergentes.controlador;

import com.emergentes.dao.DocenteDAO;
import com.emergentes.dao.DocenteDAOimpl;
import com.emergentes.dao.GradoDAO;
import com.emergentes.dao.GradoDAOimpl;
import com.emergentes.dao.MateriaDAO;
import com.emergentes.dao.MateriaDAOimpl;
import com.emergentes.modelo.Docente;
import com.emergentes.modelo.Grado;
import com.emergentes.modelo.Materia;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DocenteControlador", urlPatterns = {"/DocenteControlador"})
public class DocenteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String cod_doc;
            String dato;

            Docente doc = new Docente();
            DocenteDAO dao = new DocenteDAOimpl();

            MateriaDAO daoMateria = new MateriaDAOimpl();
            GradoDAO daoGrado = new GradoDAOimpl();

            List<Materia> lista_materias = null;
            List<Grado> lista_grados = null;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_materias = daoMateria.getAll();
                    lista_grados = daoGrado.getAll();

                    request.setAttribute("lista_materias", lista_materias);
                    request.setAttribute("lista_grados", lista_grados);

                    request.setAttribute("docente", doc);
                    request.setAttribute("action", action);
                    request.getRequestDispatcher("frmdocente.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_doc = request.getParameter("cod_doc");
                    doc = dao.getById(cod_doc);

                    lista_materias = daoMateria.getAll();
                    lista_grados = daoGrado.getAll();

                    request.setAttribute("lista_materias", lista_materias);
                    request.setAttribute("lista_grados", lista_grados);

                    request.setAttribute("action", action);
                    request.setAttribute("docente", doc);
                    request.getRequestDispatcher("frmdocente.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_doc = request.getParameter("cod_doc");

                    dao.delete(cod_doc);

                    response.sendRedirect("DocenteControlador");
                    break;
                case "view":
                    List<Docente> lista = dao.getAll();
                    request.setAttribute("docente", lista);
                    request.getRequestDispatcher("docente.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<Docente> list = dao.buscar(dato);

                    request.setAttribute("docente", list);
                    request.getRequestDispatcher("docente.jsp").forward(request, response);
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

        String cod_doc = request.getParameter("cod_doc");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String ci = request.getParameter("ci");
        String direccion = request.getParameter("direccion");
        String fecha_nac = request.getParameter("fecha_nac");
        String telefono = request.getParameter("telefono");

        String cod_mat = request.getParameter("cod_mat");
        String cod_grado = request.getParameter("cod_grado");

        Docente doc = new Docente();

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        doc.setCod_doc(cod_doc);
        doc.setNombre(nombre);
        doc.setApellidos(apellidos);
        doc.setCi(ci);
        doc.setDireccion(direccion);
        doc.setFecha_nac(convierteFecha(fecha_nac));
        doc.setTelefono(telefono);

        doc.setCod_mat(cod_mat);
        doc.setCod_grado(cod_grado);

        switch (action) {
            case "add":
                //Nuevo
                DocenteDAO dao = new DocenteDAOimpl();
                try {
                    dao.insert(doc);
                    response.sendRedirect("DocenteControlador");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                DocenteDAO da = new DocenteDAOimpl();
                try {
                    da.update(doc);
                    response.sendRedirect("DocenteControlador");
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
