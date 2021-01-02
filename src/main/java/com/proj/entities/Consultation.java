package com.proj.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Consultation implements Serializable{
	
	@Id @GeneratedValue
	private long id;
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date heure;
	
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


	public Consultation(Date date, Date heure, @NotNull String description, Patient patient, Medcin medecin) {
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

	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getHeure() {
		return heure;
	}


	public void setHeure(Date heure) {
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
