package com.pharmaplus.article.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.article.entity.PrincipeActif;

public interface PrincipeActifRepository extends MongoRepository<PrincipeActif, String>{

	Optional<PrincipeActif> findByLibelle(String libelle);
	@Query("{'libelle': {$regex: ?0}")
	List<PrincipeActif> findByLibelleContaining(String character);
	Boolean existsByLibelle(String libelle);
}
