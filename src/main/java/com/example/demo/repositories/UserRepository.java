package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    Optional<User> getByUsername(String username);

    boolean existsByUsername(String login);

    Page<User> findAll(Pageable pageable);

}
