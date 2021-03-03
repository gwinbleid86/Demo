package com.example.demo.dto;

import com.example.demo.entities.Category;
import lombok.*;

import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class CategoryDTO {
    private Integer id;
    private String title;
    private List<Category> parent_id;

    public static CategoryDTO from(Category category) {
        return builder()
                .id(category.getId())
                .title(category.getTitle())
                .parent_id(category.getParent())
                .build();
    }
}
