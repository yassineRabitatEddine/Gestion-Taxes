package com.taxesejour.springproject3.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Redevable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String cin;
    private String nom;
    private String prenom;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}