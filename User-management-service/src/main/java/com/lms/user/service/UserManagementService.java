package com.lms.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.user.dtos.BookTransactionDto;
import com.lms.user.dtos.BookTransactionUserDetails;
import com.lms.user.dtos.UserTO;
import com.lms.user.entities.User;
import com.lms.user.exception.ResourceNotFoundException;
import com.lms.user.mapper.UserDBMapper;
import com.lms.user.repository.UserRepository;
import com.lms.user.service.client.BookTransactionClient;

@Service
public class UserManagementService {
	
	@Autowired
	private UserDBMapper userDbMapper;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookTransactionClient bookTransactionClient;
	
	public UserTO createUser(UserTO userTo) {
		//check if the user already exist
		//if already exist throws exception, otherwise map the userto to user entity
	    Optional<User> user = userRepo.findByEmail(userTo.getEmail());
		
	    User newUser = userDbMapper.getMappedObject(userTo);
		
	    userRepo.save(newUser);
	    
		return userDbMapper.getReverseMappedObject(newUser);
		
	}
	
	public PageImpl<UserTO> getUsers() {
	
	    List<User> users = userRepo.findAll();
	    long totalCount = userRepo.count();
		List<UserTO> userslist =  new ArrayList();
		for(User user:users) {
			userslist.add(userDbMapper.getReverseMappedObject(user));
		}
		
		PageRequest pageable = PageRequest.of(0,5);
		return new PageImpl<>(userslist, pageable, totalCount);
	}
	
	public UserTO getUserById(int id) {
	    User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",String.valueOf(id)));
	    return userDbMapper.getReverseMappedObject(user);
	}
	
	public void deleteUserById(int id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",String.valueOf(id)));
	    userRepo.delete(user);
	}
	
	public BookTransactionUserDetails  getBookTransactionDetailsByUserId(String correlationId, Long userId) {
		
		User user = userRepo.findById(Integer.valueOf(userId.intValue())).orElseThrow(() -> new RuntimeException("User with user userId "+userId+"not found"));
		UserTO userTo = userDbMapper.getReverseMappedObject(user);
		ResponseEntity<List<BookTransactionDto>> responeList = bookTransactionClient.fetchBookTransactionByUserId(correlationId, userId); 
		BookTransactionUserDetails details = new BookTransactionUserDetails();
		details.setUserTo(userTo);
		if(responeList != null)
			details.setBto(responeList.getBody());
		return details;
		
	}
}
