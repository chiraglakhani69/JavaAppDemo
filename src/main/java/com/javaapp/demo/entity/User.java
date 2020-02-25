package com.javaapp.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javaapp.demo.dto.RegisterRequest;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = {"createdDate", "updatedDate"}, allowGetters = true)
@Access(value= AccessType.FIELD)
public class User implements Serializable {

	private static final long serialVersionUID = 4537475462089263162L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_name", nullable = false)
	private String userName;

	private String email;

	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(nullable = false)
	private String pin;
	
	@Column(name="user_id", nullable = false)
	private String userId;
	
	@Column(name="created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @Column(name="updated_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;
    
    public User() {
	}

	public User(RegisterRequest registerRequest) {
		this.setCreatedDate(new Date());
		this.setUpdatedDate(new Date());
		this.setUserName(registerRequest.getUserName());
		this.setPin(registerRequest.getPin());
		this.setEmail(registerRequest.getEmail());
		this.setPhoneNumber(registerRequest.getPhoneNumber());
		this.setUserId(UUID.randomUUID().toString());
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
