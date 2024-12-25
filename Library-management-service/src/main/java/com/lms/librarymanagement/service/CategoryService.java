package com.lms.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.librarymanagement.dto.CategoryDto;
import com.lms.librarymanagement.entities.Category;
import com.lms.librarymanagement.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    
    public Category saveCategory(CategoryDto categoryDto) {
    	Category category = new Category();
    	category.setCategoryName(categoryDto.getCategoryName());
    	category.setDesc(categoryDto.getDesc());
        return categoryRepository.save(category);
    }

    
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    
    public Category updateCategory(Long id, CategoryDto categoryDetails) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setCategoryName(categoryDetails.getCategoryName());
            category.setDesc(categoryDetails.getDesc());
            return categoryRepository.save(category);
        } else {
            throw new RuntimeException();
        }
    }
}