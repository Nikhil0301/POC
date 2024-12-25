package com.example.lms.bookservice.service;

import java.util.List;
import java.util.Optional;

import com.example.lms.bookservice.model.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(int id);
    Category saveCategory(Category category);
    void deleteCategory(int id);
    Category updateCategory(int id, Category categoryDetails);
}