package com.lms.user.dtos;

import java.util.Date;
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
public class BorrowingDetails {
	
	private Date issueDate;
	
	private Date submitDate;
	
	private String bookName;
	
	private int noOfTimesBookIssued;
}
