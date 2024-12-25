package com.lms.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	public Optional<User> findByEmail(String email);
	
	
}
