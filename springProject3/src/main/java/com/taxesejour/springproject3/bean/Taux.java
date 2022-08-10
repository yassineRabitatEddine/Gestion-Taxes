package com.taxesejour.springproject3.bean;

import javax.persistence.*;

@Entity
public class Taux {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private double pourcentage ;
    private String CategLocal ;
    @OneToOne
    private Taxe taxe ;


    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public String getCategLocal() {
        return CategLocal;
    }

    public void setCategLocal(String categLocal) {
        CategLocal = categLocal;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;

    }
}
