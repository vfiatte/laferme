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
//        u.getListepersonnages().add(personnage);
        Utilisateur u2 = u;
        u2.getListepersonnages().add(personnage);
        utilisateurService.save(u2);
        personnageService.save(personnage);

        Ressource ressource = new Ressource();

        for (int i = 1; i <= 3; i++) {
            Carotte carotte = new Carotte();
            Personnage personnage2 = u2.getListepersonnages().get(0);
            carotte.setPersonnage(personnage2);
            personnage2.getListeCarotte().add(carotte);
            personnageService.save(personnage2);
            carotteService.save(carotte);

            ble ble = new ble();
            Personnage personnage3 = u2.getListepersonnages().get(0);
            ble.setPersonnage(personnage3);
            personnage3.getListeble().add(ble);
            personnageService.save(personnage3);
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
