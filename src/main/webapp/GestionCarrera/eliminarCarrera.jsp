<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Carrera</title>
    </head>
    <body>
        <h1>Eliminar Carrera:</h1>
        <form method="post">
            <select name="idCarrera">
                <c:if test="${not empty listaCarreras}">
                    <c:forEach items="${listaCarreras}" var="carrera">
                        <option value="${carrera.id}">${carrera.id}. ${carrera.nombre}</option> <!-- Suponiendo que "nombre" es un atributo de la clase Carrera -->
                    </c:forEach>
                </c:if>
                <c:if test="${empty listaCarreras}">
                    <option>No hay carreras disponibles.</option>
                </c:if>
            </select>
            <label>Borrar Carrera:</label>
            <input type="submit" value="Enviar">
        </form>
        
    </body>
</html>

