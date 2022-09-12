package com.sj.bookclub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


//=============================================================================
//MEMBER VARIABLES
//=============================================================================

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="This field must be completed.")
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
    private String userName;
    
    @NotEmpty(message="This field must be completed.")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="This field must be completed.")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="This field must be completed.")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
  
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    
    
// ---------------------------------------------------------
// RELATIONSHIP
// ---------------------------------------------------------
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Shows> shows;
    
    
    
    
// ---------------------------------------------------------
// CONSTRUCTORS
// ---------------------------------------------------------
    public User() {}
    
	public User(Long id,
			@NotEmpty(message = "This field must be completed.") @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters") String userName,
			@NotEmpty(message = "This field must be completed.") @Email(message = "Please enter a valid email!") String email,
			@NotEmpty(message = "This field must be completed.") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password,
			@NotEmpty(message = "This field must be completed.") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm,
			Date createdAt, Date updatedAt, List<Shows> shows) {
	
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.shows = shows;
	}
	
	
	
	
// ---------------------------------------------------------
// GETTERS AND SETTERS
// ---------------------------------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
	public List<Shows> getShows() {
		return shows;
	}
	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}
    
	
	
	

	

    


    
    
    
}