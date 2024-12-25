package com.lms.librarymanagement.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagement.dto.BookDto;
import com.lms.librarymanagement.dto.BookTransactionDto;
import com.lms.librarymanagement.entities.Book;
import com.lms.librarymanagement.entities.Booktransaction;
import com.lms.librarymanagement.service.ApiService;
import com.lms.librarymanagement.service.BookService;
import com.lms.librarymanagement.service.BookTransactionService;
import com.lms.librarymanagement.service.CategoryService;


@RestController
@RequestMapping("/api/bookTransaction")
public class BookTransactionController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookTransactionController.class);
	
	@Autowired
    private BookService bookService;

    @Autowired
    private CategoryService  categoryService;
    
    @Autowired
    private BookTransactionService bookTransactionService;

    
    @Autowired
    private ApiService apiService;
	
	@PostMapping
    public ResponseEntity<Booktransaction> createBookTransaction(@RequestBody BookTransactionDto bookTransactionDto) throws Exception {
        //check if user is present in the db or not
		if(apiService.getUserById(bookTransactionDto.getUserId()) != null) {
			Optional<Book> book = bookService.getBookById(bookTransactionDto.getBookId());
			if(book.isPresent() && book.get().isAvailableStatus() == true) {
				Booktransaction savedTransaction = bookTransactionService.saveBookTransaction(bookTransactionDto);
				return ResponseEntity.ok(savedTransaction);
			}
			else
				throw new RuntimeException("Book is not available");
		}else
			throw new RuntimeException("user not able to issue book as user not present");
    }
	
	@DeleteMapping("/{id}")
    public String deleteBookTransaction(@PathVariable int id) throws Exception {
        //check if user is present in the db or not
		bookTransactionService.deleteBookTransaction(id);
		return "Book deleted successfully";
    }
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<BookTransactionDto>> fetchBookTransactionByUserId(@RequestHeader("lms-correlation-id") String correlationId, @PathVariable Long userId){
		logger.debug("lms-correlation-id found: {} ", correlationId);
		List<BookTransactionDto> bookTransactionList = bookTransactionService.getBookTransactionDetailsByUserId(userId);
		return ResponseEntity.ok(bookTransactionList);
	}
	
}
