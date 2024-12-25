package com.lms.user.entities;

import java.sql.Date;

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
@Table(name = "search_history")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SearchHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "search_id")
	private int searchId;
	
	@Column(name = "search_query")
	private String searchQuery;
	
	@Column(name = "search_date")
	private Date searchDate;
	
}
