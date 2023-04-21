package com.pharmaplus.article.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.article.entity.Article;

public interface ArticleRepository extends MongoRepository<Article, String>{
	
	Optional<Article> findByName(String name);
	
	@Query("{'price': {$regex: ?0}}")
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
	
	@Query("{'name': {$regex: ?0}}")
	List<Article> findByNameContaining(String character);

}
