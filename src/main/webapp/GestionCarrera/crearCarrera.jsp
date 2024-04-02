<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear carrera</title>
        <link rel="stylesheet" href="./css/styles.css" type="text/css"/>
    </head>
    <body class="body">
        <h1 class="title">CREAR CARRERA</h1>
        <form method="post" action="crearCarrera">
            <!--<label>Ingrese nueva carrera:</label>-->
            <input placeholder="Nombre" type="text" name="nombre"/>
            <br>
            <input type="submit"/>
        </form>
    </body>
</html>
