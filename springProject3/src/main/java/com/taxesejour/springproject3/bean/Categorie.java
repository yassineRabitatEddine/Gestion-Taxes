package com.taxesejour.springproject3.bean;

import javax.persistence.*;
@Entity
public class Categorie {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String libelle ;

    public Categorie() {
    }

    public Long getId() {
        return id;
    }

    @OneToMany
    private Taux taux;

    @OneToMany
    private  Local local ;

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Taux getTaux() {
        return taux;
    }

    public void setTaux(Taux taux) {
        this.taux = taux;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setId(Long id) {
        this.id = id;

    }
}

