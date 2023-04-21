package com.pharmaplus.article.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Document("fournisseur")
public class Fournisseur {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String identifiant;
	private String email;
	private String adresse;
	private String telephone;
	@OneToMany(mappedBy = "fournisseur")
	private List<Article> articles;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(String firstName, String lastName, String identifiant, String email, String adresse,
			String telephone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.identifiant = identifiant;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
	}
}
