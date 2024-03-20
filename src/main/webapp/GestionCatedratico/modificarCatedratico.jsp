<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar catedrático:</h1>
        <form method="post">
            <select name="idCatedratico">
                <c:if test="${not empty listaCatedraticos}">
                    <c:forEach items="${listaCatedraticos}" var="catedratico">
                        <option value="${catedratico.id}">${catedratico.id}. ${catedratico.nombre}</option> <!-- Suponiendo que "nombre" es un atributo de la clase Carrera -->
                    </c:forEach>
                </c:if>
                <c:if test="${empty listaCatedraticos}">
                    <option>No hay catedráticos disponibles.</option>
                </c:if>
            </select>
            <label>Nuevo nombre del Catedrático:</label>
            <input typu="text" name="nuevoNombre" required/>
            <input type="submit" value="Enviar">
        </form>
        
    </body>
</html>
