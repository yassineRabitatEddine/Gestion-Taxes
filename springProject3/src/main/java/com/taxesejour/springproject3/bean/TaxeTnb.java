package com.taxes.bean;

import javax.persistence.*;

@Entity
public class TaxeTnb {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	@ManyToOne(cascade = CascadeType.ALL)
	private Terrain terrain;
	private int annee;
	private double montantBase;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private TauxTaxeTnb tauxTaxeTnb;
	public long getId() {
		return id;
	}
	
	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public double getMontantBase() {
		return montantBase;
	}
	public void setMontantBase(double montantBase) {
		this.montantBase = montantBase;
	}
	
	public TauxTaxeTnb getTauxTaxeTnb() {
		return tauxTaxeTnb;
	}
	public void setTauxTaxeTnb(TauxTaxeTnb tauxTaxeTnb) {
		this.tauxTaxeTnb = tauxTaxeTnb;
	}
	
	
	
	
	
	
}
