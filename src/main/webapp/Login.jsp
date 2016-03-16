<%-- 
    Document   : Login
    Created on : 9 mars 2016, 16:19:37
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <c:import url="_CSS.jsp"/>
    </head>
    <body>
        <h1 class="titre">Bienvenu, merci de vous identifier</h1>
        <div class="centrertableau">


            <form method="post" action="LoginServlet">
                <table>
                    <tr>
                        <td>
                            Login :
                        </td>
                        <td>
                            <input name="login" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Mot de passe :
                        </td>
                        <td>
                            <input name="mdp" type="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="Submit">
                        </td>
                    </tr>
                </table>
            </form>
            <FONT color="red"> ${mdpincorect}</FONT><br><br>
        </div>
    </body>
    <c:import url="_PIED.jsp"/>
</html>
