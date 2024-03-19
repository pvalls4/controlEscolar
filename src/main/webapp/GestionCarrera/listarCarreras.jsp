<%-- 
    Document   : listarCarrera
    Created on : 18 mar 2024, 13:42:38
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
        <h1>Listado de carreras:</h1>
        <ol>
            <%
                ArrayList<String> listaCarreras = (ArrayList<String>)request.getAttribute("listaCarreras");
                for (String carrera : listaCarreras) {
            %>
                <li><%= carrera %></li>
            <% } %>
        </ol>
    </body>
</html>
