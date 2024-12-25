package com.example.lms.bookservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.lms.bookservice.model.Booktransaction;
import com.example.lms.bookservice.service.BookTransactionService;

@RestController
@RequestMapping("/api/booktransactions")
public class BookTransactionController {

    @Autowired
    private BookTransactionService bookTransactionService;

    @GetMapping
    public List<Booktransaction> getAllBookTransactions() {
        return bookTransactionService.getAllBookTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booktransaction> getBookTransactionById(@PathVariable int id) {
        Optional<Booktransaction> bookTransaction = bookTransactionService.getBookTransactionById(id);
        if (bookTransaction.isPresent()) {
            return ResponseEntity.ok(bookTransaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Booktransaction createBookTransaction(@RequestBody Booktransaction bookTransaction) {
        return bookTransactionService.saveBookTransaction(bookTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booktransaction> updateBookTransaction(@PathVariable int id, @RequestBody Booktransaction bookTransactionDetails) {
        Booktransaction updatedBookTransaction = bookTransactionService.updateBookTransaction(id, bookTransactionDetails);
        if (updatedBookTransaction != null) {
            return ResponseEntity.ok(updatedBookTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookTransaction(@PathVariable int id) {
        bookTransactionService.deleteBookTransaction(id);
        return ResponseEntity.noContent().build();
    }
}