<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modidicar Carrera</title>
        <link rel="stylesheet" href="./css/styles.css" type="text/css"/>
    </head>
    <body class="body">
        <h1 class="title">Modificar Carrera:</h1>
        <form method="post">
            <!--            <select name="idCarrera">
            <c:if test="${not empty listaCarreras}">
                <c:forEach items="${listaCarreras}" var="carrera">
                    <option value="${carrera.id}">${carrera.id}. ${carrera.nombre}</option>
                </c:forEach>
            </c:if>
            <c:if test="${empty listaCarreras}">
                <option>No hay carreras disponibles.</option>
            </c:if>
        </select>-->
            
            <br>
            <!--<label>Nuevo nombre de la Carrera:</label>-->
            <input type="text" name="nuevoNombre" value="Nuevo nombre" required/>
            <br>
            <input type="submit" value="Enviar">
        </form>

    </body>
</html>
