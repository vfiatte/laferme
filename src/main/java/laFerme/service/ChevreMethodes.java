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

    public void NaissanceChevre(Personnage p) {

        GregorianCalendar ajd = new GregorianCalendar();

        int taille = p.getListeChevre().size();
        if (taille > 1) {
            for (Chevre chevre : p.getListeChevre()) {
                if (chevre.getEtat()==EtatChevreEnumeration.DISPONIBLE) {
                    chevre.setEtat(EtatChevreEnumeration.ENCEINTE);
                    chevre.setDateNaissance(ajd.getTime());
                    chevreService.save(chevre);
                    return;
                }
            }

        }
    }

    public void NourrirChevre(Personnage p) {

        GregorianCalendar date = new GregorianCalendar();
        GregorianCalendar dateFromage = new GregorianCalendar();

        List<Chevre> listeChevre = p.getListeChevre();
        for (Chevre chevre : listeChevre) {
            dateFromage.setTime(chevre.getDateFromage());
            if (date.equals(dateFromage)) {
                p.getFromage().setQuantite(p.getFromage().getQuantite() + 1L);

            }
        }

    }


}
