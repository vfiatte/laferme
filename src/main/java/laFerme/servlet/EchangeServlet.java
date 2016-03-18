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
import laFerme.entity.ble;
import laFerme.enumeration.EtatChevreEnumeration;
import laFerme.service.BanqueEchangeService;
import laFerme.service.BleService;
import laFerme.service.CarotteService;
import laFerme.service.ChevreService;
import laFerme.service.ConfigService;
import laFerme.service.PersonnageService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "EchangeServlet", urlPatterns = {"/EchangeServlet"})
public class EchangeServlet extends AutowireServlet {

    @Autowired
    ConfigService config;

    @Autowired
    PersonnageService personnageService;

    @Autowired
    CarotteService carotteService;

    @Autowired
    BleService bleService;

    @Autowired
    ChevreService chevreService;

    @Autowired
    BanqueEchangeService banque;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = config.recupererUtilisateur(req);
        Long id = Long.parseLong(req.getParameter("idPersonnage"));
        Personnage p = personnageService.findOne(id);
        List<ble> listeble = p.getListeble();

//        Long qteble = Long.parseLong(req.getParameter("quantiteble"));
//        Long qteCarotte = Long.parseLong(req.getParameter("quantiteCarotte"));
//        Long qteChevre = Long.parseLong(req.getParameter("quantiteChevre"));
        Integer qteble = Integer.parseInt(req.getParameter("quantiteble"));
        Integer qteCarotte = Integer.parseInt(req.getParameter("quantiteCarotte"));
        Integer qteChevre = Integer.parseInt(req.getParameter("quantiteChevre"));
        String echangeContre = req.getParameter("contre");

        if (echangeContre.equals("chevre")) {
            banque.echange(p, Chevre.class, qteChevre, qteble, qteCarotte);
        } else if (echangeContre.equals("ble")) {
            banque.echange(p, ble.class, qteChevre, qteble, qteCarotte);
        } else if (echangeContre.equals("carotte")) {
            banque.echange(p, Carotte.class, qteChevre, qteble, qteCarotte);
        }

        personnageService.save(p);
        config.calculPoints(p);
        req.setAttribute("monPersonnage", p);

        List<Chevre> mesChevresDispo = chevreService.findAllByEtatAndPersonnageId(EtatChevreEnumeration.DISPONIBLE, p.getId());
        Integer nb = mesChevresDispo.size() / 2;
        req.setAttribute("nbCouple", nb);

        List<Carotte> mesCarottes = carotteService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
        List<ble> mesBles = bleService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
        req.setAttribute("mesCarottesPlantees", mesCarottes.size());
        req.setAttribute("mesBlesPlantes", mesBles.size());

        req.getRequestDispatcher("PageAccueilDeMonPersonnage.jsp").include(req, resp);

//        req.getRequestDispatcher("passerparacceuil").include(req, resp);
    }

}
