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
import org.mockito.Mockito;
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
            System.out.println(c.getDateManger());
            varDate.add(Calendar.MINUTE, 12);
            if (varDate.before(ajd)) {
                System.out.println("coucuo");
                chevreService.delete(c);
                p.getRessource().setRessourceChevre(p.getRessource().getRessourceChevre() - 1);
            }
            GregorianCalendar ajd1 = new GregorianCalendar();
            GregorianCalendar ajd2 = new GregorianCalendar();
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 1);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 2);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(11);
                chevreService.save(c);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 2);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 3);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(10);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 3);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 4);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(9);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 4);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 5);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(8);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 5);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 6);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(7);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 6);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 7);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(6);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 7);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 8);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(5);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 7);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 8);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(5);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 8);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 9);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(4);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 9);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 10);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(3);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 10);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 11);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(2);
            }
            ajd1.setTime(c.getDateManger());
            ajd1.add(Calendar.MINUTE, 11);
            ajd2.setTime(c.getDateManger());
            ajd2.add(Calendar.MINUTE, 12);
            if (ajd1.before(ajd) && ajd2.after(ajd)) {
                c.setNbVie(1);
            }
        }
        ressourceService.save(p.getRessource());
    }
}
