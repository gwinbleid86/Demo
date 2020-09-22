package com.example.demo.dto;

import com.example.demo.entities.User;
import lombok.*;

@Data
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;
}
