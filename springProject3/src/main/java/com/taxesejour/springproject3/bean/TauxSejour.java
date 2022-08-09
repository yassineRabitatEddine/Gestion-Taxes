package com.taxesejour.springproject3.bean;


import javax.persistence.*;
import java.util.List;

@Entity
public class TauxSejour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Long montantparnuit;

    @OneToOne
    private CategorieSejour categorieSejour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMontantparnuit() {
        return montantparnuit;
    }

    public void setMontantparnuit(Long montantparnuit) {
        this.montantparnuit = montantparnuit;
    }

    public CategorieSejour getCategorieSejour() {
        return categorieSejour;
    }

    public void setCategorieSejour(CategorieSejour categorieSejour) {
        this.categorieSejour = categorieSejour;
    }
}
