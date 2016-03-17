/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import laFerme.enumeration.EtatChevreEnumeration;

/**
 *
 * @author admin
 */
@Entity
public class Carotte implements Serializable {

    @ManyToOne
    @JoinColumn(name = "PERSONNAGE_ID")
    private Personnage personnage;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private EtatEnumeration etat=EtatEnumeration.NONPLANTE;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePlantation = null;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tempsRecolte = null;

    public Carotte() {
    }

    
    
    public Carotte(Long id, EtatEnumeration etat) {
        this.id = id;
        this.etat = etat;
    }

    public Date getTempsRecolte() {
        return tempsRecolte;
    }

    public void setTempsRecolte(Date tempsRecolte) {
        this.tempsRecolte = tempsRecolte;
    }

    
    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public EtatEnumeration getEtat() {
        return etat;
    }

    public void setEtat(EtatEnumeration etat) {
        this.etat = etat;
    }

    public Date getDatePlantation() {
        return datePlantation;
    }

    public void setDatePlantation(Date datePlantation) {
        this.datePlantation = datePlantation;
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
        if (!(object instanceof Carotte)) {
            return false;
        }
        Carotte other = (Carotte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "laFerme.entity.Carotte[ id=" + id + " ]";
    }
    
}
