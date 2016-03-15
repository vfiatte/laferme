/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import laFerme.entity.Personnage;
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
    CarotteService carroteService;
    @Autowired
    BleService bleService;
    

}
