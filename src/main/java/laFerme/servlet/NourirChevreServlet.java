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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laFerme.entity.Carotte;
import laFerme.entity.EtatEnumeration;
import laFerme.entity.Personnage;
import laFerme.entity.Utilisateur;
import laFerme.entity.ble;
import laFerme.service.BleService;
import laFerme.service.CarotteService;
import laFerme.service.ChevreService;
import laFerme.service.ConfigService;
import laFerme.service.NourrirChevreService;
import laFerme.service.PersonnageService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "NourirChevreServlet", urlPatterns = {"/NourirChevreServlet"})
public class NourirChevreServlet extends AutowireServlet{

    @Autowired
    ChevreService chevreService;

    @Autowired
    NourrirChevreService nourrirChevreService;

    @Autowired
    ConfigService config;

    @Autowired
    PersonnageService personnageService;

    @Autowired
    CarotteService carotteService;

    @Autowired
    BleService bleService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utilisateur u = config.recupererUtilisateur(req);
        Long id = Long.parseLong(req.getParameter("idPersonnage"));
        Personnage p = personnageService.findOne(id);
        String typeNourriture = req.getParameter("typeNourriture");

        String[] chevre = req.getParameterValues("nourirChevre");
        if (chevre != null && chevre.length != 0) {
            for (String c : chevre) {
                Long idchevre = Long.parseLong(c);
                if (typeNourriture.equals("ble")) {
                    nourrirChevreService.nourrirChevre(idchevre, ble.class);
                }
                if (typeNourriture.equals("carotte")) {
                    nourrirChevreService.nourrirChevre(idchevre, Carotte.class);
                }
            }
            
            config.calculPoints(p);
            req.setAttribute("monPersonnage", p);

            List<Carotte> mesCarottes = carotteService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
            List<ble> mesBles = bleService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
            req.setAttribute("mesCarottesPlantees", mesCarottes.size());
            req.setAttribute("mesBlesPlantes", mesBles.size());

            req.getRequestDispatcher("PageAccueilDeMonPersonnage.jsp").include(req, resp);
        }
    }

}
