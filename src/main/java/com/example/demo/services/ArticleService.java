package com.example.demo.services;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.entities.Article;
import com.example.demo.repositories.ArticleRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public Page<ArticleDTO> getArticlesFromUser(int id, Pageable pageable){
        return repository.findAllByUser_id(id, pageable).map(ArticleDTO::from);
    }

    public Page<ArticleDTO> getAllArticles(Pageable pageable) {
        return repository.findAll(pageable).map(ArticleDTO::from);
    }


    public Optional<ArticleDTO> getArticleById(int id) {
        return Optional.of(ArticleDTO.from(repository.findById(id).get()));
    }
}
