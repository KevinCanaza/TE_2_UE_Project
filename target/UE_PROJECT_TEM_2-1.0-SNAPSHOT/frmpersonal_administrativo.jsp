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
        <title>Formulario Personal Administrativo</title>
    </head>

    <body style="background-image: url(img/fnd3.jpg)">
        <div class="contenedor">
            <form action="PersonalAdministrativoControlador" method="post" class="form">
                <input type="hidden" value="${personal.cod_admi}"/>
                <input type="hidden" name="action" value="${action}"/>
                <div class="form-header">
                    <h1 class="form-title">P<span>ersonal</span> A<span>dministrativo</span></h1>
                </div>
                <label for="cod_admi" class="form-label">Código:</label>
                <input type="text" name="cod_admi" class="form-input" value="${personal.cod_admi}" placeholder="Escriba su código"required>

                <label for="nombre" class="form-label">Nombres:</label>
                <input type="text" name="nombre" class="form-input" value="${personal.nombre}" placeholder="Escriba su nombre"required>

                <label for="apellidos" class="form-label">Apellidos:</label>
                <input type="text" name="apellidos" class="form-input" value="${personal.apellidos}" placeholder="Escriba su apellido"required>

                <label for="ci" class="form-label">Cédula de Identidad:</label>
                <input type="text" name="ci" class="form-input" value="${personal.ci}" placeholder="Escriba su cédula de identidad"required>

                <label for="fecha_nac" class="form-label">Fecha de Nacimiento:</label>
                <input type="date" name="fecha_nac" class="form-input" value="${personal.fecha_nac}" placeholder="Escriba su fecha de nacimiento"required>

                <label for="direccion" class="form-label">Dirección:</label>
                <input type="text" name="direccion" class="form-input" value="${personal.direccion}" placeholder="Escriba su dirección"required>

                <label for="telefono" class="form-label">Telefono:</label>
                <input type="text" name="telefono" class="form-input" value="${personal.telefono}" placeholder="Escriba su telefono"required>
                
                <label for="cargo" class="form-label">Cargo:</label>
                <input type="text" name="cargo" class="form-input" value="${personal.cargo}" placeholder="Escriba el cargo"required>

                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>
    </body>

</html>
