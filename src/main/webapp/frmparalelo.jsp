<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
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

        <title>Formulario de Paralelos</title>
    </head>
    <body style="background-image: url(img/fnd3.jpg)">
        <div class="contenedor">
            <br>
            <form action="ParaleloController" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" value="${paralelo.cod_paralelo}"/>
                <div class="form-header">
                    <h1 class="form-title">P<span>aralelo</span></h1>
                </div>
                <label for="" class="form-label">Código:</label>
                <input type="text" name="cod_paralelo" class="form-input" value="${paralelo.cod_paralelo}" placeholder="Escriba su código"required>

                <label for="" class="form-label">Descripción:</label>
                <input type="text" name="descripcion" class="form-input" value="${paralelo.descripcion}" placeholder="Escriba su descripción"required>

                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>
