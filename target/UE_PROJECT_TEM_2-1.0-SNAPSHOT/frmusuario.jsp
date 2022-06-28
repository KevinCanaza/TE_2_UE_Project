<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0,
              maximum-scale=1.0, minimum-scale=1.0">

        <link rel="stylesheet" href="scss/validacion.scss">
        <title>Formulario Usuarios</title>
    </head>
    <body style="background-image: url(img/fnd3.jpg)">
        <link rel="stylesheet" href="css/estilo.css">
        <div class="contenedor">
            <form action="UsuarioControlador" method="post" class="form">
                <input type="hidden" name="cod_usr" value="${usuario.cod_usr}" />
                <div class="form-header">
                    <h1 class="form-title">U<span>suario</span></h1>
                </div>
                <label for="nombre" class="form-label">Nombres:</label>
                <input type="text" name="nombre" class="form-input" value="${usuario.nombre}"
                       placeholder="Escriba su nombre" required>

                <label for="apellidos" class="form-label">Apellidos:</label>
                <input type="text" name="apellidos" class="form-input" value="${usuario.apellidos}"
                       placeholder="Escriba su apellido" required>

                <label for="usuario" class="form-label">Usuario:</label>
                <input type="text" name="usuario" class="form-input" value="${usuario.usuario}"
                       placeholder="Escriba su usuario" required>

                <label for="password" class="form-label">Contraseña:</label>

                <br>
                <div class="container">
                    <input type="password" name="contraseña" class="form-input"  id="Input" value="${usuario.contraseña}"
                           placeholder="Escriba su contraseña" required>
                    <img src="img/mostrar.jpg" alt="" class="icon" id="Eye">
                </div>
                <br>
                <label for="tipo_usuario" class="form-label">Tipo Usuario:</label>
                <select name="tipo_usuario" class="form-input" required>
                    <option value="">--Seleccione--</option>

                    <option value="ADMINISTRADOR" <c:if test="${usuario.tipo_usuario == 'ADMINISTRADOR'}">
                            selected
                        </c:if>
                        >ADMINISTRADOR</option>
                    <option value="USUARIO" <c:if test="${usuario.tipo_usuario == 'USUARIO'}">
                            selected
                        </c:if>
                        >USUARIO</option>
                </select>
                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>
        <script src="js/codigo.js"></script>
    </body>
</html>