/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import laFerme.entity.Personnage;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface PersonnageService extends CrudRepository<Personnage, Long>{
    public Personnage findOneByNom(String s);
    
}
