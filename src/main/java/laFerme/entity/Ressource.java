/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author admin
 */
@Entity
public class Ressource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int ressourceBle;
    private int ressourceChevre;
    private int ressourceCarotte;
    private int ressourceFromage;
    
    @OneToOne
    @JoinColumn(name = "PERSONNAGE_ID")
    private Personnage personnage;

    public int getRessourceBle() {
        return ressourceBle;
    }

    public void setRessourceBle(int ressourceBle) {
        this.ressourceBle = ressourceBle;
    }

    public int getRessourceChevre() {
        return ressourceChevre;
    }

    public void setRessourceChevre(int ressourceChevre) {
        this.ressourceChevre = ressourceChevre;
    }

    public int getRessourceCarotte() {
        return ressourceCarotte;
    }

    public void setRessourceCarotte(int ressourceCarotte) {
        this.ressourceCarotte = ressourceCarotte;
    }

    public int getRessourceFromage() {
        return ressourceFromage;
    }

    public void setRessourceFromage(int ressourceFromage) {
        this.ressourceFromage = ressourceFromage;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ressource)) {
            return false;
        }
        Ressource other = (Ressource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "laFerme.entity.Ressource[ id=" + id + " ]";
    }
    
}
