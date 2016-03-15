<%-- 
    Document   : PageAccueilDeMonPersonnage
    Created on : 15 mars 2016, 14:09:12
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
            <h1> A vous de jouer ! </h1>
            <table>
                <tr>
                    <td>
                        ${MonPersonnage.nom}<br>
                         ${MonPersonnage.nbDePoints}
                    </td>
                </tr>
                <tr>
                    <td>
                        Ressources non utilisees :<br>
                        Carottes : ${MonPersonnage.ressource.ressourceCarotte} <br>
                        Bles :  ${MonPersonnage.ressource.ressourceBle} <br>
                        Fromages : ${MonPersonnage.ressource.ressourceFromage}<br>
                        Chevres : ${MonPersonnage.ressource.ressourceChevre}

                    </td>
                </tr>
                <tr>
                    <td>
                        Ressources en cours : <br>
                        Carottes plantees :${mesCarottesPlantees}<br>
                        Bles plantes : ${mesBlesPlantes}<br>
                        

                    </td>
                </tr>
            </table>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
