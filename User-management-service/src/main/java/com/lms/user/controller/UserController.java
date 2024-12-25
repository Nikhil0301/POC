package com.lms.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.user.dtos.BookTransactionDto;
import com.lms.user.dtos.BookTransactionUserDetails;
import com.lms.user.dtos.UserSupportInfo;
import com.lms.user.dtos.UserTO;
import com.lms.user.response.GenericResponse;
import com.lms.user.service.UserManagementService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {
	
	@Autowired
	private UserManagementService userService;
	
	@Autowired
    private UserSupportInfo userSupportInfo;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//create user
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST , path = "/create-user")
	public GenericResponse<UserTO> createUser(@RequestBody UserTO userTo) {
		UserTO user = userService.createUser(userTo);
		return new GenericResponse<UserTO>("User successfully created",GenericResponse.SUCCESS,HttpStatus.OK.value(),userTo);
	}
	
	//get all users
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<UserTO>> getUsers() {
		Page<UserTO> pageData = userService.getUsers();
		
		return ResponseEntity.status(HttpStatus.OK).body(pageData);
	}
	
	//get user by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserTO> getUser(@PathVariable(required = true) int id) {
	    UserTO userto= userService.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(userto);
	}
	
	//delete user by id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(required = true) int id) {
		userService.deleteUserById(id);
	}
	
	@GetMapping("/user-support-info")
    public ResponseEntity<UserSupportInfo> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userSupportInfo);
    }
	
	@RequestMapping(value = "/fetchBookTransactionDetails/{userId}", method = RequestMethod.GET)
	public ResponseEntity<BookTransactionUserDetails> fetchUserTransactionDetails(
			@RequestHeader("lms-correlation-id") String correlationId, @PathVariable(required = true) Long userId) {
		logger.debug("lms-correlation-id found: {} ", correlationId);
		BookTransactionUserDetails details = userService.getBookTransactionDetailsByUserId(correlationId, userId);
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}
	
}
