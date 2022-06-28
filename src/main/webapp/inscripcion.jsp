<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html> 
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="css/tabla.css">
        <link rel="stylesheet" href="css/menu.css">

        <title>Inscripción</title>
    </head>

    <body style="background-image: url(img/lista-fondo.jpg)">

        <jsp:include page="WEB-INF/menu.jsp">
            <jsp:param name="opcion" value="inscripcion" />
        </jsp:include>
        <br>
        <h1 style="text-align: center; ">I<span>nscripción</span></h1>
        <table class="container1">
            <tr>
                <th><a href="InscripcionController?action=add" class="btn fourth">Nuevo</a></th>
                <th><form class="d-flex " >

                        <input class="form-control me-2" type="search" placeholder="Buscar" name="txtBuscar" aria-label="Search">
                        <button class="btn btn-outline-success" accesskey="" name="action" value="buscar"  type="submit">Buscar</button>
                        <button class="btn btn-outline-success" name="action" value="view"  type="submit">ACTUALIZAR</button>
                    </form>
                </th>
            </tr>
        </table>
        <table class="container1" >
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Estudiante</th>
                    <th>Grado</th>
                    <th>Turno</th>
                    <th>Fecha</th>
                    <th>Tipo de Inscripción</th> 

                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${inscripcion}">
                    <tr>
                        <td>${item.cod_inscripcion}</td>
                        <td>${item.estudiante}</td>
                        <td>${item.grado}</td>
                        <td>${item.turno}</td>
                        <td>${item.fecha}</td>
                        <td>${item.tipo_inscripcion}</td>
                        <td><a href="InscripcionController?action=edit&cod_inscripcion=${item.cod_inscripcion}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                        <td><a href="InscripcionController?action=delete&cod_inscripcion=${item.cod_inscripcion}" onclick="return(confirm('Estas seguro de eliminar'))"><i class="fa-solid fa-trash-can"></i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

    </body>
</html>
