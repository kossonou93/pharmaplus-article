package com.pharmaplus.article.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.article.entity.Fournisseur;

public interface FournisseurRepository extends MongoRepository<Fournisseur, String>{
	
	boolean existsById(String id);
	
	Optional<Fournisseur> findByNom(String nom);
	
	Optional<Fournisseur> findByEmail(String email);
	
	Optional<Fournisseur> findByIdentifiant(String identifiant);
	
	Optional<Fournisseur> findByTelephone(String telephone);
	
	Optional<Fournisseur> findByMobile(String mobile);
	
	Optional<Fournisseur> findByCode(String code);

	@Query("{ 'nom' : { $regex: ?0, $options: 'i' } }")
	List<Fournisseur> findByNomStartingWith(String prefix);
	
	@Query("{'nom': {$regex: ?0}}")
	List<Fournisseur> findByNomContaining(String character);
	
	@Query("{'identifiant': {$regex: ?0}}")
	List<Fournisseur> findByIdentifiantContaining(String character);
	
	@Query("{'telephone': {$regex: ?0}}")
	List<Fournisseur> findByTelephoneContaining(String character);
	
	@Query("{'mobile': {$regex: ?0}}")
	List<Fournisseur> findByMobileContaining(String character);
	
	@Query("{'code': {$regex: ?0}}")
	List<Fournisseur> findByCodeContaining(String character);
	
	Boolean existsByNom(String nom);
	
	@Query("{'enable': ?0}")
	List<Fournisseur> findByEnable(Boolean enable);
}
