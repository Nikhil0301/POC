package com.lms.user.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookTransactionUserDetails {
	
	public BookTransactionUserDetails() {
		// TODO Auto-generated constructor stub
	}

	private List<BookTransactionDto> bto;
	
	private UserTO userTo;
}
