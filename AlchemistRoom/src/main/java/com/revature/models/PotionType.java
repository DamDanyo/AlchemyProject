package com.revature.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="potiontypes")
@Component
public class PotionType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeid;
	
	@Column
	private String typename;
	
	//Boilerplate
	public PotionType() {
		super();
		// TODO Auto-generated constructor stub
	}

}
