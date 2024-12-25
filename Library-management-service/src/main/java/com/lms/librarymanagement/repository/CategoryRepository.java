package com.lms.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.librarymanagement.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Additional query methods can be defined here if needed
}