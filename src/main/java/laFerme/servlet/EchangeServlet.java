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
import laFerme.entity.Personnage;
import laFerme.entity.Utilisateur;
import laFerme.entity.ble;
import laFerme.service.BleService;
import laFerme.service.CarotteService;
import laFerme.service.ChevreService;
import laFerme.service.ConfigService;
import laFerme.service.PersonnageService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "EchangeServlet", urlPatterns = {"/EchangeServlet"})
public class EchangeServlet extends AutowireServlet {

    @Autowired
    ConfigService config;

    @Autowired
    PersonnageService personnageService;
    
    @Autowired
    CarotteService carotteService;
    
    @Autowired
    BleService bleService;
    
    @Autowired
    ChevreService chevreService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = config.recupererUtilisateur(req);
        Long id = Long.parseLong(req.getParameter("idPersonnage"));
        Personnage p = personnageService.findOne(id);
        List<ble> listeble = p.getListeble();

        Long qteble = Long.parseLong(req.getParameter("quantiteble"));
        Long qteCarotte = Long.parseLong(req.getParameter("quantiteCarotte"));
        Long qteChevre = Long.parseLong(req.getParameter("quantiteChevre"));
        String echangeContre = req.getParameter("contre");

        if (echangeContre.equals("ble")) {
            if (qteble % 4 == 0) {
                for (int i = 0; i <= qteble / 4; i++) {
                    Chevre chevre = new Chevre();
                    p.getListeChevre().add(chevre);
                    chevre.setPersonnage(p);
                    for(int j = 0; j<=qteble; j++){
                        bleService.delete(listeble.get(p.getListeble().size() - 1));
                    }
                }
            }
            
            if (qteble % 2 == 0) {
                for (int i = 0; i <= qteble / 2; i++) {
                    Carotte carotte = new Carotte();
                    p.getListeCarotte().add(carotte);
                    carotte.setPersonnage(p);
                }
            }
            
        }
        
        
        if (echangeContre.equals("carotte")) {
            
                for (int i = 0; i <= qteCarotte*2; i++) {
                    ble ble = new ble();
                    p.getListeble().add(ble);
                    ble.setPersonnage(p);
                }
            
            if (qteble % 2 == 0) {
                for (int i = 0; i <= qteble / 2; i++) {
                    Chevre chevre = new Chevre();
                    p.getListeChevre().add(chevre);
                    chevre.setPersonnage(p);
                }
            }
        }
        
        if (echangeContre.equals("chevre")) {
            
                for (int i = 0; i <= qteChevre*2; i++) {
                    Carotte carotte = new Carotte();
                    p.getListeCarotte().add(carotte);
                    carotte.setPersonnage(p);
                }
            
             
                for (int i = 0; i <= qteble*4 ; i++) {
                    ble ble = new ble();
                    p.getListeble().add(ble);
                    ble.setPersonnage(p);
                }
            }
        
        personnageService.save(p);
        req.getRequestDispatcher("passerparacceuil").include(req, resp);
        }
    

    }


