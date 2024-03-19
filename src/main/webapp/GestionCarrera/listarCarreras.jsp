<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de carreras:</h1>
        
        <c:if test="${not empty listaCarreras}">
            <ul>
                <c:forEach items="${listaCarreras}" var="carrera">
                    <li>${carrera.nombre}</li> <!-- Suponiendo que "nombre" es un atributo de la clase Carrera -->
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty listaCarreras}">
            <p>No hay carreras disponibles.</p>
        </c:if>
    </body>
</html>
