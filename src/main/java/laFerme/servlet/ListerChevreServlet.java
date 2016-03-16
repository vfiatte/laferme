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
import laFerme.service.ChevreService;
import laFerme.spring.AutowireServlet;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListerChevreServlet", urlPatterns = {"/ListerChevreServlet"})
public class ListerChevreServlet extends AutowireServlet {

    ChevreService chevreService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("valeur", "1");
        List<Chevre>  listeChevres = (List<Chevre>) chevreService.findAll();
        req.setAttribute("titre", "Votre troupeau de chevres");
        req.setAttribute("mesChevres", listeChevres);
        req.getRequestDispatcher("PageAccueilDeMonPersonnage").include(req, resp);
    }

    

}
