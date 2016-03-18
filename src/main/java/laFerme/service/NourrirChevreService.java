/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
import laFerme.entity.EtatEnumeration;
import laFerme.entity.Fromage;
import laFerme.entity.Personnage;
import laFerme.entity.ble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class NourrirChevreService {

    @Autowired
    ChevreService chevreService;
    @Autowired
    PersonnageService personnageService;
    @Autowired
    FromageService fromageService;
    @Autowired
    RessourceService ressourceService;
    @Autowired
    CarotteService carotteService;
    @Autowired
    BleService bleService;

    public Map<Class, Integer> mapNutritionChevre() {

        Map<Class, Integer> mapNutrition = new HashMap();
        mapNutrition.put(ble.class, 1);
        mapNutrition.put(Carotte.class, 1);
        return mapNutrition;

    }

    public void nourrirChevre(Long id, Class c) {

        GregorianCalendar ajd = new GregorianCalendar();

        Chevre chevre = chevreService.findOne(id);

        Map<Class, Integer> maMap = mapNutritionChevre();
        Integer nbaSupprimer = maMap.get(c);
        chevre.setNbVie(12);

        if (c.equals(Carotte.class)) {

            for (int i = 1; i <= nbaSupprimer; i++) {
                if (chevre.getPersonnage().getRessource().getRessourceCarotte() == 0) {
                    return;
                } else {
                    List<Carotte> listCarotte = carotteService.findAllByEtatAndPersonnageId(EtatEnumeration.NONPLANTE, chevre.getPersonnage().getId());
                    Carotte carotte = listCarotte.get(listCarotte.size() - 1);
                    chevre.setDateManger(ajd.getTime());
                    chevreService.save(chevre);
                    carotteService.delete(carotte);
                    chevre.getPersonnage().getRessource().setRessourceCarotte(chevre.getPersonnage().getRessource().getRessourceCarotte() - 1);
                }
            }

        }

        if (c.equals(ble.class)) {
            for (int i = 1; i <= nbaSupprimer; i++) {
                if (chevre.getPersonnage().getRessource().getRessourceBle() == 0) {
                    return;
                } else {
                    List<ble> listBle = bleService.findAllByEtatAndPersonnageId(EtatEnumeration.NONPLANTE, chevre.getPersonnage().getId());
                    ble blee = listBle.get(listBle.size() - 1);
                    chevre.setDateManger(ajd.getTime());
                    chevreService.save(chevre);
                    bleService.delete(blee);
                    chevre.getPersonnage().getRessource().setRessourceBle(chevre.getPersonnage().getRessource().getRessourceBle() - 1);
                }
            }

        }

        ressourceService.save(chevre.getPersonnage().getRessource());
        chevre.getPersonnage().setDateNourrit(ajd.getTime());

    }
}
