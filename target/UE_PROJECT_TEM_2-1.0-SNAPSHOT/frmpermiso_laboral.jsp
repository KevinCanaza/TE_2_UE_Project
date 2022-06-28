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
        <title>Formulario de Permisos</title>
    </head>

    <body style="background-image: url(img/fnd3.jpg)">
        
        <div class="contenedor">
            <form action="PermisoLaboralControlador" method="post" class="form">
                <input type="hidden" value="${permiso.cod_permiso}"/>
                <input type="hidden" name="action" 
                       <c:if test="${permiso.cod_doc!=null}"> value="edit2"</c:if>
                       <c:if test="${permiso.cod_admi!=null}"> value="edit" </c:if>
                       <c:if test="${action=='add'}"> value="add"</c:if> 
                       <c:if test="${action=='add2'}"> value="add2"</c:if> />
                
                       <div class="form-header">
                           <h1 class="form-title">P<span>ermiso</span> L<span>aboral</span></h1>
                       </div>
                       <label for="cod_permiso" class="form-label">Código:</label>
                       <input type="text" name="cod_permiso" class="form-input" value="${permiso.cod_permiso}" placeholder="Escriba su código"required>

                <label for="descripcion" class="form-label">Descripción:</label>
                <input type="text" name="descripcion" class="form-input" value="${permiso.descripcion}" placeholder="Escriba la descripción"required>

                <label for="fecha" class="form-label">Fecha:</label>
                <input type="date" name="fecha" class="form-input" value="${permiso.fecha}" placeholder="Escriba la fecha actual"required>

                <label for="fecha_inicio" class="form-label">Fecha inicio:</label>
                <input type="date" name="fecha_inicio" class="form-input" value="${permiso.fecha_inicio}" placeholder="Escriba la fecha de inicio del permiso"required>

                <label for="fecha_final" class="form-label">Fecha de conclusión del permiso:</label>
                <input type="date" name="fecha_final" class="form-input" value="${permiso.fecha_final}" placeholder="Escriba la fecha de conclusión del permiso"required>

                <label for="cod_doc" 
                       <c:if test="${action=='add'}"> style="visibility: hidden"</c:if>
                       <c:if test="${permiso.cod_admi!=null}"> style="visibility: hidden"</c:if>
                           class="form-label">Docente</label>

                       <select name="cod_doc" 
                       <c:if test="${action=='add'}"> style="visibility: hidden"</c:if> 
                       <c:if test="${permiso.cod_admi!=null}"> style="visibility: hidden"</c:if>
                           class="form-input">
                           <option value="">--Seleccione--</option>
                       <c:forEach var="item" items="${lista_docentes}">
                           <option value="${item.cod_doc}"
                                   <c:if test="${permiso.cod_doc == item.cod_doc}">
                                       selected
                                   </c:if>
                                   >${item.nombre}${' '}${item.apellidos}</option>
                       </c:forEach>
                </select>

                <label for="cod_admi" 
                       <c:if test="${action=='add2'}"> style="visibility: hidden"</c:if> 
                       <c:if test="${permiso.cod_doc!=null}"> style="visibility: hidden"</c:if>
                           class="form-label">Personal Administrativo</label>
                       <select name="cod_admi"
                       <c:if test="${action=='add2'}"> style="visibility: hidden"</c:if> 
                       <c:if test="${permiso.cod_doc!=null}"> style="visibility: hidden"</c:if>
                           class="form-input">
                           <option value='null'>--Seleccione--</option>
                       <c:forEach var="item" items="${lista_personal}">
                           <option value="${item.cod_admi}"
                                   <c:if test="${permiso.cod_admi == item.cod_admi}">
                                       selected
                                   </c:if>
                                   >${item.nombre}${' '}${item.apellidos}</option>
                       </c:forEach>
                </select>

                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="volver atrás"></th>
                </table>   
            </form>
        </div>
    </body>

</html>
