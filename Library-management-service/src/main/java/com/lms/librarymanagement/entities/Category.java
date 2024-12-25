package com.lms.librarymanagement.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "description")
	private String desc;
	
	@OneToMany(mappedBy = "category" , fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Book> books; //one category has many books
	
}
