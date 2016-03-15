/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import javax.servlet.http.HttpServletRequest;
import laFerme.entity.Personnage;
import laFerme.entity.Ressource;
import laFerme.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigService {

    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    PersonnageService personnageService;

    public Utilisateur recupererUtilisateur(HttpServletRequest req) {
        Utilisateur u = utilisateurService.findOneByLogin(req.getSession().getAttribute("user").toString());
        return u;
    }
    
    public void calculPoints(Personnage p){
        int pointBle = p.getRessource().getRessourceBle()*1;
        int pointCarotte = p.getRessource().getRessourceCarotte()*2;
        int pointChevre = p.getRessource().getRessourceChevre()*4;
        
        int totalPoints = pointBle + pointCarotte + pointChevre;
        
        p.setNbDePoints(totalPoints);
        personnageService.save(p);
        
    }

}
