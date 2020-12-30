package com.proj.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


@Entity
public class Patient implements Serializable{
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=15)
	private String nom;
	
	@NotNull
	@Size(min=3,max=15)
	private String prenom;
	
	@NotNull
	@Size(min=8,max=10)
	private String cin;
	
	
	private int tele;
	
	@Size(max=50)
	private String adress;
	
	@NotNull
	@Size(min=2,max=3)
	private String typeSang;
	
	@OneToMany(targetEntity = Consultation.class, mappedBy = "patient")
	private List<Consultation> consultations;
	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient(String nom, String prenom, String cin, int tele, String adress, String typeSang) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.tele = tele;
		this.adress = adress;
		this.typeSang = typeSang;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getTypeSang() {
		return typeSang;
	}


	public void setTypeSang(String typeSang) {
		this.typeSang = typeSang;
	}


	public int getTele() {
		return tele;
	}


	public void setTele(int tele) {
		this.tele = tele;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public List<Consultation> getConsultations() {
		return consultations;
	}


	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}
	
	
	
	
	
	
}
