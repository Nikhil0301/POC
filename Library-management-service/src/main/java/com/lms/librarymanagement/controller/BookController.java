package com.lms.librarymanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagement.dto.BookDto;
import com.lms.librarymanagement.entities.Book;
import com.lms.librarymanagement.entities.Category;
import com.lms.librarymanagement.service.BookService;
import com.lms.librarymanagement.service.CategoryService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService  categoryService;
    
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    
    @Retry(name = "getAllBooks", fallbackMethod = "getAllBooksFallback")
    @GetMapping
    public List<Book> getAllBooks() {
    	logger.debug("getAllBooks() method invoked ");
        return bookService.getAllBooks();
    }
    
    public List<Book> getAllBooksFallback(Throwable th){
    	logger.debug("getBuildInfoFallback() method Invoked");
        return List.of(new Book());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Book createBook(@RequestBody BookDto book) throws Exception {
    	Optional<Category> category = categoryService.getCategoryById(book.getCategoryId());
        if(category != null ){
            Book bk = new Book();
            bk.setTitle(book.getBname());
            bk.setAuthor(book.getAuthor());
            bk.setPublishYear(book.getPublishYear());
            bk.setIsbn(book.getIsbn());
            bk.setAvailableStatus(book.getAvailableStatus());
            bk.setCategory(category.get());
            return bookService.saveBook(bk);
        }
        throw new Exception();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
//        Book updatedBook = bookService.updateBook(id, bookDetails);
//        if (updatedBook != null) {
//            return ResponseEntity.ok(updatedBook);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}