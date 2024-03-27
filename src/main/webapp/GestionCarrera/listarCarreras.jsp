<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Carreras</title>
        <link rel="stylesheet" href="./css/styles.css" type="text/css"/>
    </head>
    <body class="body">
        <h1 class="title">LISTADO DE CARRERAS</h1>        
        <c:if test="${not empty listaCarreras}">    
            <ul class="list">
                <c:forEach items="${listaCarreras}" var="carrera">
                    <li>
                        <table>
                            <tr>
                                <th id="mayus">${carrera.nombre}</th>
                                <td style="padding-left: 40px">
                                    <form action="modificarCarrera" method="get">
                                        <input class="button" type="submit" value="Modificar"/>
                                    </form>
                                </td>
                                <td>
                                    <form action="eliminarCarrera" method="get">
                                        <input class="button" type="submit" value="Eliminar"/>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </li>

                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty listaCarreras}">
            <p>No hay carreras disponibles.</p>
        </c:if>
    </body>
</html>
