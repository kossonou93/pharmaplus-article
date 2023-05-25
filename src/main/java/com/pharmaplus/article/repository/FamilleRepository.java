package com.pharmaplus.article.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.article.entity.Famille;

public interface FamilleRepository extends MongoRepository<Famille, String>{

	Optional<Famille> findByLibelle(String libelle);
	Boolean existsByLibelle(String libelle);
	
}
