/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laFerme.entity.Utilisateur;
import laFerme.service.ConfigService;
import laFerme.service.UtilisateurService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends AutowireServlet {

    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    ConfigService config;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");

        Utilisateur util = utilisateurService.findOneByLogin(login);

        if (util == null) {
            req.getRequestDispatcher("Inscription.jsp").include(req, resp);
        } else if ((util.getMdp().equals(mdp))) {
            req.getSession().setAttribute("user", req.getParameter("login"));
            req.getSession().setAttribute("userMdp", req.getParameter("mdp"));
            Utilisateur u = config.recupererUtilisateur(req);
            if (u.getListepersonnages().size()>0) {
                req.setAttribute("personnage", u.getListepersonnages().get(0).getId());
            } else {
                req.setAttribute("personnage", "pasDePersonnage");
            }
            req.getRequestDispatcher("CreationPersonnage.jsp").include(req, resp);
//            resp.sendRedirect("CreationPersonnage.jsp");
//

        }
    }
}
