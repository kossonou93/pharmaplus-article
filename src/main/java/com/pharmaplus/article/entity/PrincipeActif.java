package com.pharmaplus.article.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document("principe_actif")
public class PrincipeActif extends AuditModel{

	@Id
	private String id;
	private String libelle;
	private String idUserCrea;
	private String idUserModif;
}
