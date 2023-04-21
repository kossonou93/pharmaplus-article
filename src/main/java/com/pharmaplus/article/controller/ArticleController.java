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
import com.pharmaplus.article.repository.ArticleRepository;
import com.pharmaplus.article.repository.CategorieRepository;
import com.pharmaplus.article.repository.FournisseurRepository;
import com.pharmaplus.article.request.ArticleRequest;
import com.pharmaplus.article.entity.Article;
import com.pharmaplus.article.exception.NotFoundException;
import com.pharmaplus.article.utility.ApiResponse;

@RestController
@RequestMapping(value = "/article")
@CrossOrigin
public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	CategorieRepository categorieRepository;
	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	// Get all Article
		@GetMapping("/all")
		public ApiResponse<List<Article>> getArticles() {
			List<Article> articles = articleRepository.findAll();
			return new ApiResponse<>(true, "Articles found successfully.", articles);
		}
		
		/*// Add Article
		@PostMapping("/add")
		public ApiResponse<Article> addArticle(@RequestBody Article article) {
			Article savedArticle = articleRepository.save(article);
	        return new ApiResponse<>(true, "Article save Successfully.", savedArticle);
		}*/
		
		// Add Article
		@PostMapping("/add")
		public ApiResponse<Article> addArticle(@RequestBody ArticleRequest articleRequest) {
			Article article = new Article(articleRequest.getName(), articleRequest.getDescription(), articleRequest.getPrice(), articleRequest.getQuantity());
			String fournisseurId = articleRequest.getFournisseur();
			String categorieId = articleRequest.getCategorie();
			if (fournisseurRepository.existsById(fournisseurId) && categorieRepository.existsById(categorieId)) {
				fournisseurRepository.findById(fournisseurId).map(f -> {article.setFournisseur(f);
					return articleRepository.save(article);
				});
				categorieRepository.findById(categorieId).map(c -> {article.setCategorie(c);
					return articleRepository.save(article);
				});
				Article savedArticle = articleRepository.save(article);
		        return new ApiResponse<>(true, "Article save successfully", savedArticle);
			} else {
				logger.error("Fournisseur and/or Categorie not found");
				return new ApiResponse<>(false, "Fournisseur and/or Categorie not found", null);
			}
		}
		
		// Get Article By Id
		@GetMapping("/id/{id}")
		public ApiResponse<Article> getArticleById(@PathVariable String id) throws NotFoundException{
			Article article = articleRepository.findById(id).orElseThrow(() -> new NotFoundException("Article not found for this id :: " + id));
			return new ApiResponse<>(true, "Article found successfully.", article);
		}
		
		// Get Article By Name
		@GetMapping("/name/{name}")
		public ApiResponse<Article> getArticleByName(@PathVariable String name) throws NotFoundException{
			Article article = articleRepository.findByName(name).orElseThrow(() -> new NotFoundException("Article not found for this name :: " + name));
			return new ApiResponse<>(true, "Article found successfully.", article);
		}
		
		// Search Article Name Start by 
		@GetMapping("/search/start/name/{name}")
		public ApiResponse<List<Article>> getArticleByStartingName(@PathVariable String name) throws NotFoundException{
			List<Article> articles = articleRepository.findByNameStartingWith(name);
			ApiResponse<List<Article>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("article with name starting with " + name);
	        response.setData(articles);
	        logger.info("article ==> " + response.getData()); 
	        return response;
		}
		
		// Search Article Name Contains
		@GetMapping("/search/contain/name/{name}")
		public ApiResponse<List<Article>> getArticleByContainingFirstName(@PathVariable String name) throws NotFoundException{
			List<Article> articles = articleRepository.findByNameContaining(name);
			ApiResponse<List<Article>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("article with name starting with " + name);
	        response.setData(articles);
	        logger.info("article ==> " + response.getData());
	        return response;
		}
		
		// Search Articles With Price 
		@GetMapping("/search/price/{price}")
		public ApiResponse<List<Article>> getArticleByPrice(@PathVariable Double price) throws NotFoundException{
			List<Article> articles = articleRepository.findByPrice(price);
			ApiResponse<List<Article>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("article with price " + price);
	        response.setData(articles);
	        logger.info("article ==> " + response.getData()); 
	        return response;
		}
		
		// Search Article With Price is Greater 
		@GetMapping("/search/price/greater/{price}")
		public ApiResponse<List<Article>> getArticleByPriceGreaterThan(@PathVariable Double price) throws NotFoundException{
			List<Article> articles = articleRepository.findByPriceGreaterThan(price);
			ApiResponse<List<Article>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("article with price is greater " + price);
	        response.setData(articles);
	        logger.info("article ==> " + response.getData()); 
	        return response;
		}
		
		// Search Article With Price is Less
		@GetMapping("/search/price/less/{price}")
		public ApiResponse<List<Article>> getArticleByPriceLessThan(@PathVariable Double price) throws NotFoundException{
			List<Article> articles = articleRepository.findByPriceLessThan(price);
			ApiResponse<List<Article>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("article with price is less " + price);
	        response.setData(articles);
	        logger.info("article ==> " + response.getData());
	        return response;
		}
		
		// Search Article With Quantity is Greater 
		@GetMapping("/search/quantity/{quantity}")
		public ApiResponse<List<Article>> getArticleByQuantity(@PathVariable Integer quantity) throws NotFoundException{
			List<Article> articles = articleRepository.findByQuantity(quantity);
			ApiResponse<List<Article>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("article with quantity " + quantity);
	        response.setData(articles);
	        logger.info("article ==> " + response.getData()); 
	        return response;
		}
		
		// Search Article With Quantity is Greater 
		@GetMapping("/search/quantity/greater/{quantity}")
		public ApiResponse<List<Article>> getArticleByQuantityGreaterThan(@PathVariable Integer quantity) throws NotFoundException{
			List<Article> articles = articleRepository.findByQuantityGreaterThan(quantity);
			ApiResponse<List<Article>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("article with quantity is greater " + quantity);
	        response.setData(articles);
	        logger.info("article ==> " + response.getData()); 
	        return response;
		}
		
		// Search Article With Quantity is Less
		@GetMapping("/search/quantity/less/{quantity}")
		public ApiResponse<List<Article>> getArticleByQuantityLessThan(@PathVariable Integer quantity) throws NotFoundException{
			List<Article> articles = articleRepository.findByQuantityLessThan(quantity);
			ApiResponse<List<Article>> response = new ApiResponse<>();
	        response.setSuccess(true);
	        response.setMessage("article with quantity is less " + quantity);
	        response.setData(articles);
	        logger.info("article ==> " + response.getData());
	        return response;
		}
		
		// Update Article By Id
		@PutMapping("/{id}")
		public ApiResponse<Article> updateArticle(@PathVariable("id") String id, @RequestBody Article article) throws NotFoundException{
		    Article updatedArticle = articleRepository.findById(id).orElseThrow(() -> new NotFoundException("Article not found for this id :: " + id));
		    updatedArticle.setDescription(article.getDescription());
		    updatedArticle.setName(article.getName());
		    updatedArticle.setPrice(article.getPrice());
		    updatedArticle.setQuantity(article.getQuantity());
		    return new ApiResponse<>(true, "Article updated successfully.", updatedArticle);
		}
		
		// Delete Article By Id
		@DeleteMapping("/{id}")
		public ApiResponse<Void> deleteArticle(@PathVariable("id") String id) {
		    articleRepository.deleteById(id);
		    return new ApiResponse<>(true, "Article deleted successfully.", null);
		}


}
