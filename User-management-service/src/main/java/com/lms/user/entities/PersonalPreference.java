package com.lms.user.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personal_preference")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonalPreference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "preference_id")
	private int id;
	
	@Column(name = "book_name")
	private String bookName;
	
	private String author;
	
	private String category;
	
	private String language;
}
