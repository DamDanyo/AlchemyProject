package com.revature.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
public class AlchemistUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	

	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="classId",nullable=false)
	private AlchemistClass classFk;
	
	//Boilerplate-----------------------------
	public AlchemistUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlchemistUser(int userId, String username, String password, AlchemistClass classFk) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.classFk = classFk;
	}

	public AlchemistUser(String username, String password, AlchemistClass classFk) {
		super();
		this.username = username;
		this.password = password;
		this.classFk = classFk;
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public AlchemistClass getClassFk() {
		return classFk;
	}

	public void setClassFk(AlchemistClass classFk) {
		this.classFk = classFk;
	}
}
