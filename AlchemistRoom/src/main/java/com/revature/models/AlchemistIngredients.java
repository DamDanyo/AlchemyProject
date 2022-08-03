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
@Table(name="alchemist_ingredients")
@Component
public class AlchemistIngredients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ingredient_id;
	
	@Column
	private String ingredient_name;
	
	@ManyToOne
	@JoinColumn(name="type_id",nullable=false)
	private IngredientType type;
	
	//Boilerplate-----------------------------
	public AlchemistIngredients() {
		super();
		// TODO Auto-generated constructor stub
	}
	//For Reading
	public AlchemistIngredients(int ingredient_id, String ingredient_name, IngredientType type) {
		super();
		this.ingredient_id = ingredient_id;
		this.ingredient_name = ingredient_name;
		this.type = type;
	}
	//For Inserting
	public AlchemistIngredients(String ingredient_name, IngredientType type) {
		super();
		this.ingredient_name = ingredient_name;
		this.type = type;
	}
	
	//Getters and Setters
	public int getIngredient_id() {
		return ingredient_id;
	}

	public void setIngredient_id(int ingredient_id) {
		this.ingredient_id = ingredient_id;
	}

	public String getIngredient_name() {
		return ingredient_name;
	}

	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}

	public IngredientType getType() {
		return type;
	}

	public void setType(IngredientType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AlchemistIngredients [ingredient_id=" + ingredient_id + ", ingredient_name=" + ingredient_name
				+ ", type=" + type + "]";
	}	
	
	
}
