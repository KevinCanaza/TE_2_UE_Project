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

        <title>Formulario de inscripciones</title>
    </head>
        <body style="background-image: url(img/fnd3.jpg)">
        <div class="contenedor">
            <br>
            <form action="InscripcionController" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" value="${inscripcion.cod_inscripcion}"/>
                <div class="form-header">
                    <h1 class="form-title">I<span>nscripcion</span></h1>
                </div>
                
                <label for="" class="form-label">Codigo:</label>
                <input type="text" name="cod_inscripcion" class="form-input" value="${inscripcion.cod_inscripcion}" placeholder="Escriba el código"required>

                <label for="" class="form-label">Estudiante</label>
                <select name="rude1" class="form-input" required>
                    <option value=""> --Seleccione-- </option>
                    <c:forEach var="item" items="${lista_estudiante}">
                        <option value="${item.rude}"
                                <c:if test="${inscripcion.rude1 == item.rude}">
                                    selected
                                </c:if>
                        >${item.nombre} ${' '} ${item.apellidos}</option>
                    </c:forEach>
                </select>
               
                <label for="" class="form-label">Grado</label>
                <select name="cod_grado1" class="form-input" required>
                    <option value=""> --Seleccione-- </option>
                    <c:forEach var="item" items="${lista_grado}">
                        <option value="${item.cod_grado}"
                                <c:if test="${inscripcion.cod_grado1 == item.cod_grado}">
                                    selected
                                </c:if>
                        >${item.descripcion}</option>
                    </c:forEach>
                </select>

                <label for="" class="form-label">Turno</label>
                <select name="cod_turno" class="form-input" required>
                    <option value=""> --Seleccione-- </option>
                    <c:forEach var="item" items="${lista_turno}">
                        <option value="${item.cod_turno}"
                                <c:if test="${inscripcion.cod_turno == item.cod_turno}">
                                    selected
                                </c:if>
                        >${item.turno}</option>
                    </c:forEach>
                </select>
                
                <label for="" class="form-label">Fecha:</label>
                <input type="date" name="fecha" class="form-input" value="${inscripcion.fecha}"required>
                
                <label for="" class="form-label">Tipo Inscripcion:</label>
                <select name="tipo_inscripcion" class="form-input" required>
                    <option value="" required>--Seleccione--</option>

                    <option value="NUEVO" <c:if test="${inscripcion.tipo_inscripcion == 'NUEVO'}">
                            selected
                        </c:if>
                        >NUEVO</option>
                    <option value="ANTIGUO" <c:if test="${inscripcion.tipo_inscripcion == 'ANTIGUO'}">
                            selected
                        </c:if>
                        >ANTIGUO</option>
                    <option value="TRANSPASO" <c:if test="${inscripcion.tipo_inscripcion == 'TRANSPASO'}">
                            selected
                        </c:if>
                        >TRANSPASO</option>
                </select>


                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>

