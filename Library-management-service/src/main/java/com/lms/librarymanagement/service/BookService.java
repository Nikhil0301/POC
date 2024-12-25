package com.lms.librarymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.lms.librarymanagement.entities.Book;
import com.lms.librarymanagement.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService{

    @Autowired
    private BookRepository bookRepository;

    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        try {
            return bookRepository.save(book);
        } catch (ObjectOptimisticLockingFailureException e) {
            // Handle the exception, e.g., by retrying or returning an error response
            throw new RuntimeException("Failed to save book due to concurrent update", e);
        }
    }

//    public Book updateBook(int id, Book bookDetails) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if (optionalBook.isPresent()) {
//            Book book = optionalBook.get();
//            book.setTitle(bookDetails.getTitle());
//            book.setAuthor(bookDetails.getAuthor());
//            book.setIsbn(bookDetails.getIsbn());
//            book.setPublishYear(bookDetails.getPublishYear());
//            book.setAvailableStatus(bookDetails.isAvailableStatus());
//            book.setCategory(bookDetails.getCategory());
//            try {
//                return bookRepository.save(book);
//            } catch (ObjectOptimisticLockingFailureException e) {
//                // Handle the exception, e.g., by retrying or returning an error response
//                throw new RuntimeException("Failed to update book due to concurrent update", e);
//            }
//        } else {
//            return null;
//        }
//    }
    
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}