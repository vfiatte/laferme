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
import java.util.Random;
import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
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
public class NourrirPersonnage {

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

    public Map<Class, Integer> mapNutritionFermier() {

        Map<Class, Integer> mapNutrition = new HashMap();
        mapNutrition.put(Chevre.class, 1);
        mapNutrition.put(Fromage.class, 1);
        mapNutrition.put(Carotte.class, 2);
        mapNutrition.put(ble.class, 3);
        return mapNutrition;

    }

    public void nourrirFermier(Personnage p, Class c) {
        
        GregorianCalendar ajd = new GregorianCalendar();

        Map<Class, Integer> maMap = mapNutritionFermier();
        Integer nbaSupprimer = maMap.get(c);
        if (c.equals(Carotte.class)) {
            for (int i = 1; i <= nbaSupprimer; i++) {
                List<Carotte> listCarotte = p.getListeCarotte();
                Carotte carotte = listCarotte.get(listCarotte.size()-1);
                carotteService.delete(carotte);
            }
            p.getRessource().setRessourceCarotte(p.getRessource().getRessourceCarotte() - nbaSupprimer);

        }
        if (c.equals(ble.class)) {
            for (int i = 1; i <= nbaSupprimer; i++) {
                List<ble> listBle = p.getListeble();
                ble blee = listBle.get(listBle.size()-1);
                bleService.delete(blee);
            }
            p.getRessource().setRessourceBle(p.getRessource().getRessourceBle()- nbaSupprimer);

        }
        if (c.equals(Chevre.class)) {
            for (int i = 1; i <= nbaSupprimer; i++) {
                List<Chevre> listChevre = p.getListeChevre();
                Chevre chevre = listChevre.get(listChevre.size()-1);
                chevreService.delete(chevre);
            }
            p.getRessource().setRessourceChevre(p.getRessource().getRessourceChevre()- nbaSupprimer);

        }
        if (c.equals(Fromage.class)) {
                Fromage f = p.getFromage();
                f.setQuantite(f.getQuantite()-nbaSupprimer);
                fromageService.save(f);

        }
        ressourceService.save(p.getRessource());
        p.setDateNourrit(ajd.getTime());

    }

}
