package com.revature.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="alchemist_users")
@Component
public class AlchemistUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String user_password;
	
	@ManyToOne
	@JoinColumn(name="class_id",nullable=false)
	private AlchemistClass user_classfk;
	
	//Boilerplate-----------------------------
	public AlchemistUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlchemistUser(int user_id, String username, String user_password, AlchemistClass user_classfk) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.user_password = user_password;
		this.user_classfk = user_classfk;
	}

	public AlchemistUser(String username, String user_password, AlchemistClass user_classfk) {
		super();
		this.username = username;
		this.user_password = user_password;
		this.user_classfk = user_classfk;
	}
	//Getters and Setters
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public AlchemistClass getUser_classfk() {
		return user_classfk;
	}

	public void setUser_classfk(AlchemistClass user_classfk) {
		this.user_classfk = user_classfk;
	}

	@Override
	public String toString() {
		return "AlchemistUser [user_id=" + user_id + ", username=" + username + ", user_password=" + user_password
				+ ", user_classfk=" + user_classfk + "]";
	}
	
	
	
}
