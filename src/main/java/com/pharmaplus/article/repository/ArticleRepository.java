package com.pharmaplus.article.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.article.entity.Article;

public interface ArticleRepository extends MongoRepository<Article, String>{
	
	Optional<Article> findByDesignation(String designation);
	
	Optional<Article> findByCode1(String code1);
	
	Optional<Article> findByCode2(String code2);
	
	Optional<Article> findByCode3(String code3);
	
	List<Article> findByIdFamille(String idFamille);
	
	List<Article> findByIdCodeGeographique(String idCodeGeographique);
	
	List<Article> findByIdPrincipeActif(String idPrincipeActif);
	
	@Query("{'designation': {$regex: ?0}")
	List<Article> findByDesignationContaining(String character);
	
	@Query("{$or: ["
            + "{'code1': {$regex: ?0, $options: 'i'}}, "
            + "{'code2': {$regex: ?0, $options: 'i'}}, "
            + "{'code3': {$regex: ?0, $options: 'i'}}"
            + "]}")
    List<Article> Designation(String searchTerm);
	
	Boolean existsByDesignation(String designation);
	
	/*@Query("{'price': {$regex: ?0}}")
	List<Article> findByPrice(Double price);
	
	@Query("{'quantity': {$regex: ?0}}")
	List<Article> findByQuantity(Integer quantity);
	
	@Query("{'price': {$gt: ?0}}")
	List<Article> findByPriceGreaterThan(Double price);
	
	@Query("{'price': {$lt: ?0}}")
	List<Article> findByPriceLessThan(Double price);
	
	@Query("{'quantity': {$gt: ?0}}")
	List<Article> findByQuantityGreaterThan(Integer price);
	
	@Query("{'quantity': {$lt: ?0}}")
	List<Article> findByQuantityLessThan(Integer price);
	
	@Query("{'categorie': ?0}")
	List<Article> findByCategorie(String categorie);
	
	@Query("{'fournisseur': ?0}")
	List<Article> findByFournisseur(String fournisseur);
	
	@Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
	List<Article> findByNameStartingWith(String prefix);
	
	@Query("{'name': {$regex: ?0}")
	List<Article> findByNameContaining(String character);*/
	
	@Query("{'enable': ?0}")
	List<Article> findByEnable(Boolean enable);

}
