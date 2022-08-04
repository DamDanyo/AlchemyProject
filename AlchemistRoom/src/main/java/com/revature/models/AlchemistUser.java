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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
public class AlchemistUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column
	@Value("500")
	private int balance;
	
	

	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="classidfk",nullable=false)
	private AlchemistClass classFk;
	
	//Boilerplate-----------------------------
	public AlchemistUser() {
		super();
		// TODO Auto-generated constructor stub
	}
}
