/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import laFerme.service.BleService;
import laFerme.service.CarotteService;
import laFerme.service.ChevreService;
import laFerme.service.ConfigService;
import laFerme.service.PersonnageService;
import laFerme.service.UtilisateurService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "ClassementServlet", urlPatterns = {"/ClassementServlet"})
public class ClassementServlet extends AutowireServlet {

    @Autowired
    PersonnageService personnageService;

    @Autowired
    ConfigService config;

    @Autowired
    CarotteService carotteService;

    @Autowired
    BleService bleService;

    @Autowired
    ChevreService chevreService;
    
    @Autowired
    UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = config.recupererUtilisateur(req);
        Long id = Long.parseLong(req.getParameter("idPersonnage"));
        Personnage p = personnageService.findOne(id);

        config.calculPoints(p);
        req.setAttribute("monPersonnage", p);

        List<Carotte> mesCarottes = carotteService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
        List<ble> mesBles = bleService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
        req.setAttribute("mesCarottesPlantees", mesCarottes.size());
        req.setAttribute("mesBlesPlantes", mesBles.size());

        List<Chevre> mesChevresDispo = chevreService.findAllByEtatAndPersonnageId(EtatChevreEnumeration.DISPONIBLE, p.getId());
        Integer nb = mesChevresDispo.size() / 2;
        req.setAttribute("nbCouple", nb);
        
        config.classementUtilisateurs(u);
        List<Utilisateur> listeUtil = (List<Utilisateur>) utilisateurService.findAll();
        int j = listeUtil.size();
        
        List<Integer> listeNb = new ArrayList<>();
        for (int i = 1; i<=j; i++){
            listeNb.add(i);
        }
        
        req.setAttribute("nbClass", listeNb.size());
        req.setAttribute("valeur", "5");
        req.setAttribute("titre", "Classement");
        List<Utilisateur> listeUtilisateur = utilisateurService.findAllByOrderByPtsTotalDesc();
        req.setAttribute("classement", listeUtilisateur);
        
        req.getRequestDispatcher("PageAccueilDeMonPersonnage.jsp").include(req, resp);
    }

}
