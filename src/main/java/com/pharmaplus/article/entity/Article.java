package com.pharmaplus.article.entity;

import java.math.BigDecimal;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pharmaplus.article.entity.Article;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document("article")
public class Article extends AuditModel{
	
	@Id
	private String id;
	private String idFamille;
	private String idCodeGeographique;
	private String idPrincipeActif;
	private String designation;
	private BigDecimal prixAchatHtEntier;
	private BigDecimal prixAchatTtcEntier;
	private BigDecimal prixVenteTtcEntier;
	private Boolean appliquerTvaEntier;
	private Boolean articleHorsRemiseEntier;
	private BigDecimal prixAchatHtDetail;
	private BigDecimal prixAchatTtcDetail;
	private BigDecimal prixVenteTtcDetail;
	private Boolean appliquerTvaDetail;
	private Boolean articleHorsRemiseDetail;
	private Integer stockMini;
	private Integer stockMaxi;
	private Integer code1;
	private Integer code2;
	private Integer code3;
	private Boolean nonServiSurBon;
	private Integer stockDernierInventaire;
	private String idUserCrea;
	private String idUserModif;
	private Boolean enable;
	private String idArticlePrincipal;
	private String contenanceArticlePrincipal;
	private BigDecimal prixPc;
	private String commentaire;
	private Boolean parapharmacie;
	private Boolean produitDangereux;
	private Boolean datePeremptionObligatoire;
	private Integer quotaVenteArticle;
	private Integer quotaRemiseArticle;
	private Integer quantiteEntier;
	private Integer quantiteDetail;
	private Integer moyenneVente;
	private Boolean accessoire;
	private Boolean cmu;
	private Integer margeCfa;
	private Integer tauxMarge;
	private Integer tauxMarque;
	private Integer seuilDeSecurite;
	private Integer seuilDeReaprovis;
	private Integer idTaxe;
}
