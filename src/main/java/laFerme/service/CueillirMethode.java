/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
import laFerme.entity.EtatEnumeration;
import laFerme.entity.Personnage;
import laFerme.entity.ble;
import laFerme.enumeration.EtatChevreEnumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CueillirMethode {

    @Autowired
    CarotteService carotteService;

    @Autowired
    ChevreService chevreService;

    @Autowired
    FromageService fromageService;

    @Autowired
    BleService bleService;

    @Autowired
    PersonnageService personnageService;

    @Autowired
    RessourceService ressourceService;



    public void recuperation(Personnage p) {
        List<Chevre> listeChevre = chevreService.findAllByPersonnageId(p.getId());
        List<Carotte> listeCarottePlante = p.getListeCarotte();
        List<ble> listeBlePlante = p.getListeble();
        GregorianCalendar ajd = new GregorianCalendar();
        GregorianCalendar varDate = new GregorianCalendar();
        Random r = new Random();

        for (Chevre chevre : listeChevre) {
            varDate.setTime(chevre.getDateFromage());
            varDate.add(Calendar.MINUTE, 6);
            System.out.println(chevre.getDateFromage());
            System.out.println(varDate);
            System.out.println(ajd);
            if (varDate.before(ajd)) {
                int valeur = 2 + r.nextInt(4 - 2);
//                p.getFromage().setQuantite(p.getFromage().getQuantite() + valeur);
                chevre.setDateFromage(ajd.getTime());
                chevreService.save(chevre);
//                fromageService.save(p.getFromage());
                personnageService.save(p);
                p.getRessource().setRessourceFromage(p.getRessource().getRessourceFromage() + valeur);
                ressourceService.save(p.getRessource());
            }

        }
        List<Chevre> listeChevreEnceinte = chevreService.findAllByEtatAndPersonnageId(EtatChevreEnumeration.ENCEINTE, p.getId());
        for (Chevre chevre : listeChevreEnceinte) {
            varDate.setTime(chevre.getDateNaissance());
            varDate.add(Calendar.MINUTE, 12);
            if (varDate.before(ajd)) {
                Chevre chevrebb = new Chevre();
                chevrebb.setDateFromage(ajd.getTime());
                chevrebb.setPersonnage(p);
                p.getListeChevre().add(chevrebb);
                chevrebb.setDateManger(ajd.getTime());
                chevreService.save(chevrebb);
                chevre.setEtat(EtatChevreEnumeration.DISPONIBLE);
                chevre.setDateNaissance(ajd.getTime());
                chevreService.save(chevre);
                p.getRessource().setRessourceChevre(p.getRessource().getRessourceChevre() + 1);
                personnageService.save(p);
                ressourceService.save(p.getRessource());
            }

        }
        List<Carotte> listeCarottePlantee = carotteService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
        for (Carotte carotte : listeCarottePlantee) {
            varDate.setTime(carotte.getDatePlantation());
            varDate.add(Calendar.MINUTE, 6);
            if (varDate.before(ajd)) {
                int valeur = 2 + r.nextInt(4 - 2);
                for (int i = 1; i <= valeur; i++) {
                    Carotte carottebb = new Carotte();
                    carottebb.setPersonnage(p);
                    p.getListeCarotte().add(carottebb);
                    p.getRessource().setRessourceCarotte(p.getRessource().getRessourceCarotte() + 1);
                    carotteService.save(carottebb);
                    personnageService.save(p);
                    ressourceService.save(p.getRessource());
                }
                carotteService.delete(carotte);

            }
        }

        List<ble> listeBlePlantee = bleService.findAllByEtatAndPersonnageId(EtatEnumeration.PLANTE, p.getId());
        for (ble ble : listeBlePlantee) {
            varDate.setTime(ble.getDatePlantation());
            varDate.add(Calendar.MINUTE, 6);

            if (varDate.before(ajd)) {
                int valeur = 2 + r.nextInt(4 - 2);
                for (int i = 1; i <= valeur; i++) {
                    ble blebb = new ble();
                    blebb.setPersonnage(p);
                    p.getListeble().add(blebb);
                    p.getRessource().setRessourceBle(p.getRessource().getRessourceBle() + 1);
                    bleService.save(blebb);
                    personnageService.save(p);
                    ressourceService.save(p.getRessource());
                }
                bleService.delete(ble);

            }
        }
    }
}
