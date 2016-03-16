<%-- 
    Document   : PagePrincipale
    Created on : 15 mars 2016, 18:29:03
    Author     : Valentin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url = "_CSS.jsp"/>
    </head>
    <body>
        <table class="vertical">
            <tr>
                <td></td>
                <td>
                    <div class="titre">Bienvenu dans votre ferme, à vous de jouer, fermier en herbe !</div><br><br>
                </td> 
                <td></td>
            </tr>

            <tr>
                <td>
                    <table class="tablegauche">
                        <thead>
                            <tr>
                                <td colspan="2">
                                    <img  src="image/fermier.png" alt=""/>
                                    ${monPersonnage.nom}
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    Points : 
                                </td>
                                <td>
                                    ${monPersonnage.nbDePoints}
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br><br>
                    <table class="tablegauche">
                        <thead>
                            <tr>
                                <td colspan="2">
                                    Mes ressources disponibles
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <img src="image/icon_epi.png" alt=""/>
                                </td>
                                <td>
                                    ${monPersonnage.ressource.ressourceBle}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="image/carrots_24.png" alt=""/>
                                </td>
                                <td>
                                    ${monPersonnage.ressource.ressourceCarotte}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="image/cheese.png" alt=""/>
                                </td>
                                <td>
                                    ${monPersonnage.ressource.ressourceFromage}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="image/des-animaux-chevre-icone-8566-128.png" alt=""/>
                                </td>
                                <td>
                                    ${monPersonnage.ressource.ressourceChevre}
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <br><br>
                    <table class="tablegauche">
                        <thead>
                            <tr>
                                <td colspan="2">
                                    Mes ressources occupées
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <img src="image/icon_epi.png" alt=""/>
                                </td>
                                <td>
                                    ${mesBlePlantes}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="image/carrots_24.png" alt=""/>
                                </td>
                                <td>
                                    ${mesCarottesPlantees}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="image/cheese.png" alt=""/>
                                </td>
                                <td>
                                    ressource.fromage
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </td>
                <td class="tableaucentrale"> 
                    <c:choose>
                        <c:when test="${valeur==1}">
                            <table>
                                <c:forEach items="mesChevres" var="maChevre">
                                    <tr>
                                        <td>
                                            Chevre n°
                                        </td>
                                        <td>
                                            Date manger
                                        </td>
                                        <td>
                                            Etat
                                        </td>
                                        <td>
                                            <input type="radio" name="nourirChevre" value="nourir">
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:when>
                    </c:choose>
                </td>==============================================================================
                <td>
                    <form method="post" action="nourirPersonnageServlet">
                        <table class="tabledroite">
                            <thead>
                                <tr>
                                    <td colspan="3">
                                        Nourrir ${monPersonnage.nom}
                                    </td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <label><input type="radio" name="typeNourriture" onclick=\"getAnswer('ble')\" value="ble">Ble (x3)</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><input type="radio" name="typeNourriture" onclick=\"getAnswer('carotte')\" value="carotte">Carotte (x2)</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><input type="radio" name="typeNourriture" onclick=\"getAnswer('fromage')\" value="fromage">Fromage (x2)</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><input type="radio" name="typeNourriture" onclick=\"getAnswer('chevre')\" value="chevre">Chevre (x1)</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                        <input type="submit">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <br><br>

                    <form method="get" action="ListerChevreServlet">
                        <table class="tabledroite">
                            <thead>
                                <tr>
                                    <td>
                                        Vos chevres
                                    </td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <input type="submit">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <br><br>
                    <form method="post" action="planterRessourcesServlet">
                        <table class="tabledroite">
                            <thead>
                                <tr>
                                    <td colspan="3">
                                        Travaillez la terre !
                                    </td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td colspan="2">
                                        Quelles ressources souhaitez vous planter ?<br>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><input type="radio" name="planteRessource" value="ble">Ble</label><br>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><input type="radio" name="planteRessource" value="carotte">Carotte</label><br>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Combien ?
                                        <select>
                                            <c:forEach var="i" begin="1" end="50">
                                                <option>
                                                    ${i}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>


                                <tr>
                                    <td colspan="2">
                                        <input type="submit">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
