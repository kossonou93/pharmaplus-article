package com.pharmaplus.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FournisseurDTO {
	
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
	private Boolean enable;

}
