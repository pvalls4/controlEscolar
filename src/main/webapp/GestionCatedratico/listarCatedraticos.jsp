<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de catedráticos:</h1>        
        <c:if test="${not empty listaCatedraticos}">
            <ul>
                <c:forEach items="${listaCatedraticos}" var="catedratico">
                    <li>${catedratico.nombre}</li> <!-- Suponiendo que "nombre" es un atributo de la clase Carrera -->
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty listaCatedraticoss}">
            <p>No hay catedráticoss disponibles.</p>
        </c:if>
    </body>
</html>
