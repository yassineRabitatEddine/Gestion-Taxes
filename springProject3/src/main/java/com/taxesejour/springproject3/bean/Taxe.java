package com.taxesejour.springproject3.bean;

import javax.persistence.*;

@Entity
public class Taxe {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private int annee;
    private int trimestre ;
    private double CA;
    private double montantBase ;

    public Taxe() {

    }

    public Taxe(double CA, Taux taux) {
        this.taux = taux;
        this.CA = CA;
        //a voir
        this.montantBase = taux.getPourcentage()*CA;
    }

    //un redevable paye plusieurs taxes
    @ManyToOne
    private Redevable redevable ;

    @OneToOne
    private Local local;
    @OneToOne
    private Taux taux ;


}