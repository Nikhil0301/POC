package com.lms.librarymanagement.dto;

import java.util.List;

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
public class UserProxy {
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String role;
	
	//private List<BorrowingDetails> borrowingHistory;
	
	//private List<PersonalPreference> personalPreferences;
	
}
