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
import static laFerme.enumeration.EtatChevreEnumeration.DISPONIBLE;

/**
 *
 * @author admin
 */
@Entity
public class Chevre implements Serializable {

    @ManyToOne
    @JoinColumn(name = "PERSONNAGE_ID")
    private Personnage personnage;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateManger;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFromage;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    
    private EtatChevreEnumeration Etat;

    public Chevre() {
    }

    public Chevre(Long id, Date dateFromage, Date dateNaissance, EtatChevreEnumeration Etat) {
        this.id = id;
        this.dateFromage = dateFromage;
        this.dateNaissance = dateNaissance;
        this.Etat = DISPONIBLE;
    }

   

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public EtatChevreEnumeration getEtat() {
        return Etat;
    }

    public void setEtat(EtatChevreEnumeration Etat) {
        this.Etat = Etat;
    }
    
    

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    

    public Date getDateManger() {
        return dateManger;
    }

    public void setDateManger(Date dateManger) {
        this.dateManger = dateManger;
    }

    
    
    

    
    
    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public Date getDateFromage() {
        return dateFromage;
    }

    public void setDateFromage(Date dateFromage) {
        this.dateFromage = dateFromage;
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
        if (!(object instanceof Chevre)) {
            return false;
        }
        Chevre other = (Chevre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "laFerme.entity.Chevre[ id=" + id + " ]";
    }

}
