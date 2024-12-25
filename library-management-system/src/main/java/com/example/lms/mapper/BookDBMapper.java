package com.example.lms.mapper;

import com.example.lms.bookservice.dto.BookDto;
import com.example.lms.bookservice.model.Book;

public class BookDBMapper {
	
public Book getMappedObject(BookDto userTo) {
		
	    Book book = new Book();
	    
		return book;
	}
	
    public BookDto getReverseMappedObject(Book book) {
    	
    	BookDto bookto = new BookDto();
    	
		return bookto;
		
	}
}
