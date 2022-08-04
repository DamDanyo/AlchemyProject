package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="potions")
@Component
public class Potion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int potionid;
	
	@Column
	private String potionname;
	
	@Column
	private String potiondescription;
	
	@Column
	private int potionvalue;
	
	@Column
	private int potionquantity;
	//Boilerplate-----------------------------
	public Potion() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
