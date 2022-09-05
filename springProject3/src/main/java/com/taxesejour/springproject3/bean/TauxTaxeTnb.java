package com.taxes.bean;

import javax.persistence.*;

@Entity
public class TauxTaxeTnb {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double montantMetreCarre;
	@ManyToOne(cascade = CascadeType.ALL)
	private CategorieTnb categorieTnb;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getMontantMetreCarre() {
		return montantMetreCarre;
	}
	public void setMontantMetreCarre(Double montantMetreCarre) {
		this.montantMetreCarre = montantMetreCarre;
	}
	public CategorieTnb getCategorieTnb() {
		return categorieTnb;
	}
	public void setCategorieTnb(CategorieTnb categorieTnb) {
		this.categorieTnb = categorieTnb;
	}
	
	
}
