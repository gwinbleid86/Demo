package com.example.demo.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CreateArticleDTO {
    private String title;
    private String description;
    private Integer categoryId;
    private MultipartFile image;
}
