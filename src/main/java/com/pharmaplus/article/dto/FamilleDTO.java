package com.pharmaplus.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilleDTO {

	private String id;
	private String libelle;
	private String idUserCrea;
	private String idUserModif;
}
