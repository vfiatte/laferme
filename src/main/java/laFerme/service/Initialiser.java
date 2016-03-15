/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import laFerme.entity.Carotte;
import laFerme.entity.Personnage;
import laFerme.entity.Ressource;
import laFerme.entity.Utilisateur;
import laFerme.entity.ble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class Initialiser {

    @Autowired
    PersonnageService personnageService;

    @Autowired
    CarotteService carotteService;

    @Autowired
    ChevreService chevreService;

    @Autowired
    FromageService fromageService;

    @Autowired
    BleService bleService;
    
    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    RessourceService ressourceService;

    public void CreationInitialisation(Utilisateur u, String nom) {

        Personnage personnage = new Personnage();
        personnage.setNom(nom);
        personnage.setUtilisateur(u);
        u.getListepersonnages().add(personnage);
        personnageService.save(personnage);
        
        Ressource ressource = new Ressource();
        
        for (int i = 1; i <= 3; i++) {
            Carotte carotte = new Carotte();
            carotte.setPersonnage(personnage);
            personnage.getListeCarotte().add(carotte);
            carotteService.save(carotte);
            
            ble ble = new ble();
            ble.setPersonnage(personnage);
            personnage.getListeble().add(ble);
            bleService.save(ble);
            
        }
        
        ressource.setRessourceBle(3);
        ressource.setRessourceCarotte(3);
        ressource.setRessourceChevre(0);
        ressource.setRessourceFromage(0);
        ressource.setPersonnage(personnage);
        personnage.setRessource(ressource);
        ressourceService.save(ressource);
//        personnageService.save(personnage);
//        utilisateurService.save(u);
        

    }

}
