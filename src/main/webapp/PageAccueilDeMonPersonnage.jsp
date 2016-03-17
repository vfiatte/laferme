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
        <script type="text/javascript">
            var task = function(){
            document.location.reload();
            }
            window.setTimeout(task, 1000000);
        </script>
        <title>JSP Page</title>
        <c:import url = "_CSS.jsp"/>
    </head>
    <body>
        <table class="vertical">
            <tr>
                <td></td>
                <td>
                    <div class="titre">Bienvenu dans votre ferme, a vous de jouer, fermier en herbe !</div><br><br>
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
                            <tr>
                        <form method="get" action="ClassementServlet">
                            <td>
                                <input type="hidden" name="idPersonnage" value="${monPersonnage.id}">
                                <button type="submit">Acceder au classement</button>
                            </td>
                        </form>

            </tr>
        </tbody>
    </table>
    <br><br>
    <form method="get" action="BanqueServlet">
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
                <tr>
                    <td>
                        <input type="hidden" name="idPersonnage" value="${monPersonnage.id}">
                        <a href="BanqueServlet"><button>Acceder au marche</button></a>
                </tr>
            </tbody>
        </table>
    </form>
    <br><br>
    <table class="tablegauche">
        <thead>
            <tr>
                <td colspan="3">
                    Mes ressources occupees
                </td>
            </tr>
        </thead>
        <tbody>
        <form method="get" action="DetailBlePlanteServlet">
            <tr>
                <td>
                    <img src="image/icon_epi.png" alt=""/>
                </td>
                <td>
                    ${mesBlesPlantes}
                </td>
                <td>
                    <input type="hidden" name="idPersonnage" value="${monPersonnage.id}">
                    <button type="submit">Details</button>
                </td>
            </tr>
        </form>
        <form method="get" action="DetailCarottePlanteeServlet">
            <tr>
                <td>
                    <img src="image/carrots_24.png" alt=""/>
                </td>
                <td>
                    ${mesCarottesPlantees}
                </td>
                <td>
                    <input type="hidden" name="idPersonnage" value="${monPersonnage.id}">
                    <button type="submit">Details</button>
                </td>
            </tr>
        </form>
    </tbody>
</table>
</td>
<td class="tableMilieu"> 
    <c:choose>
        <c:when test="${valeur==1}">
            <table>
                <thead>
                    <tr>
                        <td>
                            Chevre
                        </td>
                        <td>
                            Etat
                        </td>
                        <td>
                            Derniere nutrition
                        </td>
                        <td>
                            Nourrir ?
                        </td>
                        <td>
                            Mettre en couple
                        </td>

                    </tr>
                </thead>
                <c:forEach items="${mesChevres}" var="maChevre">
                    <tr>
                        <td>
                            Chevre n ${maChevre.id}
                        </td>
                        <td>
                            ${maChevre.etat}
                        </td>
                        <td>
                            ${maChevre.dateManger}
                        </td>
                        <td>
                            <input type="checkbox" name="nourirChevre" value="${maChevre.id}">
                        </td>
                        <td>
                            <input type="checkbox" name="mettreEnCouple" value="${maChevre.id}">
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:when test="${valeur==2}">
            <h2>Vos echanges</h2>
            <form method="post" action="EchangeServlet">
                <table>
                    <tr>
                        <td>
                            Echanger :
                        </td>
                        <td>
                            <select name="quantiteble">
                                <c:forEach var="i" begin="0" end="50">
                                    <option>
                                        ${i}
                                    </option>
                                </c:forEach>
                            </select>
                            <img src="image/icon_epi.png" alt=""/>
                        </td>
                        <td>
                            <select name="quantiteCarotte">
                                <c:forEach var="i" begin="0" end="50">
                                    <option>
                                        ${i}
                                    </option>
                                </c:forEach>
                            </select>
                            <img src="image/carrots_24.png" alt=""/>
                        </td>
                        <td>
                            <select name="quantiteChevre">
                                <c:forEach var="i" begin="0" end="50">
                                    <option>
                                        ${i}
                                    </option>
                                </c:forEach>
                            </select>
                            <img src="image/des-animaux-chevre-icone-8566-128.png" alt=""/>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Contre :
                        </td>
                        <td colspan="3">
                            <select name="contre">
                                <option value="ble">
                                    Ble
                                </option>
                                <option value="carotte">
                                    Carotte
                                </option>
                                <option value="chevre">
                                    Chevre
                                </option>
                            </select>
                        </td>
                    <tr>
                        <td colspan="3">
                            <input type="hidden" name="idPersonnage" value="${monPersonnage.id}">
                            <input type="submit">
                        </td>
                    </tr>

                </table>            
            </form>
        </c:when>
        <c:when test="${valeur==3}">
            <table>
                <thead>
                    <tr>
                        <td>
                            Ble
                        </td>
                        <td>
                            Date de plantation
                        </td>

                    </tr>
                </thead>
                <c:forEach items="${blePlante}" var="monBle">
                    <tr>
                        <td>
                            Ble n ${monBle.id}
                        </td>
                        <td>
                            ${monBle.datePlantation}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:when test="${valeur==4}">
            <table>
                <thead>
                    <tr>
                        <td>
                            Carottes
                        </td>
                        <td>
                            Date de plantation
                        </td>

                    </tr>
                </thead>
                <c:forEach items="${carottePlante}" var="maCarotte">
                    <tr>
                        <td>
                            Carotte n ${maCarotte.id}
                        </td>
                        <td>
                            ${maCarotte.datePlantation}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:when test="${valeur==5}">
            <table>
                <thead>
                    <tr>
                        <td>
                            Nom
                        </td>
                        <td>
                            Nombre de points
                        </td>
                    </tr>
                </thead>
                <c:forEach items="${classement}" var="monPersonnage">
                    <tr>
                        <td>
                            ${monPersonnage.nom}
                        </td>
                        <td>
                            ${monPersonnage.nbDePoints}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
    </c:choose>
</td><br>
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
                        <input type="hidden" name="idPersonnage" value="${monPersonnage.id}">
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
                        <input type="hidden" name="idPersonnage" value="${monPersonnage.id}">
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
                        <label><input type="radio" name="planteRessource" onclick=\"getAnswer('ble')\" value="ble">Ble</label><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><input type="radio" name="planteRessource" onclick=\"getAnswer('carotte')\" value="carotte">Carotte</label><br>
                    </td>
                </tr>
                <tr>
                    <td>Combien ?
                        <select name="quantite">
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
                        <input type="hidden" name="idPersonnage" value="${monPersonnage.id}">
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
