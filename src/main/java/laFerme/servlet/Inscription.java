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
import laFerme.service.UtilisateurService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjoutUtilisateurServlet", urlPatterns = {"/AjoutUtilisateurServlet"})
public class Inscription extends AutowireServlet {

    @Autowired
    UtilisateurService utilisateurService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String mdp1 = req.getParameter("mdp1");
        String mdp2 = req.getParameter("mdp2");

        Utilisateur loginUtil = utilisateurService.findOneByLogin(login);
        Utilisateur emailUtil = utilisateurService.findOneByEmail(email);

        if (loginUtil == null) {
            if (emailUtil == null) {
                if (mdp1.equals(mdp2)) {
                    Utilisateur u = new Utilisateur();
                    u.setLogin(login);
                    u.setEmail(email);
                    u.setMdp(mdp1);
                    utilisateurService.save(u);
                    resp.sendRedirect("Login.jsp");
                
                } else {
                    req.setAttribute("mdpdifferent", "Les mots de passe ne correspondent pas");
                    req.getRequestDispatcher("Inscription.jsp").include(req, resp);
                }

            } else {
                req.setAttribute("emailExistant", "L email choisi existe deja");
                req.getRequestDispatcher("Inscription.jsp").include(req, resp);
            }
        } else {
            req.setAttribute("loginExistant", "Le login choisi existe deja");
            req.getRequestDispatcher("Inscription.jsp").include(req, resp);

        }

    }
}
