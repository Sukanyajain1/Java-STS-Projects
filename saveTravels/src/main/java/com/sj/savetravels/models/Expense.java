package com.sj.savetravels.models;

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
@Table(name = "expenses")
public class Expense {
//	member variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 255, message = "The expense name must be between 1 and 255")
	private String expenseName;
	
	@NotNull
	@Size(min = 1, max = 255, message = "The vendor name must be between 1 and 255")
	private String vendor;

	@NotNull
	@Min(value=0, message = "The price must be at least $0")
	private double amount;
	
	@NotNull
	@Size(min = 1, max = 1000, message = "The description must be between 1 and 255")
	private String description;

	
//	This will not allow the createdAT column to be updated after creation
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
//	empty constructor
	public Expense () {}
//	actual constructor
	public Expense (String expenseName, String vendor, int amount, String description) {
		this.expenseName = expenseName;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

//	conditions for the created_at and updated_at:
//	THE METHODS THAT RUN RIGHT BEFORE THE OBJECT IS CREATED AND WHEN THE OBJECT IS MODIFIED
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	
	
//	regular getters and setters

	

	
}
