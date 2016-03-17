/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.io.Serializable;
import laFerme.entity.Ressource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
public interface RessourceService extends CrudRepository<Ressource, Long>{
    
    
}
