package com.pharmaplus.article.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmaplus.article.dto.PrincipeActifDTO;
import com.pharmaplus.article.entity.PrincipeActif;
import com.pharmaplus.article.repository.PrincipeActifRepository;
import com.pharmaplus.article.service.PrincipeActifService;

@Service
public class PrincipeActifServiceImpl implements PrincipeActifService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	PrincipeActifRepository principeActifRepository;

	@Override
	public PrincipeActifDTO savPrincipeActif(PrincipeActifDTO principeActifDTO) {
		return convertEntityToDto(principeActifRepository.save(convertDtoToEntity(principeActifDTO)));
	}

	@Override
	public PrincipeActifDTO updPrincipeActif(PrincipeActifDTO principeActifDTO) {
		return convertEntityToDto(principeActifRepository.save(convertDtoToEntity(principeActifDTO)));
	}

	@Override
	public PrincipeActifDTO softDeletePrincipeActif(PrincipeActifDTO principeActifDTO) {
		return convertEntityToDto(principeActifRepository.save(convertDtoToEntity(principeActifDTO)));
	}

	@Override
	public PrincipeActifDTO getPrincipeActifDTO(String id) {
		return convertEntityToDto(principeActifRepository.findById(id).get());
	}

	@Override
	public Optional<PrincipeActifDTO> getPrincipeActifByLibelle(String libelle) {
		return principeActifRepository.findByLibelle(libelle)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public List<PrincipeActifDTO> getAllPrincipeActifs() {
		return principeActifRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<PrincipeActifDTO> getPrincipeActifContainingLibelle(String charactere) {
		return principeActifRepository.findByLibelleContaining(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public PrincipeActifDTO convertEntityToDto(PrincipeActif principeActif) {
		return modelMapper.map(principeActif, PrincipeActifDTO.class);
	}

	@Override
	public PrincipeActif convertDtoToEntity(PrincipeActifDTO principeActifDAO) {
		return modelMapper.map(principeActifDAO, PrincipeActif.class);
	}

}
