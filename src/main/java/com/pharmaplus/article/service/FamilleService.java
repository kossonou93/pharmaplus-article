package com.pharmaplus.article.service;

import java.util.List;
import java.util.Optional;

import com.pharmaplus.article.dto.FamilleDTO;
import com.pharmaplus.article.entity.Famille;

public interface FamilleService {
	
	FamilleDTO savFamille(FamilleDTO familleDTO);
	FamilleDTO updFamille(FamilleDTO familleDTO);
	FamilleDTO softDeleteFamille(FamilleDTO familleDTO);
	FamilleDTO getFamilleDTO(String id);
	Optional<FamilleDTO> getFamilleByLibelle(String libelle);
	List<FamilleDTO> getAllFamilles();
	List<FamilleDTO> getFamilleContainingLibelle(String charactere);
	FamilleDTO convertEntityToDto(Famille famille);
	Famille convertDtoToEntity(FamilleDTO familleDAO);

}
