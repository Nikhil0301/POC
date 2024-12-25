package com.example.lms.bookservice.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDesc() {
        return desc;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String desc;

    @OneToMany(mappedBy = "category" , fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Book> books; //one category has many books

}
