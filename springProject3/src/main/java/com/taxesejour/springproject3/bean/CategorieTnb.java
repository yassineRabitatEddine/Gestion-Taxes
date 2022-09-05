package com.taxes.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategorieTnb {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String lebelle;
	private String reference;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLebelle() {
		return lebelle;
	}
	public void setLebelle(String lebelle) {
		this.lebelle = lebelle;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
}
