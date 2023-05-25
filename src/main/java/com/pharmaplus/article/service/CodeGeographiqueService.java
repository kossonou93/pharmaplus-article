package com.pharmaplus.article.service;

import java.util.List;
import java.util.Optional;

import com.pharmaplus.article.dto.CodeGeographiqueDTO;
import com.pharmaplus.article.entity.CodeGeographique;

public interface CodeGeographiqueService {
	
	CodeGeographiqueDTO savCodeGeographique(CodeGeographiqueDTO codeGeographiqueDTO);
	CodeGeographiqueDTO updCodeGeographique(CodeGeographiqueDTO codeGeographiqueDTO);
	CodeGeographiqueDTO softDeleteCodeGeographique(CodeGeographiqueDTO codeGeographiqueDTO);
	CodeGeographiqueDTO getCodeGeographiqueDTO(String id);
	Optional<CodeGeographiqueDTO> getCodeGeographiqueByLibelle(String libelle);
	List<CodeGeographiqueDTO> getCodeGeographiqueByParapharmacie(String parapharmacie);
	List<CodeGeographiqueDTO> getCodeGeographiqueByIdSecteur(String idSecteur);
	List<CodeGeographiqueDTO> getAllCodeGeographiques();
	List<CodeGeographiqueDTO> getCodeGeographiqueContainingLibelle(String charactere);
	CodeGeographiqueDTO convertEntityToDto(CodeGeographique codeGeographique);
	CodeGeographique convertDtoToEntity(CodeGeographiqueDTO codeGeographiqueDAO);

}
