<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Carrera</title>
        <link rel="stylesheet" href="./css/styles.css" type="text/css"/>
    </head>
    <body class='body'>
        <h1 class='title'>Eliminar Carrera:</h1>
        <form method="post">
            <!--            <select name="idCarrera">
            <c:if test="${not empty listaCarreras}">
                <c:forEach items="${listaCarreras}" var="carrera">
                    <option value="${carrera.id}">${carrera.id}. ${carrera.nombre}</option>  Suponiendo que "nombre" es un atributo de la clase Carrera 
                </c:forEach>
            </c:if>
            <c:if test="${empty listaCarreras}">
                <option>No hay carreras disponibles.</option>
            </c:if>
        </select>-->
            <h2>¿Estás seguro de borrar esta Carrera?</h2>
            <br>
            <input type="submit" value="Sí">
            <input type="submit" value="No">
        </form>
        
    </body>
</html>

