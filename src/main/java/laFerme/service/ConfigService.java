/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import javax.servlet.http.HttpServletRequest;
import laFerme.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigService {

    @Autowired
    UtilisateurService utilisateurService;

    public Utilisateur recupererUtilisateur(HttpServletRequest req) {
        Utilisateur u = utilisateurService.findOneByLogin(req.getSession().getAttribute("user").toString());
        return u;
    }

}
