<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String opcion = request.getParameter("opcion");
%>

<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center ">
            <div class="dropdown text-end">
                <a href="#" class="d-block text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="img/menu/administracion.PNG" class="rounded-circle" width="45" height="40" >
                </a>
                <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
                    <li><a class="dropdown-item" href="invitado.jsp">Invitados</a></li>

                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="Logout">Cerrar Sesion</a></li>
                </ul>
            </div>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a class="nav-link px-2 text-white <%=(opcion.equals("personal_administrativo") ? "active" : "")%>" href="PersonalAdministrativoControlador" >Plantel Administrativo</a></li>
                <li><a href="UsuarioControlador" class="nav-link px-2 text-white <%=(opcion.equals("usuario") ? "active" : "")%>">Usuarios</a></li>
                <li><a href="PermisoLaboralControlador" class="nav-link px-2 text-white <%=(opcion.equals("permiso_laboral") ? "active" : "")%>">Permiso Laboral</a></li>

                <li><a href="DocenteControlador" class="nav-link px-2 text-white <%=(opcion.equals("docente") ? "active" : "")%>">Docentes</a></li>
                <li><a href="TurnoController" class="nav-link px-2 text-white <%=(opcion.equals("turno") ? "active" : "")%>">Turno</a></li>
                <li><a href="GradoController" class="nav-link px-2 text-white <%=(opcion.equals("grado") ? "active" : "")%>">Grado</a></li>
                <li><a href="MateriaControlador" class="nav-link px-2 text-white <%=(opcion.equals("materia") ? "active" : "")%>">Materias</a></li>
                <li><a href="ParaleloController" class="nav-link px-2 text-white <%=(opcion.equals("paralelo") ? "active" : "")%>">Paralelo</a></li>
                <li><a href="InscripcionController" class="nav-link px-2 text-white <%=(opcion.equals("inscripcion") ? "active" : "")%>"">Inscripcion</a></li>
                <li><a href="EstudianteController" class="nav-link px-2 text-white <%=(opcion.equals("estudiante") ? "active" : "")%>"">Estudiantes</a></li>
                <li><a href="NotaController" class="nav-link px-2 text-white <%=(opcion.equals("nota") ? "active" : "")%>"">Notas</a></li>
                <li><a href="PpffController" class="nav-link px-2 text-white <%=(opcion.equals("ppff") ? "active" : "")%>"">Padre de Familia</a></li>
            </ul>
            <br>
        </div>
    </div>
</header>