package com.lms.user.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.lms.user.dtos.BookTransactionDto;

@FeignClient(name = "Book-management-service", fallback = BookTransactionFallback.class)
public interface BookTransactionClient {
	
	@GetMapping(value = "/api/bookTransaction/{userId}", consumes = "application/json")
	public ResponseEntity<List<BookTransactionDto>> fetchBookTransactionByUserId(@RequestHeader("lms-correlation-id")
    String correlationId, @PathVariable Long userId);
}
