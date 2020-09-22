package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.repositories.UserRepository;
import com.example.demo.util.UserAlreadyRegisteredException;
import com.example.demo.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService{
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public boolean checkUser(UserDTO form) {
        return repository.existsByUsername(form.getUsername());
    }


    public void saveUser(UserDTO form) throws UserAlreadyRegisteredException {
        if (checkUser(form)) {
            throw new UserAlreadyRegisteredException();
        }
        var user = User.builder()
                .username(form.getUsername())
                .password(encoder.encode(form.getPassword()))
                .enabled(true)
                .build();
        repository.save(user);
    }


}
