package com.taxesejour.springproject3.bean;


import javax.persistence.*;

@Entity
public class TaxeSejour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private int trimestre;
    private int annee;
    private int nbreNuits;
    private double montantDeBase;

    @OneToOne
    private Local local;

    @OneToOne
    private Redevable redevable;

    @OneToOne
    private TauxSejour tauxSejour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNbreNuits() {
        return nbreNuits;
    }

    public void setNbreNuits(int nbreNuits) {
        this.nbreNuits = nbreNuits;
    }

    public double getMontantDeBase() {
        return montantDeBase;
    }

    public void setMontantDeBase(int montantDeBase) {
        this.montantDeBase = montantDeBase;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public TauxSejour getTauxSejour() {
        return tauxSejour;
    }

    public void setTauxSejour(TauxSejour tauxSejour) {
        this.tauxSejour = tauxSejour;
    }
}
