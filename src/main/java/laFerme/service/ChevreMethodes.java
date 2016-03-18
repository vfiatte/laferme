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

    public void AccouplementChevre(Long id, int nb) {

        GregorianCalendar ajd = new GregorianCalendar();
        List<Chevre> listeChevreDispo = chevreService.findAllByEtatAndPersonnageId(EtatChevreEnumeration.DISPONIBLE, id);
                System.out.println("coucouuuuuuuuuuuuuuuuuuuUUUUUUUUUU");

        if (nb > 0) {
            for (int i = 1; i <= nb; i++) {
                listeChevreDispo = chevreService.findAllByEtatAndPersonnageId(EtatChevreEnumeration.DISPONIBLE, id);
                Chevre c = listeChevreDispo.get(0);
                Chevre c2 = listeChevreDispo.get(1);
                c.setEtat(EtatChevreEnumeration.ENCEINTE);
                c2.setEtat(EtatChevreEnumeration.ENCEINTE);
                c.setDateNaissance(ajd.getTime());
                c2.setDateNaissance(ajd.getTime());
                chevreService.save(c);
                chevreService.save(c2);
                
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
