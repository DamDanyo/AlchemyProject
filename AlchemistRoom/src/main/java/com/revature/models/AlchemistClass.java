package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="alchemist_class")
@Component
public class AlchemistClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int type_id;
	
	@Column(nullable=false)
	private String class_name;
	
	//Boilerplate--------------
	public AlchemistClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	//For reading
	public AlchemistClass(int type_id, String class_name) {
		super();
		this.type_id = type_id;
		this.class_name = class_name;
	}
	//For inserting
	public AlchemistClass(String class_name) {
		super();
		this.class_name = class_name;
	}
	
	//Setters and Getters------
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	@Override
	public String toString() {
		return "AlchemistClass [type_id=" + type_id + ", class_name=" + class_name + "]";
	}
	
	

	
}
