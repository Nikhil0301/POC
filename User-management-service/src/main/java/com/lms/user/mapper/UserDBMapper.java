package com.lms.user.mapper;

import org.springframework.stereotype.Component;

import com.lms.user.dtos.UserTO;
import com.lms.user.entities.User;

@Component
public class UserDBMapper {
	public User getMappedObject(UserTO userTo) {
		
		User user = new User();
		user.setName(userTo.getName());
		user.setEmail(userTo.getEmail());
		user.setPwd(user.getPwd());
		user.setRole(userTo.getRole());
		return user;
	}
	
    public UserTO getReverseMappedObject(User user) {
    	
    	UserTO userTo = new UserTO();
    	userTo.setName(user.getName());
    	userTo.setEmail(user.getEmail());
    	userTo.setPassword(user.getPwd());
    	userTo.setRole(user.getRole());
		return userTo;
		
	}
}
