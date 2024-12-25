package com.lms.librarymanagement.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "book")
@JsonIdentityReference
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long bookId;
	
	private String title;
	
	private String author;
	
	private Long isbn;
	
	@Column(name = "publish_year")
	private int publishYear;
	
	@Column(name = "avail_status")
	private boolean availableStatus;//(issued/available/NA)
	
	@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Category category;
	
	@OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Booktransaction> bookTransactions;
	
	//supporting method
	public void addCategory(Category category) {
		this.setCategory(category);
	}
	
}
