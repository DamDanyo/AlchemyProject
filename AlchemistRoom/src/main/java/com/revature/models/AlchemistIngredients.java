package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="alchemist_ingredients")
@Component
public class AlchemistIngredients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ingredient_id;
	@Column
	private String ingredient_name;
	@Column
	private int type_FK;
	
	
	//Boiletplate-------------------
	public AlchemistIngredients() {
		super();
		// TODO Auto-generated constructor stub
	}
	//For reading
	public AlchemistIngredients(int ingredient_id, String ingredient_name, int type_FK) {
		super();
		this.ingredient_id = ingredient_id;
		this.ingredient_name = ingredient_name;

		this.type_FK = type_FK;
	}
	//For inserting	
	public AlchemistIngredients(String ingredient_name, int type_FK) {
		super();
		this.ingredient_name = ingredient_name;
		this.type_FK = type_FK;
	}
	@Override
	public String toString() {
		return "AlchemistIngredients [ingredient_id=" + ingredient_id + ", ingredient_name=" + ingredient_name
				+ ", type_FK=" + type_FK + "]";
	}
	
	
}
