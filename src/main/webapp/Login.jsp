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

        <%--<c:import url="_CSS.jsp"/>--%>
    </head>
    <body>
        <h1>Bienvenu, merci de vous identifier</h1>
        
        <form method="post" action="LoginServlet">
            
            Login : <input name="login" type="text"/>
            Mot de passe :    <input name="mdp" type="password"/><br><br>
            <input type="Submit">
        </form>
        <FONT color="red"> ${mdpincorect}</FONT><br><br>
            
    </body>
    <c:import url="_PIED.jsp"/>
</html>
