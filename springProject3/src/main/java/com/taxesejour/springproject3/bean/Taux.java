package com.taxesejour.springproject3.bean;

import javax.persistence.*;

@Entity
public class Taux {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private double pourcentage ;

    @OneToMany
    private Taxe taxe ;

    @ManyToOne
    private Categorie categorie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
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
