package com.lms.user.service.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.lms.user.dtos.BookTransactionDto;

@Component
public class BookTransactionFallback  implements BookTransactionClient{

	@Override
	public ResponseEntity<List<BookTransactionDto>> fetchBookTransactionByUserId(String correlationId, Long userId) {
		System.out.println("Inside BookTransactionFallback.fetchBookTransactionByUserId:- "+userId);
		return null;
	}

}
