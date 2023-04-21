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
import com.pharmaplus.article.entity.Fournisseur;
import com.pharmaplus.article.exception.NotFoundException;
import com.pharmaplus.article.repository.FournisseurRepository;
import com.pharmaplus.article.utility.ApiResponse;

@RestController
@RequestMapping(value = "/fournisseur")
@CrossOrigin
public class FournisseurController {
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(FournisseurController.class);

	// Get all Fournisseur
		@GetMapping("/all")
		public ApiResponse<List<Fournisseur>> getFournisseurs() {
			List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
			return new ApiResponse<>(true, "Fournisseurs found successfully.", fournisseurs);
		}
		
		// Add Fournisseur
		@PostMapping("/add")
		public ApiResponse<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur) {
			Fournisseur savedFournisseur = fournisseurRepository.save(fournisseur);
	        return new ApiResponse<>(true, "Fournisseur save Successfully.", savedFournisseur);
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
		
		// Search Fournisseur FirstName Start by 
		@GetMapping("/search/start/firstname/{name}")
		public ApiResponse<List<Fournisseur>> getFournisseurByStartingFirstName(@PathVariable String name) throws NotFoundException{
			List<Fournisseur> fournisseurs = fournisseurRepository.findByFirstNameStartingWith(name);
			ApiResponse<List<Fournisseur>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("fournisseur with name starting with " + name);
	        response.setData(fournisseurs);
	        logger.info("fournisseur ==> " + response.getData()); 
	        return response;
		}
		
		// Search Fournisseur FirstName Contains
		@GetMapping("/search/contain/firstname/{name}")
		public ApiResponse<List<Fournisseur>> getFournisseurByContainingFirstName(@PathVariable String name) throws NotFoundException{
			List<Fournisseur> fournisseurs = fournisseurRepository.findByFirstNameContaining(name);
			ApiResponse<List<Fournisseur>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("fournisseur with name starting with " + name);
	        response.setData(fournisseurs);
	        logger.info("fournisseur ==> " + response.getData());
	        return response;
		}
			
		// Get Fournisseur By Email
		@GetMapping("/email/{email}")
		public ApiResponse<Fournisseur> getFournisseurByEmail(@PathVariable String email) throws NotFoundException{
			Fournisseur fournisseur = fournisseurRepository.findByIdentifiant(email).orElseThrow(() -> new NotFoundException("fournisseur not found for this email :: " + email));
			logger.info("categorie ==> " + fournisseur); 
			return new ApiResponse<>(true, "Fournisseur found successfully.", fournisseur);
		}
		
		// Get Fournisseur By Telephone
		@GetMapping("/search/{telephone}")
		public ApiResponse<Fournisseur> getFournisseurByTelephone(@PathVariable String telephone) throws NotFoundException{
			Fournisseur fournisseur = fournisseurRepository.findByTelephone(telephone).orElseThrow(() -> new NotFoundException("fournisseur not found for this telephone :: " + telephone));
			logger.info("categorie ==> " + fournisseur); 
			return new ApiResponse<>(true, "Fournisseur found successfully.", fournisseur);
		}
		
		// Search Fournisseur LastName Start by 
		@GetMapping("/search/start/lastname/{name}")
		public ApiResponse<List<Fournisseur>> getFournisseurByStartingLastName(@PathVariable String name) throws NotFoundException{
			List<Fournisseur> fournisseurs = fournisseurRepository.findByLastNameStartingWith(name);
			ApiResponse<List<Fournisseur>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("fournisseur with name starting with " + name);
	        response.setData(fournisseurs);
	        logger.info("fournisseur ==> " + response.getData()); 
	        return response;
		}
		
		// Search Fournisseur LastName Contains
		@GetMapping("/search/contain/lastname/{name}")
		public ApiResponse<List<Fournisseur>> getCategorieByContainingName(@PathVariable String name) throws NotFoundException{
			List<Fournisseur> fournisseurs = fournisseurRepository.findByFirstNameContaining(name);
			ApiResponse<List<Fournisseur>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("fournisseur with name starting with " + name);
	        response.setData(fournisseurs);
	        logger.info("fournisseur ==> " + response.getData());
	        return response;
		}
		
		// Update Fournisseur By Id
		@PutMapping("/{id}")
		public ApiResponse<Fournisseur> updateFournisseur(@PathVariable("id") String id, @RequestBody Fournisseur fournisseur) throws NotFoundException{
		    Fournisseur updatedFournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new NotFoundException("Fournisseur not found for this id :: " + id));
		    updatedFournisseur.setAdresse(fournisseur.getAdresse());
		    updatedFournisseur.setEmail(fournisseur.getEmail());
		    updatedFournisseur.setFirstName(fournisseur.getFirstName());
		    updatedFournisseur.setLastName(fournisseur.getLastName());
		    updatedFournisseur.setIdentifiant(fournisseur.getIdentifiant());
		    updatedFournisseur.setTelephone(fournisseur.getTelephone());
		    return new ApiResponse<>(true, "Fournisseur updated successfully.", updatedFournisseur);
		}
		
		// Delete Fournisseur By Id
		@DeleteMapping("/{id}")
		public ApiResponse<Void> deleteFournisseur(@PathVariable("id") String id) {
		    fournisseurRepository.deleteById(id);
		    return new ApiResponse<>(true, "Fournisseur deleted successfully.", null);
		}

}
