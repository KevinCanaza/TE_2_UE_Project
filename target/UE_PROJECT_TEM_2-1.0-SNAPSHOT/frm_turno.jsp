<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0,
              maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="scss/validacion.scss">

        <title>Formulario de Turno</title>
    </head>
    <body style="background-image: url(img/fnd3.jpg)">
        <div class="contenedor">
            <br>
            <form action="TurnoController" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" value="${turno.cod_turno}"/>
                <div class="form-header">
                    <h1 class="form-title">T<span>urno</span></h1>
                </div>
                <label for="" class="form-label">Código:</label>
                <input type="text" name="cod_turno" class="form-input" value="${turno.cod_turno}" placeholder="Escriba el código"required>

                <label for="" class="form-label">Turno:</label>
                <select name="turno" class="form-input" required>
                    <option value="">--Seleccione--</option>

                    <option value="Maniana" <c:if test="${turno.turno == 'Maniana'}">
                            selected
                        </c:if>
                        >Mañana</option>
                    <option value="Tarde" <c:if test="${turno.turno == 'Tarde'}">
                            selected
                        </c:if>
                        >Tarde</option>
                </select>

                <label for="" class="form-label">Inicio de Turno:</label>
                <input type="time" name="inicio" class="form-input" value="${turno.inicio}" placeholder="Escriba la hora de inicio"required>

                <label for="" class="form-label">Termina el turno:</label>
                <input type="time" name="fin" class="form-input" value="${turno.fin}" placeholder="Escriba la hora del final"required>

                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>
