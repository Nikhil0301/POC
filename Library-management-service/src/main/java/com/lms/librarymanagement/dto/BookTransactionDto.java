package com.lms.librarymanagement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;

public class BookTransactionDto {

    private Long transactionId;
    private Long bookId;
    private Long userId;
    private Date issueDate;
    private Date dueDate;
    private Date returnDate;
    private boolean returned;

    
    public BookTransactionDto(Long i, Long bookId, Long userId, Date issueDate, Date dueDate,
			Date returnDate) {
		super();
		this.transactionId = i;
		this.bookId = bookId;
		this.userId = userId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
	}
    
    public Long getTransactionId() {
        return transactionId;
    }

    
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    
    public Long getBookId() {
        return bookId;
    }

    
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    
    public Long getUserId() {
        return userId;
    }

    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    public Date getIssueDate() {
        return issueDate;
    }

    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    
    public Date getDueDate() {
        return dueDate;
    }

    
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    
    public Date getReturnDate() {
        return returnDate;
    }

    
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    
    public boolean isReturned() {
        return returned;
    }

    
    public void setReturned(boolean returned) {
        this.returned = returned;
    }

	


	
}