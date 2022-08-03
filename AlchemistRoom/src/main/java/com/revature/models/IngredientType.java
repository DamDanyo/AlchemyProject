package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="ingredient_types")
@Component
public class IngredientType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int type_id;
	@Column
	private String type_name;

	//Boilerplate
	public IngredientType() {
		super();
		// TODO Auto-generated constructor stub
	}
	//For reading
	public IngredientType(int type_id, String type_name) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
	}
	//For inserting
	public IngredientType(String type_name) {
		super();
		this.type_name = type_name;
	}
	
	//Getters and Setters
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	@Override
	public String toString() {
		return "IngredientType [type_id=" + type_id + ", type_name=" + type_name + "]";
	}
	
	
}
