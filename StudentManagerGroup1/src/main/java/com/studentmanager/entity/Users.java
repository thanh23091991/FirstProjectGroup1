package com.studentmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Column(name = "email", columnDefinition = "varchar(30)", nullable = false)
	private String email;
	@Column(name = "password", columnDefinition = "varchar(30)", nullable = false)
	private String password;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public Users(long userId, String email, String password) {
		this.userId = userId;
		this.email = email;
		this.password = password;
	}

	public Users(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Users() {
	}

}
