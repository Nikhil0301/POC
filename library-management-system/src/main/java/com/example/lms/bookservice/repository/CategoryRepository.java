package com.example.lms.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lms.bookservice.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Additional query methods can be defined here if needed
}