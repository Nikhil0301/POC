package com.example.lms.bookservice.controller;

import java.util.List;
import java.util.Optional;

import com.example.lms.bookservice.dto.BookDto;
import com.example.lms.bookservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.lms.bookservice.model.Book;
import com.example.lms.bookservice.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
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
    public Book createBook(@RequestBody BookDto book) {
        if(categoryService.getCategoryById(book.getCategoryId()).isPresent()){
            Book bk = new Book();
            bk.setTitle(book.getBname());
            bk.setAuthor(book.getAuthor());
            bk.setPublishYear(book.getPublishYear());
            bk.setIsbn(book.getIsbn());
            bk.setAvailableStatus(book.getAvailableStatus());
            bk.setCategory(categoryService.getCategoryById(book.getCategoryId()).get());
            return bookService.saveBook(book);
        }
        throw Exception();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(id, bookDetails);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}