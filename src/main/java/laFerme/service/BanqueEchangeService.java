/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
import laFerme.entity.Personnage;
import laFerme.entity.Ressource;
import laFerme.entity.ble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class BanqueEchangeService {

    @Autowired
    ChevreService chevreService;
    @Autowired
    CarotteService carotteService;
    @Autowired
    BleService bleService;
    @Autowired
    RessourceService ressourceService;

    public void echange(Personnage p, Class classeContre, Integer qteChevre, Integer qteBle, Integer qteCarotte) {

        if (classeContre.equals(Chevre.class)) {

            if (qteBle != 0) {
                if (p.getRessource().getRessourceBle() >= qteBle) {

                    Integer quotient = qteBle / 4;
                    for (int i = 1; i <= quotient; i++) {

                        Chevre chevre = new Chevre();
                        p.getListeChevre().add(chevre);
                        chevre.setPersonnage(p);
                        chevreService.save(chevre);
                        p.getRessource().setRessourceChevre(p.getRessource().getRessourceChevre() + 1);
                        for (int j = 1; j <= 4; j++) {
                            bleService.delete(p.getListeble().get(p.getListeble().size() - 1));
                            p.getRessource().setRessourceBle(p.getRessource().getRessourceBle() - 1);
                        }

                    }
                }
            }
            if (qteChevre != 0) {
                qteChevre = qteChevre;
            }
            if (qteCarotte != 0) {
                if (p.getRessource().getRessourceCarotte() >= qteCarotte) {
                    Integer quotient = qteCarotte / 2;
                    for (int i = 1; i <= quotient; i++) {

                        Chevre chevre = new Chevre();
                        p.getListeChevre().add(chevre);
                        chevre.setPersonnage(p);
                        chevreService.save(chevre);
                        p.getRessource().setRessourceChevre(p.getRessource().getRessourceChevre() + 1);
                        for (int j = 1; j <= 2; j++) {
                            carotteService.delete(p.getListeCarotte().get(p.getListeCarotte().size() - 1));
                            p.getRessource().setRessourceCarotte(p.getRessource().getRessourceCarotte() - 1);
                        }
                    }
                }
            }
        } else if (classeContre.equals(ble.class)) {

            if (qteBle != 0) {
                qteBle = qteBle;
            }
            if (qteChevre != 0) {
                if (p.getRessource().getRessourceChevre() >= qteChevre) {
                    Integer quotient = qteChevre * 4;
                    for (int i = 1; i <= quotient; i++) {
                        ble blee = new ble();
                        p.getListeble().add(blee);
                        blee.setPersonnage(p);
                        bleService.save(blee);
                        p.getRessource().setRessourceBle(p.getRessource().getRessourceBle() + 1);
                    }
                    for (int j = 1; j <= qteChevre; j++) {
                        chevreService.delete(p.getListeChevre().get(p.getListeChevre().size() - 1));
                        p.getRessource().setRessourceChevre(p.getRessource().getRessourceChevre() - 1);
                    }
                }
            }
            if (qteCarotte != 0) {
                if (p.getRessource().getRessourceCarotte() >= qteCarotte) {
                    Integer quotient = qteCarotte * 2;
                    for (int i = 1; i <= quotient; i++) {
                        ble blee = new ble();
                        p.getListeble().add(blee);
                        blee.setPersonnage(p);
                        bleService.save(blee);
                        p.getRessource().setRessourceBle(p.getRessource().getRessourceBle() + 1);
                    }
                    for (int j = 1; j <= qteCarotte; j++) {
                        carotteService.delete(p.getListeCarotte().get(p.getListeCarotte().size() - 1));
                        p.getRessource().setRessourceCarotte(p.getRessource().getRessourceCarotte() - 1);
                    }
                }
            }

        } else if (classeContre.equals(Carotte.class)) {

            if (qteBle != 0) {
                if (p.getRessource().getRessourceBle() >= qteBle) {
                    Integer quotient = qteBle / 2;
                    for (int i = 1; i <= quotient; i++) {
                        Carotte carotte = new Carotte();
                        p.getListeCarotte().add(carotte);
                        carotte.setPersonnage(p);
                        carotteService.save(carotte);
                        p.getRessource().setRessourceCarotte(p.getRessource().getRessourceCarotte() + 1);
                        for (int j = 1; j <= 2; j++) {
                            bleService.delete(p.getListeble().get(p.getListeble().size() - 1));
                            p.getRessource().setRessourceBle(p.getRessource().getRessourceBle() - 1);
                        }
                    }

                }
            }
            if (qteChevre != 0) {
                if (p.getRessource().getRessourceChevre() >= qteChevre) {
                    Integer quotient = qteChevre * 2;
                    for (int i = 1; i <= quotient; i++) {
                        Carotte carotte = new Carotte();
                        p.getListeCarotte().add(carotte);
                        carotte.setPersonnage(p);
                        carotteService.save(carotte);
                        p.getRessource().setRessourceCarotte(p.getRessource().getRessourceCarotte()+ 1);
                    }
                    for (int j = 1; j <= qteChevre; j++) {
                        chevreService.delete(p.getListeChevre().get(p.getListeChevre().size() - 1));
                        p.getRessource().setRessourceChevre(p.getRessource().getRessourceChevre() - 1);
                    }
                }
            }
            if (qteCarotte != 0) {
                qteCarotte = qteCarotte;

            }

        }
        ressourceService.save(p.getRessource());

    }
}
