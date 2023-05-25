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

import com.pharmaplus.article.dto.FournisseurDTO;
import com.pharmaplus.article.entity.Fournisseur;
import com.pharmaplus.article.exception.NotFoundException;
import com.pharmaplus.article.repository.FournisseurRepository;
import com.pharmaplus.article.service.FournisseurService;
import com.pharmaplus.article.utility.ApiResponse;

@RestController
@RequestMapping(value = "/fournisseur")
@CrossOrigin
public class FournisseurController {
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	@Autowired
	private FournisseurService fournisseurService;
	
	private static final Logger logger = LoggerFactory.getLogger(FournisseurController.class);

	// Get all Fournisseur
	@GetMapping("/all")
	public ApiResponse<List<Fournisseur>> getFournisseurs() {
		List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
		return new ApiResponse<>(true, "Fournisseurs found successfully.", fournisseurs);
	}
	
	// Add Fournisseur
	@PostMapping("/add")
	public ApiResponse<FournisseurDTO> addFournisseur(@RequestBody FournisseurDTO fournisseurDTO) {
		if(fournisseurRepository.existsByNom(fournisseurDTO.getNom())) {
			throw new IllegalArgumentException("Fournisseur Exist !!!");
		}
        return new ApiResponse<>(true, "Fournisseur save Successfully.", fournisseurService.savFournisseur(fournisseurDTO));
	}
	
	// Get Fournisseur By Id
	@GetMapping("/id/{id}")
	public ApiResponse<Fournisseur> getFournisseurById(@PathVariable String id) throws NotFoundException{
		Fournisseur fournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new NotFoundException("Fournisseur not found for this id :: " + id));
		return new ApiResponse<>(true, "Fournisseur found successfully.", fournisseur);
	}
	
	// Get Fournisseur By Identifiant
	@GetMapping("/identifiant/{identifiant}")
	public ApiResponse<Fournisseur> getFournisseurByIdentifiant(@PathVariable String identifiant) throws NotFoundException{
		Fournisseur fournisseur = fournisseurRepository.findByIdentifiant(identifiant).orElseThrow(() -> new NotFoundException("fournisseur not found for this identifiant :: " + identifiant));
		logger.info("categorie ==> " + fournisseur); 
		return new ApiResponse<>(true, "Fournisseur found successfully.", fournisseur);
	}
	
	// Search Fournisseur Name Contains
	@GetMapping("/search/contain/nom/{nom}")
	public ApiResponse<List<FournisseurDTO>> getFournisseurByContainingNom(@PathVariable String name) throws NotFoundException{
		List<FournisseurDTO> fournisseurDTO = fournisseurService.getFournisseurContainingNom(name);
		logger.info("fournisseur ==> " + fournisseurDTO); 
        return new ApiResponse<>(true, "Fournisseurs found successfully .", fournisseurDTO);
	}
	
	// Search Fournisseur Identifiant Contains
	@GetMapping("/search/contain/identifiant/{identifiant}")
	public ApiResponse<List<FournisseurDTO>> getFournisseurByContainingIdentifiant(@PathVariable String identifiant) throws NotFoundException{
		List<FournisseurDTO> fournisseurDTO = fournisseurService.getFournisseurContainingIdentifiant(identifiant);
		logger.info("fournisseur ==> " + fournisseurDTO); 
        return new ApiResponse<>(true, "Fournisseurs found successfully .", fournisseurDTO);
	}
	
	// Search Fournisseur Code Contains
	@GetMapping("/search/contain/code/{code}")
	public ApiResponse<List<FournisseurDTO>> getFournisseurByContainingCode(@PathVariable String code) throws NotFoundException{
		List<FournisseurDTO> fournisseurDTO = fournisseurService.getFournisseurContainingCode(code);
		logger.info("fournisseur ==> " + fournisseurDTO); 
        return new ApiResponse<>(true, "Fournisseurs found successfully .", fournisseurDTO);
	}
	
	// Search Fournisseur Telephone Contains
	@GetMapping("/search/contain/telephone/{telephone}")
	public ApiResponse<List<FournisseurDTO>> getFournisseurByContainingTelephone(@PathVariable String telephone) throws NotFoundException{
		List<FournisseurDTO> fournisseurDTO = fournisseurService.getFournisseurContainingTelephone(telephone);
		logger.info("fournisseur ==> " + fournisseurDTO); 
        return new ApiResponse<>(true, "Fournisseurs found successfully .", fournisseurDTO);
	}
	
	// Search Fournisseur Mobile Contains
	@GetMapping("/search/contain/mobile/{mobile}")
	public ApiResponse<List<FournisseurDTO>> getFournisseurByContainingMobile(@PathVariable String mobile) throws NotFoundException{
		List<FournisseurDTO> fournisseurDTO = fournisseurService.getFournisseurContainingMobile(mobile);
		logger.info("fournisseur ==> " + fournisseurDTO); 
        return new ApiResponse<>(true, "Fournisseurs found successfully .", fournisseurDTO);
	}
		
	// Get Fournisseur By Email
	@GetMapping("/email/{email}")
	public ApiResponse<Fournisseur> getFournisseurByEmail(@PathVariable String email) throws NotFoundException{
		Fournisseur fournisseur = fournisseurRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("fournisseur not found for this email :: " + email));
		logger.info("founisseur ==> " + fournisseur); 
		return new ApiResponse<>(true, "Fournisseur found successfully.", fournisseur);
	}
	
	// Get Fournisseur By Telephone
	@GetMapping("/search/{telephone}")
	public ApiResponse<Fournisseur> getFournisseurByTelephone(@PathVariable String telephone) throws NotFoundException{
		Fournisseur fournisseur = fournisseurRepository.findByTelephone(telephone).orElseThrow(() -> new NotFoundException("fournisseur not found for this telephone :: " + telephone));
		logger.info("fournisseur ==> " + fournisseur); 
		return new ApiResponse<>(true, "Fournisseur found successfully.", fournisseur);
	}	
	
	
	
	// Update Fournisseur By Id
	@PutMapping("/{id}")
	public ApiResponse<FournisseurDTO> updateFournisseur(@PathVariable("id") String id, @RequestBody FournisseurDTO fournisseurDTO) throws NotFoundException{
	    Fournisseur updatedFournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new NotFoundException("Fournisseur not found for this id :: " + id));
	    logger.info("fournisseur ==> " + updatedFournisseur); 
	    fournisseurService.updFournisseur(fournisseurDTO);
	    return new ApiResponse<>(true, "Fournisseur updated successfully.", fournisseurDTO);
	}
	
	// Delete Fournisseur By Id
	@DeleteMapping("/{id}")
	public ApiResponse<Void> deleteFournisseur(@PathVariable("id") String id) {
	    fournisseurRepository.deleteById(id);
	    return new ApiResponse<>(true, "Fournisseur deleted successfully.", null);
	}
	
	// Soft Delete Fournisseur By Id
	@PutMapping("/soft-delete/{id}")
	public ApiResponse<FournisseurDTO> softDelete(@PathVariable String id){
		Fournisseur fournisseur = fournisseurRepository.findById(id).get();
		FournisseurDTO fournisseurDTO = fournisseurService.convertEntityToDto(fournisseur);
		fournisseurDTO.setEnable(true);
		return new ApiResponse<>(true, "Fournisseur soft deleted successfully.", fournisseurService.softDeleteFournisseur(fournisseurDTO));
	}

}
