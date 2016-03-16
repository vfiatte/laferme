<%-- 
    Document   : CreationPersonnage
    Created on : 15 mars 2016, 12:10:52
    Author     : admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Streaming</title>
        <c:import url="_CSS.jsp"/>
    </head>
    <body>
        <c:import url="_TITRE.jsp"/> 
        <c:import url="_MENU.jsp"/>
        <div class="contenu">
            <h1>Creer Votre Personnage : </h1>
            <form method="post" action="creerunpersonnage">
                <input type="text" name="nom"/>
                <input type="submit">
            </form>
            ${personnage}
            <c:forEach items="${mesPersonnage}" var="monPersonnage">
                <table>
                    <tr>
                        <td>
                            ${monPersonnage.nom}
                            
                        </td>
                        <td>
                            <a href="passerparacceuil?idPersonnage=${monPersonnage.id}">Aller a sa ferme</a>
                        </td>
                    </tr>
                </table>
            </c:forEach>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>