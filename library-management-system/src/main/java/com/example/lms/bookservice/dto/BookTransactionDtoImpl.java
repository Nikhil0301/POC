package com.example.lms.bookservice.dto;

import java.util.Date;

public class BookTransactionDtoImpl implements BookTransactionDto {

    private Long transactionId;
    private Long bookId;
    private Long userId;
    private Date issueDate;
    private Date dueDate;
    private Date returnDate;
    private boolean returned;

    public BookTransactionDtoImpl() {
    }

    @Override
    public Long getTransactionId() {
        return transactionId;
    }

    @Override
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public Long getBookId() {
        return bookId;
    }

    @Override
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Date getIssueDate() {
        return issueDate;
    }

    @Override
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public Date getReturnDate() {
        return returnDate;
    }

    @Override
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean isReturned() {
        return returned;
    }

    @Override
    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}