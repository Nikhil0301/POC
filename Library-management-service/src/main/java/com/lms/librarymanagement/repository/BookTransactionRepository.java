package com.lms.librarymanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.librarymanagement.entities.Booktransaction;

@Repository
public interface BookTransactionRepository extends JpaRepository<Booktransaction, Integer> {
    // Additional query methods can be defined here if needed
	List<Booktransaction> findByUserId(Long id);
}