package com.pharmaplus.article.request;

public class ArticleRequest {
	
	private String id;
	private String name;
	private String description;
	private Double price;
	private Integer quantity;
	private String fournisseur;
	private String categorie;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public ArticleRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleRequest(String name, String description, Double price, Integer quantity, String fournisseur,
			String categorie) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.fournisseur = fournisseur;
		this.categorie = categorie;
	}
}
