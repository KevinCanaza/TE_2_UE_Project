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

        <title>paralelo</title>
    </head>
    <body style="background-image: url(img/fnd3.jpg)">
        <div class="contenedor">
            <br>
            <form action="NotaController" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" value="${nota.cod_nota}"/>
                <div class="form-header">
                    <h1 class="form-title">N<span>ota</span></h1>
                </div>
                <label for="" class="form-label">Código:</label>
                <input type="text" name="cod_nota" class="form-input" value="${nota.cod_nota}" placeholder="Escriba el código"required>

                <label for="" class="form-label">Estudiante</label>
                <select name="rude" class="form-input" required>
                    <option value=""> --Seleccione-- </option>
                    <c:forEach var="item" items="${lista_estudiante}">
                        <option value="${item.rude}"
                                <c:if test="${nota.rude == item.rude}">
                                    selected
                                </c:if>
                                >${item.nombre} ${' '} ${item.apellidos}</option>
                    </c:forEach>
                </select>

                <label for="" class="form-label">Primer Trimestre:</label>
                <input type="text" name="primer_trimestre" class="form-input" value="${nota.primer_trimestre}" placeholder="Escriba la nota del primer trimestre"required>

                <label for="" class="form-label">Segundo Trimestre:</label>
                <input type="text" name="segundo_trimestre" class="form-input" value="${nota.segundo_trimestre}" placeholder="Escriba la nota del segundo trimestre"required>

                <label for="" class="form-label">Tercer Trimestre:</label>
                <input type="text" name="tercer_trimestre" class="form-input" value="${nota.tercer_trimestre}" placeholder="Escriba la nota del tercer trimestre"required>

                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>
