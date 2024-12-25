package com.example.lms.bookservice.service;

import java.util.List;
import java.util.Optional;

import com.example.lms.bookservice.model.Booktransaction;

public interface BookTransactionService {
    List<Booktransaction> getAllBookTransactions();
    Optional<Booktransaction> getBookTransactionById(int id);
    Booktransaction saveBookTransaction(Booktransaction bookTransaction);
    void deleteBookTransaction(int id);
    Booktransaction updateBookTransaction(int id, Booktransaction bookTransactionDetails);
}