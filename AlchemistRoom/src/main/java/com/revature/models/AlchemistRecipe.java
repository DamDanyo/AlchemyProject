package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="alchemist_recipe")
@Component
public class AlchemistRecipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipe_id;
	@Column
	private String recipe_name;
	@Column
	private int ingredient1FK;
	@Column
	private int ingredient2Fk;
	@Column
	private int recipe_value;

	
	//Boilerplate
	public AlchemistRecipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	//For reading
	public AlchemistRecipe(int recipe_id, String recipe_name, int ingredient1fk, int ingredient2Fk, int recipe_value) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_name = recipe_name;
		ingredient1FK = ingredient1fk;
		this.ingredient2Fk = ingredient2Fk;
		this.recipe_value = recipe_value;
	}
	//For inserting
	public AlchemistRecipe(String recipe_name, int ingredient1fk, int ingredient2Fk, int recipe_value) {
		super();
		this.recipe_name = recipe_name;
		ingredient1FK = ingredient1fk;
		this.ingredient2Fk = ingredient2Fk;
		this.recipe_value = recipe_value;
	}

	@Override
	public String toString() {
		return "AlchemistRecipe [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", ingredient1FK="
				+ ingredient1FK + ", ingredient2Fk=" + ingredient2Fk + ", recipe_value=" + recipe_value + "]";
	}
	
	
	
}
