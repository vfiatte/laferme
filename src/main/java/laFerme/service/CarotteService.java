/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.List;
import laFerme.entity.Carotte;
import laFerme.entity.EtatEnumeration;
import laFerme.entity.ble;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface CarotteService extends CrudRepository<Carotte, Long>{
     public List<Carotte> findAllByEtatAndPersonnageId(EtatEnumeration etat, Long id);
}
