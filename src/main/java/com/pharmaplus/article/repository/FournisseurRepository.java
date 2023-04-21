package com.pharmaplus.article.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.article.entity.Fournisseur;

public interface FournisseurRepository extends MongoRepository<Fournisseur, String>{
	
	boolean existsById(String id);
	
	Optional<Fournisseur> findByEmail(String email);
	
	Optional<Fournisseur> findByIdentifiant(String identifiant);
	
	Optional<Fournisseur> findByTelephone(String telephone);

	@Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
	List<Fournisseur> findByFirstNameStartingWith(String prefix);
	
	@Query("{'name': {$regex: ?0}}")
	List<Fournisseur> findByFirstNameContaining(String character);
	
	@Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
	List<Fournisseur> findByLastNameStartingWith(String prefix);
	
	@Query("{'name': {$regex: ?0}}")
	List<Fournisseur> findByLastNameContaining(String character);
}
