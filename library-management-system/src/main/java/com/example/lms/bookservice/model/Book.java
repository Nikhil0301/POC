package com.example.lms.bookservice.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    private String title;

    private String author;

    private Long isbn;

    @Column(name = "publish_year")
    private int publishYear;

    @Column(name = "avail_status")
    private boolean availableStatus; //(issued/available/NA)

    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = true)
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Booktransaction> bookTransactions;

    // Getters and Setters

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Booktransaction> getBookTransactions() {
        return bookTransactions;
    }

    public void setBookTransactions(List<Booktransaction> bookTransactions) {
        this.bookTransactions = bookTransactions;
    }
}