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
        <h1 class="title">Modificar Carrera ${carrera.nombre}:</h1>
        <form method="post">
            <br>
            <input type="hidden" name="idCarrera" value="${carrera.id}">
            <input type="text" name="nuevoNombre" value="${carrera.nombre}" required/>
            <br>
            <input type="submit" value="Enviar">
        </form>

    </body>
</html>
