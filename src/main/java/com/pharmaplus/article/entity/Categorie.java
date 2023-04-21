package com.pharmaplus.article.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Document("categorie")
public class Categorie {

	@Id
	private String id;
	private String name;
	@OneToMany(mappedBy = "categorie")
	private List<Article> articles;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String name) {
		super();
		this.name = name;
	}
}
