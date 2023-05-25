package com.pharmaplus.article.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.article.dto.PrincipeActifDTO;
import com.pharmaplus.article.entity.PrincipeActif;
import com.pharmaplus.article.exception.NotFoundException;
import com.pharmaplus.article.repository.PrincipeActifRepository;
import com.pharmaplus.article.service.PrincipeActifService;
import com.pharmaplus.article.utility.ApiResponse;

@RestController
@RequestMapping(value = "/principe-actif")
@CrossOrigin
public class PrincipeActifController {
	
	@Autowired
	PrincipeActifRepository principeActifRepository;
	
	@Autowired
	PrincipeActifService principeActifService;
	
	private static final Logger logger = LoggerFactory.getLogger(PrincipeActifController.class);
	
	
	// Get all PrincipeActif
	@GetMapping("/all")
	public ApiResponse<List<PrincipeActif>> getPrincipeActifs() {
		List<PrincipeActif> principeActifs = principeActifRepository.findAll();
		return new ApiResponse<>(true, "PrincipeActifs found successfully.", principeActifs);
	}
	
	// Add PrincipeActif
	@PostMapping("/add")
	public ApiResponse<PrincipeActifDTO> addPrincipeActif(@RequestBody PrincipeActifDTO principeActifDTO) {
		if(principeActifRepository.existsByLibelle(principeActifDTO.getLibelle())) {
			throw new IllegalArgumentException("Principe Actif exist !!!");
		}
		return new ApiResponse<>(true, "PrincipeActif added successfully. ", principeActifService.savPrincipeActif(principeActifDTO));
	}
	
	// Get PrincipeActif By Id
	@GetMapping("/id/{id}")
	public ApiResponse<PrincipeActif> getPrincipeActifById(@PathVariable String id) throws NotFoundException{
		PrincipeActif principeActif = principeActifRepository.findById(id).orElseThrow(() -> new NotFoundException("PrincipeActif not found for this id :: " + id));
		return new ApiResponse<>(true, "PrincipeActif found successfully.", principeActif);
	}
	
	// Get PrincipeActif By Libelle
	@GetMapping("/libelle/{libelle}")
	public ApiResponse<PrincipeActif> getPrincipeActifByLibelle(@PathVariable String name) throws NotFoundException{
		PrincipeActif principeActif = principeActifRepository.findByLibelle(name).orElseThrow(() -> new NotFoundException("PrincipeActif not found for this name :: " + name));
		return new ApiResponse<>(true, "PrincipeActif found successfully.", principeActif);
	}
	
	// Search PrincipeActif Designation Contains
	@GetMapping("/search/contain/libelle/{libelle}")
	public ApiResponse<List<PrincipeActifDTO>> getPrincipeActifByContainingLibelle(@PathVariable String libelle) throws NotFoundException{
		List<PrincipeActifDTO> principeActifDTO = principeActifService.getPrincipeActifContainingLibelle(libelle);
        return new ApiResponse<>(true, "PrincipeActifs found successfully", principeActifDTO);
	}
	// Update PrincipeActif By Id
	@PutMapping("/{id}")
	public ApiResponse<PrincipeActifDTO> updatePrincipeActif(@PathVariable String id, @RequestBody PrincipeActifDTO principeActifDTO) throws NotFoundException{
		principeActifRepository.findById(id);
		principeActifService.updPrincipeActif(principeActifDTO);
	    return new ApiResponse<>(true, "PrincipeActif updated successfully.", principeActifDTO);
	}
	
	// Delete PrincipeActif By Id
	@DeleteMapping("/{id}")
	public ApiResponse<Void> deletePrincipeActif(@PathVariable("id") String id) {
	    principeActifRepository.deleteById(id);
	    return new ApiResponse<>(true, "PrincipeActif deleted successfully.", null);
	}

}
