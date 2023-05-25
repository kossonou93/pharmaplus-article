package com.pharmaplus.article.service;

import java.util.List;
import java.util.Optional;

import com.pharmaplus.article.dto.PrincipeActifDTO;
import com.pharmaplus.article.entity.PrincipeActif;

public interface PrincipeActifService {
	
	PrincipeActifDTO savPrincipeActif(PrincipeActifDTO principeActifDTO);
	PrincipeActifDTO updPrincipeActif(PrincipeActifDTO principeActifDTO);
	PrincipeActifDTO softDeletePrincipeActif(PrincipeActifDTO principeActifDTO);
	PrincipeActifDTO getPrincipeActifDTO(String id);
	Optional<PrincipeActifDTO> getPrincipeActifByLibelle(String libelle);
	List<PrincipeActifDTO> getAllPrincipeActifs();
	List<PrincipeActifDTO> getPrincipeActifContainingLibelle(String charactere);
	PrincipeActifDTO convertEntityToDto(PrincipeActif principeActif);
	PrincipeActif convertDtoToEntity(PrincipeActifDTO principeActifDAO);

}
