package com.proj.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity

public class Admin implements Serializable{
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=15)
	private String nom;
	
	@NotNull
	@Size(min=3,max=15)
	private String prenom;
	
	private int tele;
	
	@Size(max=50)
	private String adress;
	
	@NotNull
	@Size(min=8,max=10)
	private String cin;
	
	@Size(min=3,max=64)
	private String password;
	
	
	private boolean active;

	private String role;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	

	public Admin(@NotNull @Size(min = 3, max = 15) String nom, @NotNull @Size(min = 3, max = 15) String prenom,
			int tele, @Size(max = 50) String adress, @NotNull @Size(min = 8, max = 10) String cin,
			@Size(min = 3, max = 64) String password, boolean active, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.adress = adress;
		this.cin = cin;
		this.password = password;
		this.active = active;
		this.role = role;
	}



	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
