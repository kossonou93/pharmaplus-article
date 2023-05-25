package com.pharmaplus.article.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmaplus.article.dto.CodeGeographiqueDTO;
import com.pharmaplus.article.entity.CodeGeographique;
import com.pharmaplus.article.repository.CodeGeographiqueRepository;
import com.pharmaplus.article.service.CodeGeographiqueService;

@Service
public class CodeGeographiqueServiceImpl implements CodeGeographiqueService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	CodeGeographiqueRepository codeGeographiqueRepository;

	@Override
	public CodeGeographiqueDTO savCodeGeographique(CodeGeographiqueDTO codeGeographiqueDTO) {
		return convertEntityToDto(codeGeographiqueRepository.save(convertDtoToEntity(codeGeographiqueDTO)));
	}

	@Override
	public CodeGeographiqueDTO updCodeGeographique(CodeGeographiqueDTO codeGeographiqueDTO) {
		return convertEntityToDto(codeGeographiqueRepository.save(convertDtoToEntity(codeGeographiqueDTO)));
	}

	@Override
	public CodeGeographiqueDTO softDeleteCodeGeographique(CodeGeographiqueDTO codeGeographiqueDTO) {
		return convertEntityToDto(codeGeographiqueRepository.save(convertDtoToEntity(codeGeographiqueDTO)));
	}

	@Override
	public CodeGeographiqueDTO getCodeGeographiqueDTO(String id) {
		return convertEntityToDto(codeGeographiqueRepository.findById(id).get());
	}

	@Override
	public Optional<CodeGeographiqueDTO> getCodeGeographiqueByLibelle(String libelle) {
		return codeGeographiqueRepository.findByLibelle(libelle)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public List<CodeGeographiqueDTO> getCodeGeographiqueByParapharmacie(String parapharmacie) {
		return codeGeographiqueRepository.findByParapharmacie(parapharmacie)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<CodeGeographiqueDTO> getCodeGeographiqueByIdSecteur(String idSecteur) {
		return codeGeographiqueRepository.findByIdSecteur(idSecteur)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<CodeGeographiqueDTO> getAllCodeGeographiques() {
		return codeGeographiqueRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<CodeGeographiqueDTO> getCodeGeographiqueContainingLibelle(String charactere) {
		return codeGeographiqueRepository.findByLibelleContaining(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public CodeGeographiqueDTO convertEntityToDto(CodeGeographique codeGeographique) {
		return modelMapper.map(codeGeographique, CodeGeographiqueDTO.class);
	}

	@Override
	public CodeGeographique convertDtoToEntity(CodeGeographiqueDTO codeGeographiqueDAO) {
		return modelMapper.map(codeGeographiqueDAO, CodeGeographique.class);
	}

}
