package com.taxesejour.springproject3.bean;

import javax.persistence.*;

@Entity
public class Taux {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private double pourcentage ;


    @ManyToOne
    private Categorie categorie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public double getPourcentage() {
        return pourcentage;
    }


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;

    }
}
