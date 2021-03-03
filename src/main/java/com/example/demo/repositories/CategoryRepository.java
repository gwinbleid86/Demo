package com.example.demo.repositories;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entities.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    Optional<Category> findByTitle(String title);
}
