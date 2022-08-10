package com.taxesejour.springproject3.bean;

// Commentaire Stage
import javax.persistence.*;
import java.util.List;

@Entity
public class CategorieSejour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String ref;
    private String label;

    @OneToMany(mappedBy = "categorieSejour")
    private List<Local> locaux;

    public List<Local> getLocaux() {
        return locaux;
    }

    @OneToOne
    private TauxSejour tauxSejour;

    public TauxSejour getTauxSejour() {
        return tauxSejour;
    }

    public void setTauxSejour(TauxSejour tauxSejour) {
        this.tauxSejour = tauxSejour;
    }

    public void setLocaux(List<Local> locaux) {
        this.locaux = locaux;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
