package com.pharmaplus.article.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.article.entity.CodeGeographique;

public interface CodeGeographiqueRepository extends MongoRepository<CodeGeographique, String>{
	Optional<CodeGeographique> findByLibelle(String libelle);
	@Query("{'libelle': {$regex: ?0}")
	List<CodeGeographique> findByLibelleContaining(String character);
	List<CodeGeographique> findByIdSecteur(String idSecteur);
	List<CodeGeographique> findByParapharmacie(String parapharmacie);
	Boolean existsByLibelle(String libelle);
	
}
