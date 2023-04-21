package com.pharmaplus.article.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.article.entity.Categorie;
import com.pharmaplus.article.exception.NotFoundException;
import com.pharmaplus.article.repository.CategorieRepository;
import com.pharmaplus.article.utility.ApiResponse;

@RestController
@RequestMapping(value = "/categorie")
public class CategorieController {
	
	@Autowired
	CategorieRepository categorieRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CategorieController.class);
	
	// Get all Categorie
		@GetMapping("/all")
		public ApiResponse<List<Categorie>> getCategories() {
			List<Categorie> categories = categorieRepository.findAll();
			logger.info("categorie ==> " + categories);
			return new ApiResponse<>(true, "Categories found successfully.", categories);
		}
		
		// Add Categorie
		@PostMapping("/add")
		public ApiResponse<Categorie> addCategorie(@RequestBody Categorie categorie) {
			Categorie savedCategorie = categorieRepository.save(categorie);
			logger.info("categorie ==> " + savedCategorie);
	        return new ApiResponse<>(true, "Categorie save Successfully.", savedCategorie);
		}
		
		// Get Categorie By Id
		@GetMapping("/id/{id}")
		public ApiResponse<Categorie> getCategorieById(@PathVariable String id) throws NotFoundException{
			Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new NotFoundException("Categorie not found for this id :: " + id));
			logger.info("categorie ==> " + categorie); 
			return new ApiResponse<>(true, "Categorie found successfully.", categorie);
		}
		
		// Get Categorie By Name
		@GetMapping("/name/{name}")
		public ApiResponse<Categorie> getCategorieByName(@PathVariable String name) throws NotFoundException{
			Categorie categorie = categorieRepository.findByName(name).orElseThrow(() -> new NotFoundException("Categorie not found for this id :: " + name));
			logger.info("categorie ==> " + categorie); 
			return new ApiResponse<>(true, "Categorie found successfully.", categorie);
		}
		
		// Search Categorie Name Start by 
		@GetMapping("/recherche/start/{name}")
		public ApiResponse<List<Categorie>> getCategorieByStartingName(@PathVariable String name) throws NotFoundException{
			List<Categorie> categories = categorieRepository.findByNameStartingWith(name);//.orElseThrow(() -> new NotFoundException("Categorie not found for this id :: " + name));
			ApiResponse<List<Categorie>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("Categorie with name starting with " + name);
	        response.setData(categories);
	        logger.info("categorie ==> " + response.getData()); 
	        return response;
		}
		
		// Search Categorie Name Contains
		@GetMapping("/recherche/contain/{name}")
		public ApiResponse<List<Categorie>> getCategorieByContainingName(@PathVariable String name) throws NotFoundException{
			List<Categorie> categories = categorieRepository.findByNameContaining(name);//.orElseThrow(() -> new NotFoundException("Categorie not found for this id :: " + name)); 
			ApiResponse<List<Categorie>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("Categorie with name starting with " + name);
	        response.setData(categories);
	        logger.info("categorie ==> " + response.getData());
	        return response;
		}
		
		// Update Categorie By Id
		@PutMapping("/{id}")
		public ApiResponse<Categorie> updateCategorie(@PathVariable("id") String id, @RequestBody Categorie categorie) throws NotFoundException{
		    Categorie updatedCategorie = categorieRepository.findById(id).orElseThrow(() -> new NotFoundException("Categorie not found for this id :: " + id));
		    updatedCategorie.setName(categorie.getName());
		    logger.info("categorie ==> " + updatedCategorie);
		    return new ApiResponse<>(true, "Categorie updated successfully.", updatedCategorie);
		}
		
		// Delete Categorie By Id
		@DeleteMapping("/{id}")
		public ApiResponse<Void> deleteCategorie(@PathVariable("id") String id) {
		    categorieRepository.deleteById(id);
		    logger.info("categorie ==> " + null);
		    return new ApiResponse<>(true, "Categorie deleted successfully.", null);
		}

		public static Logger getLogger() {
			return logger;
		}


}
