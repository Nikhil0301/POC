package com.example.lms.bookservice.dto;

import java.util.Date;

public interface BookTransactionDto {
    Long getTransactionId();
    void setTransactionId(Long transactionId);

    Long getBookId();
    void setBookId(Long bookId);

    Long getUserId();
    void setUserId(Long userId);

    Date getIssueDate();
    void setIssueDate(Date issueDate);

    Date getDueDate();
    void setDueDate(Date dueDate);

    Date getReturnDate();
    void setReturnDate(Date returnDate);

    boolean isReturned();
    void setReturned(boolean returned);
}