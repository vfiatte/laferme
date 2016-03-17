/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class DateService {

    @Autowired
    CueillirMethode cueillir;
    @Autowired
    PersonnageService personnageService;

    @Scheduled(fixedDelay = 30000)
    public void dateajd() {
//        System.out.println("coucou");
        GregorianCalendar ajd = new GregorianCalendar();

        List<Personnage> listePersonnage = (List<Personnage>) personnageService.findAll();
        for (Personnage p : listePersonnage) {
            cueillir.recuperation(p);
        }
    
    }
}
