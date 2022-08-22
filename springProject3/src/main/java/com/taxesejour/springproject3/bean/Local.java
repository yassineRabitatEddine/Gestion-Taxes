package com.taxesejour.springproject3.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Local {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String ref;
    private String libelle;
    private String rue;
    private String adresse;

    @ManyToOne
    private Redevable redevable;

    @ManyToOne
    private Categorie categorie;


    @OneToMany
    private Taxe taxe ;

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }
}

