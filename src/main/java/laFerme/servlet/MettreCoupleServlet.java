/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
import laFerme.entity.EtatEnumeration;
import laFerme.entity.Personnage;
import laFerme.entity.ble;
import laFerme.enumeration.EtatChevreEnumeration;
import laFerme.service.BleService;
import laFerme.service.CarotteService;
import laFerme.service.ChevreMethodes;
import laFerme.service.ChevreService;
import laFerme.service.ConfigService;
import laFerme.service.Initialiser;
import laFerme.service.PersonnageService;
import laFerme.service.RessourceService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "MettreCoupleServlet", urlPatterns = {"/mettreCoupleServlet"})
public class MettreCoupleServlet extends AutowireServlet {


    @Autowired
    ChevreMethodes chevreMethodes;
    @Autowired
    Initialiser init;
    @Autowired
    ConfigService configService;
    @Autowired
    CarotteService carotteService;
    @Autowired
    BleService bleService;
    @Autowired
    ConfigService config;
    @Autowired
    PersonnageService personnageService;
    @Autowired
    RessourceService ressourceService;
    @Autowired
    ChevreService chevreService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("idPersonnage"));
        int nbre = Integer.parseInt(req.getParameter("nbCouple"));

        chevreMethodes.AccouplementChevre(id, nbre);

        Personnage p = personnageService.findOne(id);

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

    }

}
