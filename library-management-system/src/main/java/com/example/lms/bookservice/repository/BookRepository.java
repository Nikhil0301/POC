package com.example.lms.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lms.bookservice.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // Additional query methods can be defined here if needed
}