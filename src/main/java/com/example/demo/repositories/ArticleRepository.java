package com.example.demo.repositories;

import com.example.demo.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {
    Page<Article> findAllByUser_id(int id, Pageable pageable);
}
