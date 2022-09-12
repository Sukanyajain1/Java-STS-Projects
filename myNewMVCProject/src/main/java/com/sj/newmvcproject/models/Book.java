package com.sj.newmvcproject.models;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity


//making the table in the DATABASE- NO ERDS ANYMORE T_T
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 200)
	private String title;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String language;
	
	@NotNull
	@Size(min=5, max = 200)
	private String description;
	
	@NotNull
	@Min(100)
	private Integer numberOfPages;
	
	
//	This will not allow the createdAT column to be updated after creation
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
//	now we are creating the empty constructor and the actual constructor
//	EMPTY CONSTRUCTOR
	public Book() {}
//	ACTUAL CONSTRUCTOR
	public Book( String title, String language, String description, int numberOfPages) {
		this.title = title;
		this.language = language;
		this.description = description;
		this.numberOfPages = numberOfPages;
	}
	
	
//	THE METHODS THAT RUN RIGHT BEFORE THE OBJECT IS CREATED AND WHEN THE OBJECT IS MODIFIED
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
//	THE REGULAR GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
}
