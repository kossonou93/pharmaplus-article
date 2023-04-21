package com.pharmaplus.article.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pharmaplus.article.entity.Categorie;

public interface CategorieRepository extends MongoRepository<Categorie, String>{

	boolean existsById(String id);
	
	Optional<Categorie> findByName(String name);
	
	@Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
	List<Categorie> findByNameStartingWith(String prefix);
	
	@Query("{'name': {$regex: ?0}}")
	List<Categorie> findByNameContaining(String character);
}
