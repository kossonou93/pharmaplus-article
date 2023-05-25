package com.pharmaplus.article.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmaplus.article.dto.FamilleDTO;
import com.pharmaplus.article.entity.Famille;
import com.pharmaplus.article.repository.FamilleRepository;
import com.pharmaplus.article.service.FamilleService;

@Service
public class FamilleServiceImpl implements FamilleService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	FamilleRepository familleRepository;

	@Override
	public FamilleDTO savFamille(FamilleDTO familleDTO) {
		return convertEntityToDto(familleRepository.save(convertDtoToEntity(familleDTO)));
	}

	@Override
	public FamilleDTO updFamille(FamilleDTO familleDTO) {
		return convertEntityToDto(familleRepository.save(convertDtoToEntity(familleDTO)));
	}

	@Override
	public FamilleDTO softDeleteFamille(FamilleDTO familleDTO) {
		return convertEntityToDto(familleRepository.save(convertDtoToEntity(familleDTO)));
	}

	@Override
	public FamilleDTO getFamilleDTO(String id) {
		return convertEntityToDto(familleRepository.findById(id).get());
	}

	@Override
	public Optional<FamilleDTO> getFamilleByLibelle(String libelle) {
		return familleRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public List<FamilleDTO> getAllFamilles() {
		return familleRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<FamilleDTO> getFamilleContainingLibelle(String charactere) {
		return familleRepository.findByLibelle(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public FamilleDTO convertEntityToDto(Famille famille) {
		return modelMapper.map(famille, FamilleDTO.class);
	}

	@Override
	public Famille convertDtoToEntity(FamilleDTO familleDAO) {
		return modelMapper.map(familleDAO, Famille.class);
	}

}
