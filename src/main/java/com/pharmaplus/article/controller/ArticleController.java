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
import com.pharmaplus.article.repository.FamilleRepository;
import com.pharmaplus.article.repository.FournisseurRepository;
import com.pharmaplus.article.service.ArticleService;
import com.pharmaplus.article.dto.ArticleDTO;
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
	FamilleRepository familleRepository;
	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Autowired
	ArticleService articleService;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	// Get all Article
		@GetMapping("/all")
		public ApiResponse<List<Article>> getArticles() {
			List<Article> articles = articleRepository.findAll();
			//articles.stream().filter(a -> a.getDelete().equals(false)).collect(Collectors.toList()).sorted(Comparator.comparing(Article::getName);
			return new ApiResponse<>(true, "Articles found successfully.", articles);
		}
		
		@GetMapping("/undelete/all")
		public ApiResponse<List<Article>> getArticleNotDeleted() {
			List<Article> articles = articleRepository.findByEnable(false);
			//articles.stream().filter(a -> a.getDelete().equals(false)).collect(Collectors.toList()).sorted(Comparator.comparing(Article::getName);
			return new ApiResponse<>(true, "Articles found successfully.", articles);
		}
		
		// Add Article
		@PostMapping("/add")
		public ApiResponse<ArticleDTO> addArticle(@RequestBody ArticleDTO articleDTO) {
			if(articleRepository.existsByDesignation(articleDTO.getDesignation())) {
				throw new IllegalArgumentException("Article exist !!!");
			}
			return new ApiResponse<>(true, "Article added successfully. ", articleService.savArticle(articleDTO));
		}
		
		// Get Article By Id
		@GetMapping("/id/{id}")
		public ApiResponse<Article> getArticleById(@PathVariable String id) throws NotFoundException{
			Article article = articleRepository.findById(id).orElseThrow(() -> new NotFoundException("Article not found for this id :: " + id));
			return new ApiResponse<>(true, "Article found successfully.", article);
		}
		
		// Get Article By Designation
		@GetMapping("/designation/{designation}")
		public ApiResponse<Article> getArticleByDesignation(@PathVariable String name) throws NotFoundException{
			Article article = articleRepository.findByDesignation(name).orElseThrow(() -> new NotFoundException("Article not found for this name :: " + name));
			return new ApiResponse<>(true, "Article found successfully.", article);
		}
		
		// Search Article Designation Contains
		@GetMapping("/search/contain/designation/{designation}")
		public ApiResponse<List<ArticleDTO>> getArticleByContainingDesignation(@PathVariable String designation) throws NotFoundException{
			List<ArticleDTO> articleDTO = articleService.getArticleContainingDesignation(designation);
	        return new ApiResponse<>(true, "Articles found successfully", articleDTO);
		}
		
		// Search Articles With Price 
		/*@GetMapping("/search/price/{price}")
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
		}*/
		
		// Update Article By Id
		@PutMapping("/{id}")
		public ApiResponse<ArticleDTO> updateArticle(@PathVariable String id, @RequestBody ArticleDTO articleDTO) throws NotFoundException{
			articleRepository.findById(id);
			articleService.updArticle(articleDTO);
		    return new ApiResponse<>(true, "Article updated successfully.", articleDTO);
		}
		
		// Delete Article By Id
		@DeleteMapping("/{id}")
		public ApiResponse<Void> deleteArticle(@PathVariable("id") String id) {
		    articleRepository.deleteById(id);
		    return new ApiResponse<>(true, "Article deleted successfully.", null);
		}
		
		// Soft Delete Article By Id
		@PutMapping("/soft-delete/{id}")
		public ApiResponse<ArticleDTO> softDeleteArticle(@PathVariable String id) throws NotFoundException{
			Article article = articleRepository.findById(id).get();
			ArticleDTO articleDTO = articleService.convertEntityToDto(article);
			articleDTO.setEnable(true);
		    return new ApiResponse<>(true, "Article deleted successfully.", articleService.softDeleteArticle(articleDTO));
		}


}
