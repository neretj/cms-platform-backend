package com.mojdan.admin.model.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String password;

	private String phonenumber;

	@Enumerated(EnumType.STRING)
	private Status status;

	private String resetPassToken;

	private Date dateExpPassToken;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getResetPassToken() {
		return resetPassToken;
	}

	public void setResetPassToken(String resetPassToken) {
		this.resetPassToken = resetPassToken;
	}

	public Date getDateExpPassToken() {
		return dateExpPassToken;
	}

	public void setDateExpPassToken(Date dateExpPassToken) {
		this.dateExpPassToken = dateExpPassToken;
	}

}