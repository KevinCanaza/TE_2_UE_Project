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

        <title>Formulario de Grado</title>
    </head>
    <body style="background-image: url(img/fnd3.jpg)">
        <div class="contenedor">
            <br>
            <form action="GradoController" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" value="${grado.cod_grado}"/>
                <div class="form-header">
                    <h1 class="form-title">G<span>rado</span></h1>
                </div>
                <label for="" class="form-label">Codigo</label>
                <input type="text" name="cod_grado" class="form-input" value="${grado.cod_grado}" placeholder="Escriba el código"required>

                <label for="" class="form-label">Grado:</label>
                <input type="text" name="descripcion" class="form-input" value="${grado.descripcion}" placeholder="Escriba el grado"required>

                <label for="" class="form-label">Paralelo</label>
                <select name="cod_paralelo" class="form-input" required>
                    <option value="null"> --Seleccione-- </option>
                    <c:forEach var="item" items="${lista_paralelo}">
                        <option value="${item.cod_paralelo}"
                                <c:if test="${grado.cod_paralelo == item.cod_paralelo}">
                                    selected
                                </c:if>
                                >${item.descripcion}</option>
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
