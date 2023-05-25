package com.pharmaplus.article.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Document("code_geographique")
public class CodeGeographique extends AuditModel{

	@Id
	private String id;
	private String libelle;
	private String idUserCrea;
	private String idUserModif;
	private Boolean parapharmacie;
	private String idSecteur;
}
