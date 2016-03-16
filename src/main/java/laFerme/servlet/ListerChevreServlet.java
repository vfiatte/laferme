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
import laFerme.entity.Chevre;
import laFerme.entity.Personnage;
import laFerme.entity.Utilisateur;
import laFerme.service.ChevreService;
import laFerme.service.ConfigService;
import laFerme.service.PersonnageService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListerChevreServlet", urlPatterns = {"/ListerChevreServlet"})
public class ListerChevreServlet extends AutowireServlet {

    @Autowired
    ChevreService chevreService;
    @Autowired
    PersonnageService personnageService;
    @Autowired
    ConfigService config;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = config.recupererUtilisateur(req);
        Long id = Long.parseLong(req.getParameter("idPersonnage"));
        Personnage p = personnageService.findOne(id);
        req.setAttribute("valeur", "1");
        List<Chevre> listeChevres = (List<Chevre>) p.getListeChevre();
        req.setAttribute("titre", "Votre troupeau de chevres");
        req.setAttribute("mesChevres", listeChevres);
        req.getRequestDispatcher("passerparacceuil").include(req, resp);
    }

}
