/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.List;
import laFerme.entity.Chevre;
import laFerme.enumeration.EtatChevreEnumeration;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ChevreService extends CrudRepository<Chevre, Long>{
    public List<Chevre> findAllByEtatAndPersonnageId(EtatChevreEnumeration etat, Long id);
    public List<Chevre> findAllByPersonnageIdOrderByDateManger(Long id);
    public List<Chevre> findAllByPersonnageId(Long id);
}
