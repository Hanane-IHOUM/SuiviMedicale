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
	
	@NotNull
	private int age;
	
	@NotNull
	@Size(max=1)
	private String sexe;
	
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


	public Patient(@NotNull @Size(min = 3, max = 15) String nom, @NotNull @Size(min = 3, max = 15) String prenom,
			@NotNull @Size(min = 8, max = 10) String cin, @NotNull int age, @NotNull @Size(max = 1) String sexe,
			int tele, @Size(max = 50) String adress, @NotNull @Size(min = 2, max = 3) String typeSang,
			List<Consultation> consultations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.age = age;
		this.sexe = sexe;
		this.tele = tele;
		this.adress = adress;
		this.typeSang = typeSang;
		this.consultations = consultations;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
	
	
	
	
}
