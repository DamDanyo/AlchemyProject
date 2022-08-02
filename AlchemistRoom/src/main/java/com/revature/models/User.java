package com.revature.models;

public class User {

	private int user_id;
	private String username;
	private String user_password;
	private int user_classfk;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int user_id, String username, String user_password, int user_classfk) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.user_password = user_password;
		this.user_classfk = user_classfk;
	}


	public User(String username, String user_password, int user_classfk) {
		super();
		this.username = username;
		this.user_password = user_password;
		this.user_classfk = user_classfk;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", user_password=" + user_password
				+ ", user_classfk=" + user_classfk + "]";
	}


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


	public int getUser_classfk() {
		return user_classfk;
	}


	public void setUser_classfk(int user_classfk) {
		this.user_classfk = user_classfk;
	}
	
	
	
}
