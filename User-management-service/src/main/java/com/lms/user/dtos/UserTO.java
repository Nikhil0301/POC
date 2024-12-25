package com.lms.user.dtos;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserTO {
	
	private String name;
	
	@NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
	private String email;
	
	private String password;
	
	private String role;
	
	private List<BorrowingDetails> borrowingHistory;
	
	private List<PersonalPreference> personalPreferences;
	
}
