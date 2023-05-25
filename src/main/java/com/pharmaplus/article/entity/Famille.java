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
@Document("famille")
public class Famille extends AuditModel{

	@Id
	private String id;
	private String libelle;
	private String idUserCrea;
	private String idUserModif;
}
