<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Alumno</h1>
        <form method="get">
            <label>Nombre</label>
            <input type="text" name="nombre" required/>
            <label>Apellido</label>
            <input type="text" name="apellido" required/>
            <label>E-Mail</label>
            <input type="email" name="email" required/>
            <label>Carrera asignada</label>
            <select name="idCarrera">
                <c:forEach items="${listaCarreras}" var="carrera">
                    <option value="${carrera.id}">${carrera.id}. ${carrera.nombre}</option> <!-- Suponiendo que "nombre" es un atributo de la clase Carrera -->
                </c:forEach>
            </select>
            <input type="submit"/>
        </form>
    </body>
</html>