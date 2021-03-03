package com.example.demo.dto;

import com.example.demo.entities.Article;
import com.example.demo.entities.User;
import com.example.demo.services.CategoryService;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class ArticleDTO {
    private static CategoryService service;
    private Integer id;
    private String title;
    private String description;
    private String imageName;
    private String imageOriginalName;
    private LocalDateTime date;
    private User user;
    private Integer categoryId;

    public static ArticleDTO from(Article article) {
        return builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .imageName(article.getImageName())
                .imageOriginalName(article.getImageOriginalName())
                .date(article.getDate())
                .user(article.getUser())
                .categoryId(article.getCategory().getId())
                .build();
    }

}
