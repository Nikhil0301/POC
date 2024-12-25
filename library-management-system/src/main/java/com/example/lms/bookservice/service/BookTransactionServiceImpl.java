package com.example.lms.bookservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.bookservice.model.Booktransaction;
import com.example.lms.bookservice.repository.BookTransactionRepository;

@Service
public class BookTransactionServiceImpl implements BookTransactionService {

    @Autowired
    private BookTransactionRepository bookTransactionRepository;

    @Override
    public List<Booktransaction> getAllBookTransactions() {
        return bookTransactionRepository.findAll();
    }

    @Override
    public Optional<Booktransaction> getBookTransactionById(int id) {
        return bookTransactionRepository.findById(id);
    }

    @Override
    public Booktransaction saveBookTransaction(Booktransaction bookTransaction) {
        return bookTransactionRepository.save(bookTransaction);
    }

    @Override
    public void deleteBookTransaction(int id) {
        bookTransactionRepository.deleteById(id);
    }

    @Override
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
}