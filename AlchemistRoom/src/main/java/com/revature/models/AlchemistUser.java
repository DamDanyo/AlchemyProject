package com.revature.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
public class AlchemistUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
		
	@Column
	@Value("false")
	private boolean isadmin;
	
	//-------------------Constructors
	public AlchemistUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//For getting
	public AlchemistUser(int userid, String username, String password, boolean isadmin) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.isadmin = isadmin;
	}
	//For inserting
	public AlchemistUser(String username, String password, boolean isadmin) {
		super();
		this.username = username;
		this.password = password;
		this.isadmin = isadmin;
	}
	//-------------------Setters and Getters
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	@Override
	public String toString() {
		return "AlchemistUser [userid=" + userid + ", username=" + username + ", password=" + password + ", isadmin="
				+ isadmin + "]";
	}
	
	
	
}
