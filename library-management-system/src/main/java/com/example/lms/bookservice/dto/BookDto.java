package com.example.lms.bookservice.dto;

public class BookDto {

    private Long bookId;
    private String bname;
    private String author;
    private int publishYear;
    private boolean availableStatus;
    private Long categoryId;
    private Long isbn;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(boolean availableStatus) {
        this.availableStatus = availableStatus;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }








}