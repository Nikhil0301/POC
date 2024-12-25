package com.lms.user.dtos;

import java.util.Date;

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
public class PersonalPreference {
	
	private String bookName;
	
	private String author;
	
	private String category;
	
	private String language;
	
}
