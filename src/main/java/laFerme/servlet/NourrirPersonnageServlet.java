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
import laFerme.entity.Fromage;
import laFerme.entity.Personnage;
import laFerme.entity.Utilisateur;
import laFerme.entity.ble;
import laFerme.service.BleService;
import laFerme.service.CarotteService;
import laFerme.service.ConfigService;
import laFerme.service.NourrirPersonnage;
import laFerme.service.PersonnageService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "NourrirPersonnageServlet", urlPatterns = {"/nourirPersonnageServlet"})
public class NourrirPersonnageServlet extends AutowireServlet {

    @Autowired
    NourrirPersonnage nourrirPersonnage;
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
        String c = req.getParameter("typeNourriture");
        config.calculPoints(p);
        
        if (c.equals("carotte")) {
            nourrirPersonnage.nourrirFermier(p, Carotte.class);
            System.out.println("je mange des carottes");
        }
        if (c.equals("ble")) {
            nourrirPersonnage.nourrirFermier(p, ble.class);
        }
        if (c.equals("fromage")) {
            nourrirPersonnage.nourrirFermier(p, Fromage.class);
        }
        if (c.equals("chevre")) {
            nourrirPersonnage.nourrirFermier(p, Chevre.class);
        }
        req.setAttribute("monPersonnage", p);

        List<Carotte> mesCarottes = carotteService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
        List<ble> mesBles = bleService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
        req.setAttribute("mesCarottesPlantees", mesCarottes.size());
        req.setAttribute("mesBlesPlantes", mesBles.size());

        req.getRequestDispatcher("PageAccueilDeMonPersonnage.jsp").include(req, resp);
//        req.getRequestDispatcher("passerparacceuil").include(req, resp);
    }

}
