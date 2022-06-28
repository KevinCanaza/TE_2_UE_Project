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

        <title>Formulario de Padre de Familia</title>
    </head>
    <body style="background-image: url(img/fnd3.jpg)">
        <div class="contenedor">
            <br>
            <form action="PpffController" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" value="${ppff.cod_ppff}"/>
                <div class="form-header">
                    <h1 class="form-title">P<span>adre</span> <span>de</span> F<span>amilia</span></h1>
                </div>
                <label for="" class="form-label">Código:</label>
                <input type="text" name="cod_ppff" class="form-input" value="${ppff.cod_ppff}" placeholder="Escriba su código"required>

                <label for="" class="form-label">Carnet:</label>
                <input type="text" name="ci" class="form-input" value="${ppff.ci}" placeholder="Escriba su cédula de identidad"required>

                <label for="" class="form-label">Nombre:</label>
                <input type="text" name="nombre" class="form-input" value="${ppff.nombre}" placeholder="Escriba su nombre"required>

                <label for="" class="form-label">Apellidos:</label>
                <input type="text" name="apellidos" class="form-input" value="${ppff.apellidos}" placeholder="Escriba su apellido"required>

                <label for="" class="form-label">Fecha de Nacimiento:</label>
                <input type="date" name="fecha_nacimiento" class="form-input" value="${ppff.fecha_nacimiento}" placeholder="Escriba su fecha de nacimiento"required>

                <label for="" class="form-label">Dirección:</label>
                <input type="text" name="direccion" class="form-input" value="${ppff.direccion}" placeholder="Escriba su dirección"required>

                <label for="" class="form-label">Tipo Pariente:</label>

                <select name="tipo_pariente" class="form-input" required>
                    <option value="" required>--Seleccione--</option>

                    <option value="PADRE" <c:if test="${ppff.tipo_pariente == 'PADRE'}">
                            selected
                        </c:if>
                        >PADRE</option>
                    <option value="MADRE" <c:if test="${ppff.tipo_pariente == 'MADRE'}">
                            selected
                        </c:if>
                        >MADRE</option>
                    <option value="TUTOR" <c:if test="${ppff.tipo_pariente == 'TUTOR'}">
                            selected
                        </c:if>
                        >TUTOR</option>
                    <option value="HERMANO/A" <c:if test="${ppff.tipo_pariente == 'HERMANO/A'}">
                            selected
                        </c:if>
                        >HERMANO/A</option>
                </select>

                <label for="" class="form-label">Telefono:</label>
                <input type="text" name="telefono" class="form-input" value="${ppff.telefono}" placeholder="Escriba su telefono"required>

                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>
