package com.pharmaplus.article.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {
	
	private String id;
	private String idFamille;
	private String idPrincipeActif																																																																																																																																																																																																																																																																																																																																																																							;
	private String idCodeGeographique;
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
	private String userCreaId;
	private String userModifId;
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
