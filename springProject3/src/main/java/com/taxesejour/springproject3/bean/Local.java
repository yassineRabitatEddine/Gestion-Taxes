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
    private CategorieSejour categorieSejour;

    public CategorieSejour getCategorieSejour() {
        return categorieSejour;
    }

    @OneToOne
    TaxeSejour taxeSejour;

    public TaxeSejour getTaxeSejour() {
        return taxeSejour;
    }

    public void setTaxeSejour(TaxeSejour taxeSejour) {
        this.taxeSejour = taxeSejour;
    }

    public void setCategorieSejour(CategorieSejour categorieSejour) {
        this.categorieSejour = categorieSejour;
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

