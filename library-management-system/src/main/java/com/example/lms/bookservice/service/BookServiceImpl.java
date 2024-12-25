package com.example.lms.bookservice.service;

import com.example.lms.bookservice.model.Book;
import com.example.lms.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        try {
            return bookRepository.save(book);
        } catch (ObjectOptimisticLockingFailureException e) {
            // Handle the exception, e.g., by retrying or returning an error response
            throw new RuntimeException("Failed to save book due to concurrent update", e);
        }
    }

    @Override
    public Book updateBook(int id, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            book.setPublishYear(bookDetails.getPublishYear());
            book.setAvailableStatus(bookDetails.getAvailableStatus());
            book.setCategory(bookDetails.getCategory());
            try {
                return bookRepository.save(book);
            } catch (ObjectOptimisticLockingFailureException e) {
                // Handle the exception, e.g., by retrying or returning an error response
                throw new RuntimeException("Failed to update book due to concurrent update", e);
            }
        } else {
            return null;
        }
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}