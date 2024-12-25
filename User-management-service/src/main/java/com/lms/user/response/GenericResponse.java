package com.lms.user.response;

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
public class GenericResponse<T> {
	
	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";
	private String message;
	private String status;
	private int statusCode;
	private T content;
	
}
