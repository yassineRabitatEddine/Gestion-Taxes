package com.taxes.vo;

public class StatistiqueTaxeTnb {
    private double totalMontant;
    private int annee;

    public StatistiqueTaxeTnb(int annee,double totalMontant) {
        this.totalMontant = totalMontant;
        this.annee = annee;
    }

    public double getTotalMontant() {
        return totalMontant;
    }

    public void setTotalMontant(double totalMontant) {
        this.totalMontant = totalMontant;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
