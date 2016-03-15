<%-- 
    Document   : AjoutFilm
    Created on : 8 mars 2016, 14:50:53
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="_CSS.jsp"/>
    </head>
    <c:import url="_TITRE.jsp"/>

    <body>
        <form method="post" action="AjoutUtilisateurServlet">
            <table>
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="login"></td>
                </tr>
                <tr>
                    <td><label>Email</label></td>
                    <td><input type="text" name="email"></textarea></td>
                </tr>
                <tr>
                    <td><label>Mot de passe</label></td>
                    <td><input name="mdp1" type="password">
                </tr>
                <tr>
                    <td><label>Mot de passe</label></td>
                    <td><input name="mdp2" type="password">
                </tr>



                <tr>
                    <td colspan="2"><input type="Submit"></td>
                </tr>
            </table>
        </form>
        <c:import url="_PIED.jsp"/>
    </body>

</html>
