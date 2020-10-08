package com.example.demo.dto;

import com.example.demo.entities.Article;
import com.example.demo.entities.Category;
import com.example.demo.entities.User;
import lombok.*;

import java.util.Date;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class ArticleDTO {
    private Integer id;
    private String title;
    private String description;
    private String image;
    private Date date;
    private User user;
    private Category category;

    public static ArticleDTO from(Article article) {
        return builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .image(article.getImage())
                .date(article.getDate())
                .user(article.getUser())
                .category(article.getCategory())
                .build();
    }
}
