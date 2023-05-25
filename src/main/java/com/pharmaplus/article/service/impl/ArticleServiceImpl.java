package com.pharmaplus.article.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmaplus.article.dto.ArticleDTO;
import com.pharmaplus.article.entity.Article;
import com.pharmaplus.article.repository.ArticleRepository;
import com.pharmaplus.article.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	ArticleRepository articleRepository;

	@Override
	public ArticleDTO convertEntityToDto(Article article) {
		return modelMapper.map(article, ArticleDTO.class);
	}

	@Override
	public Article convertDtoToEntity(ArticleDTO articleDAO) {
		return modelMapper.map(articleDAO, Article.class);
	}

	@Override
	public ArticleDTO savArticle(ArticleDTO articleDTO) {
		return convertEntityToDto(articleRepository.save(convertDtoToEntity(articleDTO)));
	}

	@Override
	public ArticleDTO updArticle(ArticleDTO articleDTO) {
		return convertEntityToDto(articleRepository.save(convertDtoToEntity(articleDTO)));
	}

	@Override
	public ArticleDTO softDeleteArticle(ArticleDTO articleDTO) {
		return convertEntityToDto(articleRepository.save(convertDtoToEntity(articleDTO)));
	}

	@Override
	public ArticleDTO getArticleDTO(String id) {
		return convertEntityToDto(articleRepository.findById(id).get());
	}

	@Override
	public Optional<ArticleDTO> getArticleByDesignation(String designation) {
		return articleRepository.findByDesignation(designation)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public List<ArticleDTO> getAllArticles() {
		return articleRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ArticleDTO> getArticleContainingDesignation(String charactere) {
		return articleRepository.findByDesignationContaining(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ArticleDTO> getArticleContainingCode1(String charactere) {
		return articleRepository.findByCode1(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ArticleDTO> getArticleContainingCode2(String charactere) {
		return articleRepository.findByCode2(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ArticleDTO> getArticleContainingCode3(String charactere) {
		return articleRepository.findByCode3(charactere)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
}
