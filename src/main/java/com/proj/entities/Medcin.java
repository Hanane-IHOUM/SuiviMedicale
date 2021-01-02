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
public class Medcin implements Serializable{
	
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
	
	//@Size(max=50)
	private String specialite;
	
	@Size(min=3,max=64)
	private String password;
	
	//@Size(max=50)
	private String role;
		
	private boolean active;
	
	@OneToMany(targetEntity = Consultation.class, mappedBy = "medecin")
	private List<Consultation> consultations;
	
	

	public Medcin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Medcin(@NotNull @Size(min = 3, max = 15) String nom, @NotNull @Size(min = 3, max = 15) String prenom,
			@NotNull @Size(min = 8, max = 10) String cin, String specialite, @Size(min = 3, max = 64) String password,
			String role, boolean active, List<Consultation> consultations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.specialite = specialite;
		this.password = password;
		this.role = role;
		this.active = active;
		this.consultations = consultations;
	}



	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getCin() {
		return cin;
	}



	public void setCin(String cin) {
		this.cin = cin;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
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


	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public List<Consultation> getConsultations() {
		return consultations;
	}



	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	


}
