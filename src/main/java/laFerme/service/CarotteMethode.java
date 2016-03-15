/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Carotte;
import laFerme.entity.EtatEnumeration;
import laFerme.entity.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CarotteMethode {

    @Autowired
    CarotteService carotteService;

    public void planterCarotte(Personnage p) {
        GregorianCalendar ajd = new GregorianCalendar();
        List<Carotte> listeCarotte = p.getListeCarotte();
        if (listeCarotte.size() == 0) {
            return;
        } else {
            Carotte c = listeCarotte.get(listeCarotte.size() - 1);
            c.setEtat(EtatEnumeration.PLANTE);
            c.setDatePlantation(ajd.getTime());
        }


    }
}
