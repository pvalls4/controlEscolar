<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <input type="text" name="nombre"/>
            <label>Apellido</label>
            <input type="text" name="apellido"/>
            <label>E-Mail</label>
            <input type="text" name="email"/>
            <label>Carrera asignada</label>
            <select name="carrera">
                <option value="carrera1">Carrera1</option>
                <option value="carrera2">Carrera2</option>
                <option value="carrera3">Carrera3</option>
            </select>
            <input type="submit"/>
        </form>
    </body>
</html>