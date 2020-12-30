package com.proj.entities;

import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Consultation {
	
	@Id @GeneratedValue
	private long id;
	
	private SimpleDateFormat date;
	
	private String heure;
	
	@NotNull
	private String description;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Medcin medecin;
	
	
	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Consultation(SimpleDateFormat date, String heure, @NotNull String description, Patient patient,
			Medcin medecin) {
		super();
		this.date = date;
		this.heure = heure;
		this.description = description;
		this.patient = patient;
		this.medecin = medecin;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public SimpleDateFormat getDate() {
		return date;
	}


	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}


	public String getHeure() {
		return heure;
	}


	public void setHeure(String heure) {
		this.heure = heure;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Medcin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medcin medecin) {
		this.medecin = medecin;
	}

	
	
	

}
