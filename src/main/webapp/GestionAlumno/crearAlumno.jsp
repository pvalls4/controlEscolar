<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Alumnos</title>
        <link rel="stylesheet" href="./css/styles.css" type="text/css"/>
    </head>
    <body class="body">
        <h1 class="title">Crear Alumno</h1>
        <form method="get">
            <!--<label>Nombre</label>-->
            <input type="text" name="nombre" value="Nombre" required />
            <br>
            <!--<label>Apellido</label>-->
            <input type="text" name="apellido" value="Apellido" required/>
            <br>
            <!--<label>E-Mail</label>-->
            <input type="email" name="email" value="Correo electrónico" required/>
            <br>
            <select class="label" name="idCarrera">
                <c:forEach items="${listaCarreras}" var="carrera">
                    <option value="${carrera.id}">${carrera.id}. ${carrera.nombre}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit"/>
        </form>
    </body>
</html>