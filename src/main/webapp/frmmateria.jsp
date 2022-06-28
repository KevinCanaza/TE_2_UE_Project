<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="eS">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0,
              maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="scss/validacion.scss">
        <title>Formulario Materias</title>
    </head>

    <body style="background-image: url(img/fnd3.jpg)">
        <div class="contenedor">
            <form action="MateriaControlador" method="post" class="form">
                <input type="hidden" value="${materia.cod_mat}"/>
                <input type="hidden" name="action" value="${action}"/>
                <div class="form-header">
                    <h1 class="form-title">M<span>aterias</span></h1>
                </div>
                <label for="cod_mat" class="form-label">Código:</label>
                <input type="text" name="cod_mat" class="form-input" value="${materia.cod_mat}" placeholder="Escriba su código"required>

                <label for="descripcion" class="form-label">Descripción:</label>
                <input type="text" name="descripcion" class="form-input" value="${materia.descripcion}" placeholder="Escriba su descripción"required>

                <label for="sigla" class="form-label">Sigla:</label>
                <input type="text" name="sigla" class="form-input" value="${materia.sigla}" placeholder="Escriba su sigla"required>

                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>
    </body>

</html>
