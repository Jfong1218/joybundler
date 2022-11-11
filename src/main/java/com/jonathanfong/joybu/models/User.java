package com.jonathanfong.joybu.models;

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

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name is required!")
	@Size(min=3, max=30, message="Name must be between 3 and 30 characters")
	private String name;
	
	@NotEmpty(message="Email is required!")
	@Email(message="Must enter a valid email")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=3, max=128, message="Password must be at least 3 characters long")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password is required")
	@Size(min=3, max=128, message="Confirm Password must be at least 3 characters long")
	private String confirm;
	
	// This will not allow the createdAt column to be updated after creation
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
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Bundle> bundles;
	
    public User() {}
	public User(
			@NotEmpty(message = "Name is required!") @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters") String name,
			@NotEmpty(message = "Email is required!") @Email(message = "Must enter a valid email") String email,
			@NotEmpty(message = "Password is required!") @Size(min = 3, max = 128, message = "Password must be at least 3 characters long") String password,
			@NotEmpty(message = "Confirm Password is required") @Size(min = 3, max = 128, message = "Confirm Password must be at least 3 characters long") String confirm,
			List<Bundle> bundles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.bundles = bundles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<Bundle> getBundles() {
		return bundles;
	}
	public void setBundles(List<Bundle> bundles) {
		this.bundles = bundles;
	}
    
	
}
