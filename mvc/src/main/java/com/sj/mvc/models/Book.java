package com.sj.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min =2)
	private String title;
	@NotNull
	@Size(max = 500)
	private String description;
	@NotNull
	@Size(min = 2, max = 100)
	private String language;
	@NotNull
	@Min(50)
	@Max(1500)
	private Integer numberOfPages;
	
	
	 // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
 // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
//    CONSTRUCTORS
//    first empty constructor
    public Book() {}
//    second constructor with all necessary parameters
	public Book(
			@NotNull @Size(min = 2) String title,
			@NotNull @Size(max = 500) String description,
			@NotNull @Size(min = 2, max = 100) String language,
			@NotNull @Min(50) @Max(1500) Integer numberOfPages) {
		super();
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}
    
    
    
//    GETTERS AND SETTERS
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
    public String getDescription() {
    	return description;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    public String getLanguage() {
    	return language;
    }
    public void setLanguage(String language) {
    	this.language = language;
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
