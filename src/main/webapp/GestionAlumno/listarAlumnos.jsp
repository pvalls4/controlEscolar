<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Alumnos</title>
        <link rel="stylesheet" href="./css/styles.css" type="text/css"/>
    </head>
    <body class="body">
        <h1 class="title">Listado de alumnos:</h1>        
        <c:if test="${not empty listaAlumnos}">
            <ul class="list">
                <c:forEach items="${listaAlumnos}" var="alumno">
                    <li>${alumno.nombre} ${alumno.apellido} / ${alumno.email} / ${alumno.idCarrera}</li> <!-- Suponiendo que "nombre" es un atributo de la clase Carrera -->
                    </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty listaAlumnos}">
            <p>No hay alumnos disponibles.</p>
        </c:if>
    </body>
</html>
