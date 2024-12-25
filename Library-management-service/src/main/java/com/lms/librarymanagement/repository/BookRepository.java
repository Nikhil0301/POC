package com.lms.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<com.lms.librarymanagement.entities.Book, Long> {
    // Additional query methods can be defined here if needed
}