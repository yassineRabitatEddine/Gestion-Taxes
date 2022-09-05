package com.taxes.bean;

import javax.persistence.*;

@Entity
public class Terrain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String referenceTerrain;
	private String rue;
	private String adresse;
	private double surface;
	@ManyToOne(cascade = CascadeType.ALL)
	private CategorieTnb categorieTnb;
	@ManyToOne(cascade = CascadeType.ALL)
	private Redevable redevable;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getSurface() {
		return surface;
	}
	public void setSurface(double surface) {
		this.surface = surface;
	}
	public String getReferenceTerrain() {
		return referenceTerrain;
	}
	public void setReferenceTerrain(String referenceTerrain) {
		this.referenceTerrain = referenceTerrain;
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
	public CategorieTnb getCategorieTnb() {
		return categorieTnb;
	}
	public void setCategorieTnb(CategorieTnb categorieTnb) {
		this.categorieTnb = categorieTnb;
	}
	public Redevable getRedevavble() {
		return redevable;
	}
	public void setRedevable(Redevable redevavble) {
		this.redevable = redevavble;
	}
	
	
}
