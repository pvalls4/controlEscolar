<%-- 
    Document   : modificarCarrera
    Created on : 18 mar 2024, 13:43:04
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar carrera:</h1>
        <form method="get">
            <select name="antiguoNombre">
                <option value="carrera11">Carrera1</option>
                <option value="carrera21">Carrera2</option>
                <option value="carrera31">Carrera3</option>
            </select>
            <label>Nuevo nombre de la Carrera:</label>
            <input typu="text" name="nuevoNombre"/>
            <input type="submit" value="Enviar">
        </form>
        
    </body>
</html>
