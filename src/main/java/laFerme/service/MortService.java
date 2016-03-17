/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Chevre;
import laFerme.entity.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class MortService {

    @Autowired
    PersonnageService personnageService;

    @Autowired
    RessourceService ressourceService;

    @Autowired
    ChevreService chevreService;

    GregorianCalendar ajd = new GregorianCalendar();
    GregorianCalendar varDate = new GregorianCalendar();

    public void mortFermier(Personnage p) {
        varDate.setTime(p.getDateNourrit());
        varDate.add(Calendar.MINUTE, 12);
        if (varDate.before(ajd)) {
            personnageService.delete(p);
        }
    }

    public void mortChevre(Personnage p) {
        List<Chevre> listeChevre = chevreService.findAllByPersonnageId(p.getId());
        for (Chevre c : listeChevre) {
            varDate.setTime(c.getDateManger());
            varDate.add(Calendar.MINUTE, 12);
            if (varDate.before(ajd)) {
                System.out.println("coucuo");
                chevreService.delete(c);
                p.getRessource().setRessourceChevre(p.getRessource().getRessourceChevre()- 1);
            }
        }
        ressourceService.save(p.getRessource());
    }
}
