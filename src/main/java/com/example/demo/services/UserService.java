package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.util.UserAlreadyRegisteredException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {
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

    public Page<UserDTO> getAllUsers(Pageable pageable) {
        var usersDTO = repository.findAll(pageable);
        return usersDTO.map(UserDTO::from);
    }

    public Optional<UserDTO> getUserById(int id) {
        return Optional.of(UserDTO.from(repository.findById(id).get()));
    }

}
