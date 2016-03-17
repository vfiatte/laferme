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

    public void nourrirChevre(List<Chevre> liste, Class c) {

        GregorianCalendar ajd = new GregorianCalendar();
        int compteur = 0;

        Map<Class, Integer> maMap = mapNutritionChevre();
        Integer nbaSupprimer = maMap.get(c);

        if (c.equals(Carotte.class)) {

            for (Chevre chevre : liste) {

//                for (int i = 1; i <= nbaSupprimer; i++) {
//                    if (chevre.getPersonnage().getRessource().getRessourceCarotte() == 0) {
//                        return;
//                    } else {
//                        List<Carotte> listCarotte = p.getListeCarotte();
//                        Carotte carotte = listCarotte.get(listCarotte.size() - 1);
//                        carotteService.delete(carotte);
//                        p.getRessource().setRessourceCarotte(p.getRessource().getRessourceCarotte() - 1);
//                    }
//                }

            }
        }

//        if (c.equals(ble.class)) {
//            for (int i = 1; i <= nbaSupprimer; i++) {
//                if (p.getRessource().getRessourceBle() == 0) {
//                    return;
//                } else {
//                    compteur = compteur + 1;
//                    List<ble> listBle = p.getListeble();
//                    ble blee = listBle.get(listBle.size() - 1);
//                    bleService.delete(blee);
//                }
//            }
//            p.getRessource().setRessourceBle(p.getRessource().getRessourceBle() - compteur);
//
//        }

//        if (c.equals(Chevre.class)) {
//            for (int i = 1; i <= nbaSupprimer; i++) {
//                if (p.getRessource().getRessourceChevre() == 0) {
//                    return;
//                } else {
//                    compteur = compteur + 1;
//                    List<Chevre> listChevre = p.getListeChevre();
//                    Chevre chevre = listChevre.get(listChevre.size() - 1);
//                    chevreService.delete(chevre);
//                }
//            }
//            p.getRessource().setRessourceChevre(p.getRessource().getRessourceChevre() - compteur);
//
//        }

//        if (c.equals(Fromage.class)) {
//            Fromage f = p.getFromage();
//            if (f.getQuantite() >= nbaSupprimer) {
//                f.setQuantite(f.getQuantite() - nbaSupprimer);
//                fromageService.save(f);
//            } else {
//                Integer nb = nbaSupprimer - f.getQuantite();
//                f.setQuantite(f.getQuantite() - nb);
//                fromageService.save(f);
//
//            }
//
//        }

//        ressourceService.save(p.getRessource());
//        p.setDateNourrit(ajd.getTime());

    }

}
