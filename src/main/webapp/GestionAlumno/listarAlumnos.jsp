<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de alumnos:</h1>
        <ol>
            <%
                ArrayList<String> listaAlumnos = (ArrayList<String>)request.getAttribute("listaAlumnos");
                for (String alumno : listaAlumnos) {
            %>
                <li><%= alumno %></li>
            <% } %>
        </ol>
    </body>
</html>
