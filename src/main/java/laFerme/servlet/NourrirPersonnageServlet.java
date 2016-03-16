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
import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
import laFerme.entity.Fromage;
import laFerme.entity.Utilisateur;
import laFerme.entity.ble;
import laFerme.service.ConfigService;
import laFerme.service.NourrirPersonnage;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utilisateur u = config.recupererUtilisateur(req);

        String c = req.getParameter("typeNourriture");
        if (c.equals("carotte")) {
            nourrirPersonnage.nourrirFermier(u.getListepersonnages().get(0), Carotte.class);
        }
        if (c.equals("ble")) {
            nourrirPersonnage.nourrirFermier(u.getListepersonnages().get(0), ble.class);
        }
        if (c.equals("fromage")) {
            nourrirPersonnage.nourrirFermier(u.getListepersonnages().get(0), Fromage.class);
        }
        if (c.equals("chevre")) {
            nourrirPersonnage.nourrirFermier(u.getListepersonnages().get(0), Chevre.class);
        }
        
        resp.sendRedirect("creerunpersonnage");
    }

}
