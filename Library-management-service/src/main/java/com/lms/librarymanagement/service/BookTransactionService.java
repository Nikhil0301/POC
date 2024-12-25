package com.lms.librarymanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.librarymanagement.dto.BookTransactionDto;
import com.lms.librarymanagement.entities.Book;
import com.lms.librarymanagement.entities.Booktransaction;
import com.lms.librarymanagement.repository.BookRepository;
import com.lms.librarymanagement.repository.BookTransactionRepository;

@Service
public class BookTransactionService {

    @Autowired
    private BookTransactionRepository bookTransactionRepository;
    
    @Autowired
    private BookRepository bookRepository;
    

    
    public List<Booktransaction> getAllBookTransactions() {
        return bookTransactionRepository.findAll();
    }

    
    public Optional<Booktransaction> getBookTransactionById(int id) {
        return bookTransactionRepository.findById(id);
    }

    
    public Booktransaction saveBookTransaction(BookTransactionDto bookTransactionDto) {
    	Booktransaction bookTransaction = new Booktransaction();
    	Book book = bookRepository.findById(bookTransactionDto.getBookId()).get();
    	book.setAvailableStatus(false);
    	Date issueDate = new Date();  // Current date

        // Set the return date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(issueDate);
        calendar.add(Calendar.DATE, 7);  // Add 7 days for the return date
        Date returnDate = calendar.getTime();
    	
    	bookTransaction.setIssueDate(issueDate);
    	bookTransaction.setReturnDate(returnDate);
    	bookTransaction.setUserId(bookTransactionDto.getUserId());
    	bookTransaction.setBook(book);
        return bookTransactionRepository.save(bookTransaction);
    }

    
    public void deleteBookTransaction(int id) {
    	Book book = bookRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Book not found"));
    	book.setAvailableStatus(true);
        bookTransactionRepository.deleteById(id);
    }

    
    public Booktransaction updateBookTransaction(int id, Booktransaction bookTransactionDetails) {
        Optional<Booktransaction> optionalBookTransaction = bookTransactionRepository.findById(id);
        if (optionalBookTransaction.isPresent()) {
            Booktransaction bookTransaction = optionalBookTransaction.get();
            bookTransaction.setIssueDate(bookTransactionDetails.getIssueDate());
            bookTransaction.setDueDate(bookTransactionDetails.getDueDate());
            bookTransaction.setReturnDate(bookTransactionDetails.getReturnDate());
            bookTransaction.setFine(bookTransactionDetails.getFine());
            bookTransaction.setBook(bookTransactionDetails.getBook());
            return bookTransactionRepository.save(bookTransaction);
        } else {
            return null;
        }
    }
    
    public List<BookTransactionDto> getBookTransactionDetailsByUserId(Long userId) {
    	List<Booktransaction> booktransactionList = bookTransactionRepository.findByUserId(userId);
    	List<BookTransactionDto> list = new ArrayList<>();
    	for(Booktransaction bookTransaction : booktransactionList) {
    		list.add(new BookTransactionDto(bookTransaction.getId()
    				,bookTransaction.getBook().getBookId()
    				,bookTransaction.getUserId()
    				,bookTransaction.getIssueDate()
    				,bookTransaction.getDueDate() 
    				,bookTransaction.getReturnDate()));
    	}
    	return list;
    }
}