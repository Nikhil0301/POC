package com.lms.librarymanagement.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "book_transaction")
public class Booktransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "issue_date")
	private Date issueDate;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "return_date")
	private Date returnDate;
	
	private int fine;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bk_id", referencedColumnName = "book_id", nullable = false)
	private Book book;
	
	private Long userId;
	
}
