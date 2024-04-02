<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Carrera</title>
        <link rel="stylesheet" href="./css/styles.css" type="text/css"/>
    </head>
    <body class="body">
        <h1 class="title">¿Eliminar Carrera ${carrera.nombre}?:</h1>
        <div>
            <form method="post">
                <input type="hidden" name="idCarrera" value="${carrera.id}">
                <input type="submit" value="Sí, eliminar">
            </form>
            <form method="post">
                <input type="hidden" name="idCarrera" value="-1">
                <input type="submit" value="¡No!">
            </form>
        </div>
        
    </body>
</html>

