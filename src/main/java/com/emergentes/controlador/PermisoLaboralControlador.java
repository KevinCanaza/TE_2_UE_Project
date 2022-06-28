package com.emergentes.controlador;

import com.emergentes.dao.DocenteDAO;
import com.emergentes.dao.DocenteDAOimpl;
import com.emergentes.dao.PermisoLaboralDAO;
import com.emergentes.dao.PermisoLaboralDAOimpl;
import com.emergentes.dao.PersonalAdministrativoDAO;
import com.emergentes.dao.PersonalAdministrativoDAOimpl;
import com.emergentes.modelo.Docente;
import com.emergentes.modelo.PermisoLaboral;
import com.emergentes.modelo.PersonalAdministrativo;
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

@WebServlet(name = "PermisoLaboralControlador", urlPatterns = {"/PermisoLaboralControlador"})
public class PermisoLaboralControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String cod_permiso;
            String dato;

            PermisoLaboral per_lab = new PermisoLaboral();
            PermisoLaboralDAO dao = new PermisoLaboralDAOimpl();

            DocenteDAO daoDocente = new DocenteDAOimpl();
            PersonalAdministrativoDAO daoPersonal = new PersonalAdministrativoDAOimpl();

            List<Docente> lista_docentes = null;
            List<PersonalAdministrativo> lista_personal = null;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_docentes = daoDocente.getAll();
                    lista_personal = daoPersonal.getAll();

                    request.setAttribute("lista_docentes", lista_docentes);
                    request.setAttribute("lista_personal", lista_personal);

                    request.setAttribute("permiso", per_lab);
                    request.setAttribute("action", action);
                    request.getRequestDispatcher("frmpermiso_laboral.jsp").forward(request, response);
                    break;
                case "add2":
                    lista_docentes = daoDocente.getAll();
                    lista_personal = daoPersonal.getAll();

                    request.setAttribute("lista_docentes", lista_docentes);
                    request.setAttribute("lista_personal", lista_personal);

                    request.setAttribute("permiso", per_lab);
                    request.setAttribute("action", action);
                    request.getRequestDispatcher("frmpermiso_laboral.jsp").forward(request, response);
                    break;
                case "edit":
                    cod_permiso = request.getParameter("cod_permiso");
                    per_lab = dao.getById(cod_permiso);

                    lista_docentes = daoDocente.getAll();
                    lista_personal = daoPersonal.getAll();

                    request.setAttribute("lista_docentes", lista_docentes);
                    request.setAttribute("lista_personal", lista_personal);

                    request.setAttribute("action", action);
                    request.setAttribute("permiso", per_lab);
                    request.getRequestDispatcher("frmpermiso_laboral.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_permiso = request.getParameter("cod_permiso");

                    dao.delete(cod_permiso);

                    response.sendRedirect("PermisoLaboralControlador");
                    break;
                case "view":
                    List<PermisoLaboral> lista = dao.getAll();
                    request.setAttribute("permiso", lista);
                    request.getRequestDispatcher("permiso_laboral.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<PermisoLaboral> list = dao.buscar(dato);

                    request.setAttribute("permiso", list);
                    request.getRequestDispatcher("permiso_laboral.jsp").forward(request, response);
                    break;
                case "buscar2":
                    dato = request.getParameter("txtBuscar");

                    List<PermisoLaboral> lis = dao.buscar2(dato);

                    request.setAttribute("permiso", lis);
                    request.getRequestDispatcher("permiso_laboral.jsp").forward(request, response);
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

        String cod_permiso = request.getParameter("cod_permiso");
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        String fecha_inicio = request.getParameter("fecha_inicio");
        String fecha_final = request.getParameter("fecha_final");

        String cod_doc = request.getParameter("cod_doc");
        String cod_admi = request.getParameter("cod_admi");

        PermisoLaboral per_lab = new PermisoLaboral();

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        per_lab.setCod_permiso(cod_permiso);
        per_lab.setDescripcion(descripcion);
        per_lab.setFecha(convierteFecha(fecha));
        per_lab.setFecha_inicio(convierteFecha(fecha_inicio));
        per_lab.setFecha_final(convierteFecha(fecha_final));

        per_lab.setCod_doc(cod_doc);
        per_lab.setCod_admi(cod_admi);

        switch (action) {
            case "add":
                //Nuevo
                PermisoLaboralDAO dao = new PermisoLaboralDAOimpl();
                try {
                    dao.insert(per_lab);
                    response.sendRedirect("PermisoLaboralControlador");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "add2":
                //Nuevo
                PermisoLaboralDAO dao2 = new PermisoLaboralDAOimpl();
                try {
                    dao2.insert2(per_lab);
                    response.sendRedirect("PermisoLaboralControlador");
                } catch (Exception ex) {
                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            //Para personal administrativo
            case "edit":
                System.out.println("mensaje: " + action);
                //Editar
                PermisoLaboralDAO da = new PermisoLaboralDAOimpl();
                try {
                    da.update(per_lab);
                    response.sendRedirect("PermisoLaboralControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
            //Para docente
            case "edit2":
                System.out.println("mensaje: " + action);
                //Editar
                PermisoLaboralDAO da2 = new PermisoLaboralDAOimpl();
                try {
                    da2.update2(per_lab);
                    response.sendRedirect("PermisoLaboralControlador");
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
