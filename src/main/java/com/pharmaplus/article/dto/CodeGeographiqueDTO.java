package com.pharmaplus.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CodeGeographiqueDTO {

	private String id;
	private String libelle;
	private String idUserCrea;
	private String idUserModif;
	private Boolean parapharmacie;
	private String idSecteur;
}
