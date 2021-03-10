package com.example.demo.services;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.dto.CreateArticleDTO;
import com.example.demo.entities.Article;
import com.example.demo.entities.Category;
import com.example.demo.entities.User;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.util.FileAction;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public Page<ArticleDTO> getArticlesFromUser(int id, Pageable pageable) {
        return articleRepository.findAllByUser_id(id, pageable).map(ArticleDTO::from);
    }

    public Page<ArticleDTO> getAllArticles(Pageable pageable) {
        return articleRepository.findAll(pageable).map(ArticleDTO::from);
    }


    public Optional<ArticleDTO> getArticleById(int id) {
        return Optional.of(ArticleDTO.from(articleRepository.findById(id).get()));
    }

    public void saveArticle(CreateArticleDTO dto) {
        var article = Article.builder()
                .imageOriginalName(dto.getImage().getOriginalFilename())
                .imageName(FileAction.uploadFile(dto.getImage()))
                .title(dto.getTitle())
                .description(dto.getDescription())
                .date(LocalDateTime.now())
                .user(userRepository.findByUsername(getUserName()))
                .category(getCategory(dto.getCategoryId()))
                .build();
        articleRepository.save(article);
    }

    public void updateArticle(CreateArticleDTO dto, Integer id) {
        var article = articleRepository.findById(id).get();
        if (!dto.getImage().getOriginalFilename().equals("")) {
            article.setImageOriginalName(dto.getImage().getOriginalFilename());
            article.setImageName(FileAction.uploadFile(dto.getImage()));
        }
        article.setTitle(dto.getTitle());
        article.setDescription(dto.getDescription());
        article.setDate(LocalDateTime.now());
        article.setUser(userRepository.findByUsername(getUserName()));
        article.setCategory(getCategory(dto.getCategoryId()));
        articleRepository.save(article);

    }

    private Category getCategory(Integer id) {
        return id != 0 ? categoryRepository.findById(id).get() : categoryRepository.findByTitle("common_topic").get();
    }

    private String getUserName() {
        var user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((User) user).getUsername();
    }

    public void deleteArticle(int id) {
        var article = articleRepository.findById(id).get();
        articleRepository.delete(article);
        if (article.getImageName() != null) FileAction.deleteFile(article.getImageName());
    }
}
