<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0,
              maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="scss/validacion.scss">

        <title>Formulario de Estudiantes</title>
    </head>
    <body style="background-image: url(img/fnd3.jpg)">
        <div class="contenedor">
            <br>
            <form action="EstudianteController" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" value="${estudiante.rude}"/>
                <div class="form-header">
                    <h1 class="form-title">E<span>studiante</span></h1>
                </div>
                <label for="" class="form-label">Rude:</label>
                <input type="text" name="rude" class="form-input" value="${estudiante.rude}" placeholder="Escriba el rude"required>

                <label for="" class="form-label">Carnet:</label>
                <input type="text" name="ci" class="form-input" value="${estudiante.ci}" placeholder="Escriba la cédula de identidad"required>

                <label for="" class="form-label">Nombre:</label>
                <input type="text" name="nombre" class="form-input" value="${estudiante.nombre}" placeholder="Escriba el nombre"required>

                <label for="" class="form-label">Apellidos:</label>
                <input type="text" name="apellidos" class="form-input" value="${estudiante.apellidos}" placeholder="Escriba el apellido"required>

                <label for="" class="form-label">Fecha de Nacimiento:</label>
                <input type="date" name="fecha_nacimiento" class="form-input" value="${estudiante.fecha_nacimiento}" required>

                <label for="" class="form-label">Dirección:</label>
                <input type="text" name="direccion" class="form-input" value="${estudiante.direccion}" placeholder="Escriba la dirección"required>

                <label for="" class="form-label">Estado:</label>
                <select name="estado" class="form-input" required>
                    <option value="">--Seleccione--</option>

                    <option value="ACTIVO" <c:if test="${estudiante.estado == 'ACTIVO'}">
                            selected
                        </c:if>
                        >ACTIVO</option>
                    <option value="INACTIVO" <c:if test="${estudiante.estado == 'INACTIVO'}">
                            selected
                        </c:if>
                        >INACTIVO</option>
                </select>

                <label for="" class="form-label">Padre de Familia</label>
                <select name="cod_ppff" class="form-input" required>
                    <option value=""> --Seleccione-- </option>
                    <c:forEach var="item" items="${lista_ppff}">
                        <option value="${item.cod_ppff}"
                                <c:if test="${estudiante.cod_ppff == item.cod_ppff}">
                                    selected
                                </c:if>
                                >${item.nombre} ${' '} ${item.apellidos}</option>
                    </c:forEach>
                </select>

                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>
