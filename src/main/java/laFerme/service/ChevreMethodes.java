/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Chevre;
import laFerme.entity.Fromage;
import laFerme.entity.Personnage;
import laFerme.entity.Utilisateur;
import laFerme.enumeration.EtatChevreEnumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ChevreMethodes {

    @Autowired
    ChevreService chevreService;
    @Autowired
    PersonnageService personnageService;
    @Autowired
    FromageService fromageService;
    @Autowired
    RessourceService ressourceService;

    public void AccouplementChevre(Personnage p) {

        GregorianCalendar ajd = new GregorianCalendar();

        int taille = p.getListeChevre().size();
        List<Chevre> listeChevre = chevreService.findAllByEtatAndPersonnageId(EtatChevreEnumeration.DISPONIBLE, p.getId());
        if (listeChevre.size() > 1) {
            for (Chevre chevre : listeChevre) {
                chevre.setEtat(EtatChevreEnumeration.ENCEINTE);
                chevre.setDateNaissance(ajd.getTime());
                chevreService.save(chevre);
                return;
            }
        }

    }

    public void NourrirChevre(Personnage p, Chevre c) {

        GregorianCalendar ajd = new GregorianCalendar();

        if (p.getRessource().getRessourceBle() >= 1) {
            p.getRessource().setRessourceBle(p.getRessource().getRessourceBle() - 1);
            c.setDateManger(ajd.getTime());
            ressourceService.save(p.getRessource());
            chevreService.save(c);
        }

    }

}
