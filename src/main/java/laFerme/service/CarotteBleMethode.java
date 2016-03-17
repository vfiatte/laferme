/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Carotte;
import laFerme.entity.EtatEnumeration;
import laFerme.entity.Personnage;
import laFerme.entity.ble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CarotteBleMethode {

    @Autowired
    CarotteService carotteService;

    @Autowired
    BleService bleService;

    @Autowired
    RessourceService ressourceService;
    
    @Autowired
    DateService dateService;

    public void planter(Personnage p, Class classe, Integer quantite) {
        GregorianCalendar ajd = new GregorianCalendar();
        if (classe.equals(Carotte.class)) {
            List<Carotte> listeCarotte = carotteService.findAllByEtatAndPersonnageId(EtatEnumeration.NONPLANTE, p.getId());
//            if (listeCarotte.size() == 0) {
            if (p.getRessource().getRessourceCarotte() == 0) {
                return;
            } else {
                for (int i = 1; i <= quantite; i++) {
                    listeCarotte = carotteService.findAllByEtatAndPersonnageId(EtatEnumeration.NONPLANTE, p.getId());
                    if (p.getRessource().getRessourceCarotte() == 0) {
//                    if (listeCarotte.size() == 0) {
                        return;
                    } else {
                        Carotte c = listeCarotte.get(listeCarotte.size() - 1);
                        c.setEtat(EtatEnumeration.PLANTE);
                        c.setDatePlantation(ajd.getTime());
                        p.getRessource().setRessourceCarotte(p.getRessource().getRessourceCarotte() - 1);
                        carotteService.save(c);
                    }
                }
            }
        }

        if (classe.equals(ble.class)) {
            List<ble> listeBle = bleService.findAllByEtatAndPersonnageId(EtatEnumeration.NONPLANTE, p.getId());
            if (p.getRessource().getRessourceBle() == 0) {
//            if (listeBle.size() == 0) {
                return;
            } else {
                for (int i = 1; i <= quantite; i++) {
                    listeBle = bleService.findAllByEtatAndPersonnageId(EtatEnumeration.NONPLANTE, p.getId());
                    if (p.getRessource().getRessourceBle() == 0) {
//                    if (listeBle.size() == 0) {
                        return;
                    } else {
                        ble b = listeBle.get(listeBle.size() - 1);
                        b.setEtat(EtatEnumeration.PLANTE);
                        b.setDatePlantation(ajd.getTime());
                        p.getRessource().setRessourceBle(p.getRessource().getRessourceBle() - 1);
                        bleService.save(b);
                    }
                }
            }

        }
        ressourceService.save(p.getRessource());
    }

}
