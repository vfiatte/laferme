/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laFerme.service.ChevreService;
import laFerme.service.NourrirChevreService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "NourirChevreServlet", urlPatterns = {"/NourirChevreServlet"})
public class NourirChevreServlet extends HttpServlet {

    @Autowired
    ChevreService chevreService;
    
    @Autowired
    NourrirChevreService nourrirChevreService;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] chevre = req.getParameterValues("nourirChevre");
        if (chevre != null && chevre.length != 0){
            for (String c : chevre){
                Long id = Long.parseLong(c);
                nourrirChevreService.nourrirChevre(, c);
                
            }
        }
    }

          
}
