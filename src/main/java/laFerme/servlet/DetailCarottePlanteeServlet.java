/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
import laFerme.entity.EtatEnumeration;
import laFerme.entity.Personnage;
import laFerme.entity.Utilisateur;
import laFerme.enumeration.EtatChevreEnumeration;
import laFerme.service.CarotteService;
import laFerme.service.ChevreService;
import laFerme.service.ConfigService;
import laFerme.service.PersonnageService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "DetailCarottePlanteeServlet", urlPatterns = {"/DetailCarottePlanteeServlet"})
public class DetailCarottePlanteeServlet extends AutowireServlet {

    @Autowired
    ConfigService config;

    @Autowired
    PersonnageService personnageService;

    @Autowired
    CarotteService carotteService;
    
    @Autowired
    ChevreService chevreService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("valeur", "4");
        req.setAttribute("titre", "Etat de vos plantations");
        Utilisateur u = config.recupererUtilisateur(req);
        Long id = Long.parseLong(req.getParameter("idPersonnage"));
        Personnage p = personnageService.findOne(id);

        List<Chevre> mesChevresDispo = chevreService.findAllByEtatAndPersonnageId(EtatChevreEnumeration.DISPONIBLE, p.getId());
        Integer nb = mesChevresDispo.size() / 2;
        req.setAttribute("nbCouple", nb);

        List<Carotte> listeCarottePlante = carotteService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, id);
        req.setAttribute("carottePlante", listeCarottePlante);
        req.getRequestDispatcher("passerparacceuil").include(req, resp);
    }
}
