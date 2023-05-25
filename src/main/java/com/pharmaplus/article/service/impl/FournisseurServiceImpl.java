package com.pharmaplus.article.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmaplus.article.dto.FournisseurDTO;
import com.pharmaplus.article.entity.Fournisseur;
import com.pharmaplus.article.repository.FournisseurRepository;
import com.pharmaplus.article.service.FournisseurService;

@Service
public class FournisseurServiceImpl implements FournisseurService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	FournisseurRepository fournisseurRepository;

	@Override
	public FournisseurDTO savFournisseur(FournisseurDTO fournisseurDTO) {
		return convertEntityToDto(fournisseurRepository.save(convertDtoToEntity(fournisseurDTO)));
	}

	@Override
	public FournisseurDTO updFournisseur(FournisseurDTO fournisseurDTO) {
		return convertEntityToDto(fournisseurRepository.save(convertDtoToEntity(fournisseurDTO)));
	}

	@Override
	public FournisseurDTO softDeleteFournisseur(FournisseurDTO fournisseurDTO) {
		return convertEntityToDto(fournisseurRepository.save(convertDtoToEntity(fournisseurDTO)));
	}

	@Override
	public FournisseurDTO getFournisseurDTO(String id) {
		return convertEntityToDto(fournisseurRepository.findById(id).get());
	}

	@Override
	public Optional<FournisseurDTO> getFournisseurByNom(String nom) {
		return fournisseurRepository.findByNom(nom)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public Optional<FournisseurDTO> getFournisseurByIdentifiant(String identifiant) {
		return fournisseurRepository.findByIdentifiant(identifiant)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public Optional<FournisseurDTO> getFournisseurByCode(String code) {
		return fournisseurRepository.findByCode(code)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public Optional<FournisseurDTO> getFournisseurByTelephone(String telephone) {
		return fournisseurRepository.findByTelephone(telephone)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public Optional<FournisseurDTO> getFournisseurByMobile(String mobile) {
		return fournisseurRepository.findByMobile(mobile)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public Optional<FournisseurDTO> getFournisseurByEmail(String email) {
		return fournisseurRepository.findByEmail(email)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public List<FournisseurDTO> getAllFournisseurs() {
		return fournisseurRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<FournisseurDTO> getFournisseurContainingNom(String charactere) {
		return fournisseurRepository.findByNomContaining(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<FournisseurDTO> getFournisseurContainingTelephone(String charactere) {
		return fournisseurRepository.findByTelephoneContaining(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<FournisseurDTO> getFournisseurContainingMobile(String charactere) {
		return fournisseurRepository.findByMobileContaining(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<FournisseurDTO> getFournisseurContainingIdentifiant(String charactere) {
		return fournisseurRepository.findByIdentifiantContaining(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public FournisseurDTO convertEntityToDto(Fournisseur fournisseur) {
		return modelMapper.map(fournisseur, FournisseurDTO.class);
	}

	@Override
	public Fournisseur convertDtoToEntity(FournisseurDTO fournisseurDTO) {
		return modelMapper.map(fournisseurDTO, Fournisseur.class);
	}

	@Override
	public List<FournisseurDTO> getFournisseurContainingCode(String charactere) {
		return fournisseurRepository.findByCodeContaining(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

}
