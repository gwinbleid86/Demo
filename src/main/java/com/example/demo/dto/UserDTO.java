package com.example.demo.dto;

import com.example.demo.entities.Article;
import com.example.demo.entities.User;
import lombok.*;
import org.springframework.data.domain.Page;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private Page<Article> articles;

    public static UserDTO from(User user) {
        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
