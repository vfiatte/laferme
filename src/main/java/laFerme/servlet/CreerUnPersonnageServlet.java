/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laFerme.entity.Utilisateur;
import laFerme.service.ConfigService;
import laFerme.service.Initialiser;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "CreerUnPersonnageServlet", urlPatterns = {"/creerunpersonnage"})
public class CreerUnPersonnageServlet extends AutowireServlet {
    
    @Autowired
    Initialiser init;
    @Autowired
    ConfigService configService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Utilisateur u = configService.recupererUtilisateur(req);

        String nom = req.getParameter("nom");
        init.CreationInitialisation(u, nom);
        req.setAttribute("MonPersonnage", u.getListepersonnages().get(0));
        req.getRequestDispatcher("PageAccueilDeMonPersonnage.jsp").include(req, resp);
        
        

    }
    
    

}
