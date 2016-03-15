/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Personnage implements Serializable {

    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "personnage")
    List<Carotte> listeCarotte = new ArrayList<>();

    @OneToMany(mappedBy = "personnage")
    List<ble> listeble = new ArrayList<>();

    @OneToMany(mappedBy = "personnage")
    List<Chevre> listeChevre = new ArrayList<>();

    @OneToOne(mappedBy = "personnage")
    private Fromage fromage;

    @OneToOne(mappedBy = "personnage")
    private Ressource ressource;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFromage;
    private int nbDePoints;
    
    
    public Personnage() {
    }

    public Personnage(Long id, String nom, Date dateFromage) {
        this.id = id;
        this.nom = nom;
        this.dateFromage = dateFromage;
    }

    public Integer getNbDePoints() {
        return nbDePoints;
    }

    public void setNbDePoints(Integer nbDePoints) {
        this.nbDePoints = nbDePoints;
    }

    
    
    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    
    
    public Date getDateFromage() {
        return dateFromage;
    }

    public void setDateFromage(Date dateFromage) {
        this.dateFromage = dateFromage;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Carotte> getListeCarotte() {
        return listeCarotte;
    }

    public void setListeCarotte(List<Carotte> listeCarotte) {
        this.listeCarotte = listeCarotte;
    }

    public List<ble> getListeble() {
        return listeble;
    }

    public void setListeble(List<ble> listeble) {
        this.listeble = listeble;
    }

    public List<Chevre> getListeChevre() {
        return listeChevre;
    }

    public void setListeChevre(List<Chevre> listeChevre) {
        this.listeChevre = listeChevre;
    }

    public Fromage getFromage() {
        return fromage;
    }

    public void setFromage(Fromage fromage) {
        this.fromage = fromage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        if (!(object instanceof Personnage)) {
            return false;
        }
        Personnage other = (Personnage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "laFerme.entity.Personnage[ id=" + id + " ]";
    }

}
