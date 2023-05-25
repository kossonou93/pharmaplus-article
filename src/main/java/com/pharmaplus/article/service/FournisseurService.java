package com.pharmaplus.article.service;

import java.util.List;
import java.util.Optional;

import com.pharmaplus.article.dto.FournisseurDTO;
import com.pharmaplus.article.entity.Fournisseur;

public interface FournisseurService {
	
	FournisseurDTO savFournisseur(FournisseurDTO fournisseurDTO);
	FournisseurDTO updFournisseur(FournisseurDTO fournisseurDTO);
	FournisseurDTO softDeleteFournisseur(FournisseurDTO fournisseurDTO);
	FournisseurDTO getFournisseurDTO(String id);
	Optional<FournisseurDTO> getFournisseurByNom(String nom);
	Optional<FournisseurDTO> getFournisseurByIdentifiant(String identifiant);
	Optional<FournisseurDTO> getFournisseurByCode(String code);
	Optional<FournisseurDTO> getFournisseurByTelephone(String telephone);
	Optional<FournisseurDTO> getFournisseurByMobile(String mobile);
	Optional<FournisseurDTO> getFournisseurByEmail(String email);
	List<FournisseurDTO> getAllFournisseurs();
	List<FournisseurDTO> getFournisseurContainingNom(String charactere);
	List<FournisseurDTO> getFournisseurContainingCode(String charactere);
	List<FournisseurDTO> getFournisseurContainingTelephone(String charactere);
	List<FournisseurDTO> getFournisseurContainingMobile(String charactere);
	List<FournisseurDTO> getFournisseurContainingIdentifiant(String charactere);
	FournisseurDTO convertEntityToDto(Fournisseur fournisseur);
	Fournisseur convertDtoToEntity(FournisseurDTO fournisseurDTO);

}
