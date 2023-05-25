package com.pharmaplus.article.service;

import java.util.List;
import java.util.Optional;

import com.pharmaplus.article.dto.ArticleDTO;
import com.pharmaplus.article.entity.Article;

public interface ArticleService {
	
	ArticleDTO savArticle(ArticleDTO articleDTO);
	ArticleDTO updArticle(ArticleDTO articleDTO);
	ArticleDTO softDeleteArticle(ArticleDTO articleDTO);
	ArticleDTO getArticleDTO(String id);
	Optional<ArticleDTO> getArticleByDesignation(String designation);
	List<ArticleDTO> getAllArticles();
	List<ArticleDTO> getArticleContainingDesignation(String charactere);
	List<ArticleDTO> getArticleContainingCode1(String charactere);
	List<ArticleDTO> getArticleContainingCode2(String charactere);
	List<ArticleDTO> getArticleContainingCode3(String charactere);
	ArticleDTO convertEntityToDto(Article article);
	Article convertDtoToEntity(ArticleDTO articleDAO);

}
