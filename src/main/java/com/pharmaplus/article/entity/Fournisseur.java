package com.pharmaplus.article.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document("fournisseur")
public class Fournisseur extends AuditModel{

	@Id
	private String id;
	private String nom;
	private String telephone;
	private String code;
	private String email;
	private String adresse;
	private String mobile;
	private String identifiant;
	private String nomRepresentant;
	private String fax;
	private String codeCip;
	private String idUserCrea;
	private String idUserModif;
	@Column(columnDefinition = "boolean default false")
    private boolean enable = false;
	
}
