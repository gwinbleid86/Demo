package com.example.demo.services;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryService {
    private final CategoryRepository repository;

    public Optional<CategoryDTO> findById(int id) {
        return repository.findById(id).map(CategoryDTO::from);
    }

    public Optional<CategoryDTO> findByTitle(String title) {
        return repository.findByTitle(title).map(CategoryDTO::from);
    }

    public List<CategoryDTO> getAll(){
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(CategoryDTO::from)
                .collect(Collectors.toList());
    }
}
