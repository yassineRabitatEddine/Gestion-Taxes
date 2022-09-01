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

