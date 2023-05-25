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
import com.pharmaplus.article.dto.FamilleDTO;
import com.pharmaplus.article.entity.Famille;
import com.pharmaplus.article.exception.NotFoundException;
import com.pharmaplus.article.repository.FamilleRepository;
import com.pharmaplus.article.service.FamilleService;
import com.pharmaplus.article.utility.ApiResponse;

@RestController
@RequestMapping(value = "/famille")
@CrossOrigin
public class FamilleController {
	
	@Autowired
	FamilleRepository familleRepository;
	
	@Autowired
	FamilleService familleService;
	
	private static final Logger logger = LoggerFactory.getLogger(FamilleController.class);
	
	
	// Get all Famille
		@GetMapping("/all")
		public ApiResponse<List<Famille>> getFamilles() {
			List<Famille> familles = familleRepository.findAll();
			return new ApiResponse<>(true, "Familles found successfully.", familles);
		}
		
		// Add Famille
		@PostMapping("/add")
		public ApiResponse<FamilleDTO> addFamille(@RequestBody FamilleDTO familleDTO) throws NotFoundException {
			if(familleRepository.existsByLibelle(familleDTO.getLibelle())){
				throw new IllegalArgumentException("Famille exist !!!");
			}
			return new ApiResponse<>(true, "Famille added successfully. ", familleService.savFamille(familleDTO));
		}
		
		// Get Famille By Id
		@GetMapping("/id/{id}")
		public ApiResponse<Famille> getFamilleById(@PathVariable String id) throws NotFoundException{
			Famille famille = familleRepository.findById(id).orElseThrow(() -> new NotFoundException("Famille not found for this id :: " + id));
			return new ApiResponse<>(true, "Famille found successfully.", famille);
		}
		
		// Get Famille By Designation
		@GetMapping("/designation/{designation}")
		public ApiResponse<Famille> getFamilleByLibelle(@PathVariable String name) throws NotFoundException{
			Famille famille = familleRepository.findByLibelle(name).orElseThrow(() -> new NotFoundException("Famille not found for this name :: " + name));
			return new ApiResponse<>(true, "Famille found successfully.", famille);
		}
		
		// Search Famille Designation Contains
		@GetMapping("/search/contain/libelle/{libelle}")
		public ApiResponse<List<FamilleDTO>> getFamilleByContainingLibelle(@PathVariable String designation) throws NotFoundException{
			List<FamilleDTO> familleDTO = familleService.getFamilleContainingLibelle(designation);
	        return new ApiResponse<>(true, "Familles found successfully", familleDTO);
		}
		// Update Famille By Id
		@PutMapping("/{id}")
		public ApiResponse<FamilleDTO> updateFamille(@PathVariable String id, @RequestBody FamilleDTO familleDTO) throws NotFoundException{
			familleRepository.findById(id);
			familleService.updFamille(familleDTO);
		    return new ApiResponse<>(true, "Famille updated successfully.", familleDTO);
		}
		
		// Delete Famille By Id
		@DeleteMapping("/{id}")
		public ApiResponse<Void> deleteFamille(@PathVariable("id") String id) {
		    familleRepository.deleteById(id);
		    return new ApiResponse<>(true, "Famille deleted successfully.", null);
		}

}
