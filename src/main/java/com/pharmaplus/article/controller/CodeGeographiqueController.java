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

import com.pharmaplus.article.dto.CodeGeographiqueDTO;
import com.pharmaplus.article.entity.CodeGeographique;
import com.pharmaplus.article.exception.NotFoundException;
import com.pharmaplus.article.repository.CodeGeographiqueRepository;
import com.pharmaplus.article.service.CodeGeographiqueService;
import com.pharmaplus.article.utility.ApiResponse;

@RestController
@RequestMapping(value = "/code-geographique")
@CrossOrigin
public class CodeGeographiqueController {

	@Autowired
	CodeGeographiqueRepository codeGeographiqueRepository;
	
	@Autowired
	CodeGeographiqueService codeGeographiqueService;
	
	private static final Logger logger = LoggerFactory.getLogger(CodeGeographiqueController.class);
	
	// Get all CodeGeographique
			@GetMapping("/all")
			public ApiResponse<List<CodeGeographique>> getCodeGeographiques() {
				List<CodeGeographique> codeGeographiques = codeGeographiqueRepository.findAll();
				return new ApiResponse<>(true, "CodeGeographiques found successfully.", codeGeographiques);
			}
			
			// Add CodeGeographique
			@PostMapping("/add")
			public ApiResponse<CodeGeographiqueDTO> addCodeGeographique(@RequestBody CodeGeographiqueDTO codeGeographiqueDTO) {
				if(codeGeographiqueRepository.existsByLibelle(codeGeographiqueDTO.getLibelle())) {
					throw new IllegalArgumentException("Code Géographique exist !!!");
				}
				return new ApiResponse<>(true, "CodeGeographique added successfully. ", codeGeographiqueService.savCodeGeographique(codeGeographiqueDTO));
			}
			
			// Get CodeGeographique By Id
			@GetMapping("/id/{id}")
			public ApiResponse<CodeGeographique> getCodeGeographiqueById(@PathVariable String id) throws NotFoundException{
				CodeGeographique codeGeographique = codeGeographiqueRepository.findById(id).orElseThrow(() -> new NotFoundException("CodeGeographique not found for this id :: " + id));
				return new ApiResponse<>(true, "CodeGeographique found successfully.", codeGeographique);
			}
			
			// Get CodeGeographique By IdSecteur
			@GetMapping("/id-secteur/{id}")
			public ApiResponse<List<CodeGeographique>> getCodeGeographiqueByIdSecteur(@PathVariable String idSecteur) throws NotFoundException{
				List<CodeGeographique> codeGeographique = codeGeographiqueRepository.findByIdSecteur(idSecteur);
				return new ApiResponse<>(true, "CodeGeographique found successfully.", codeGeographique);
			}
			
			// Get CodeGeographique By Libelle
			@GetMapping("/libelle/{libelle}")
			public ApiResponse<CodeGeographique> getCodeGeographiqueByLibelle(@PathVariable String libelle) throws NotFoundException{
				CodeGeographique codeGeographique = codeGeographiqueRepository.findByLibelle(libelle).orElseThrow(() -> new NotFoundException("CodeGeographique not found for this libelle :: " + libelle));
				return new ApiResponse<>(true, "CodeGeographique found successfully.", codeGeographique);
			}
			
			// Get CodeGeographique By Parapharmacie
			@GetMapping("/parapharmacie/{parapharmacie}")
			public ApiResponse<List<CodeGeographique>> getCodeGeographiqueByParapharmacie(@PathVariable String parapharmacie) throws NotFoundException{
				List<CodeGeographique> codeGeographique = codeGeographiqueRepository.findByParapharmacie(parapharmacie);
				return new ApiResponse<>(true, "CodeGeographique found successfully.", codeGeographique);
			}
			
			// Search CodeGeographique Libelle Contains
			@GetMapping("/search/contain/libelle/{libelle}")
			public ApiResponse<List<CodeGeographiqueDTO>> getCodeGeographiqueByContainingLibelle(@PathVariable String designation) throws NotFoundException{
				List<CodeGeographiqueDTO> codeGeographiqueDTO = codeGeographiqueService.getCodeGeographiqueContainingLibelle(designation);
		        return new ApiResponse<>(true, "CodeGeographiques found successfully", codeGeographiqueDTO);
			}
			// Update CodeGeographique By Id
			@PutMapping("/{id}")
			public ApiResponse<CodeGeographiqueDTO> updateCodeGeographique(@PathVariable String id, @RequestBody CodeGeographiqueDTO codeGeographiqueDTO) throws NotFoundException{
				codeGeographiqueRepository.findById(id);
				codeGeographiqueService.updCodeGeographique(codeGeographiqueDTO);
			    return new ApiResponse<>(true, "CodeGeographique updated successfully.", codeGeographiqueDTO);
			}
			
			// Delete CodeGeographique By Id
			@DeleteMapping("/{id}")
			public ApiResponse<Void> deleteCodeGeographique(@PathVariable("id") String id) {
			    codeGeographiqueRepository.deleteById(id);
			    return new ApiResponse<>(true, "CodeGeographique deleted successfully.", null);
			}
}
