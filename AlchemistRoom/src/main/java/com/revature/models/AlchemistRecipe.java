package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="alchemist_recipe")
@Component
public class AlchemistRecipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipe_id;
	
	@Column(nullable=false)
	private String recipe_name;
	
	@ManyToOne
	@MapsId("ingredient1fk")
	@JoinColumn(name="ingredient_id")
	private AlchemistIngredients ingredient1;
	
	@ManyToOne
	@MapsId("ingredient2fk")
	@JoinColumn(name="ingredient_id")
	private AlchemistIngredients ingredient2;
	
	@Column(nullable=false)
	private int recipe_value;
	public AlchemistRecipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlchemistRecipe(int recipe_id, String recipe_name, AlchemistIngredients ingredient1,
			AlchemistIngredients ingredient2, int recipe_value) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_name = recipe_name;
		this.ingredient1 = ingredient1;
		this.ingredient2 = ingredient2;
		this.recipe_value = recipe_value;
	}
	public AlchemistRecipe(String recipe_name, AlchemistIngredients ingredient1, AlchemistIngredients ingredient2,
			int recipe_value) {
		super();
		this.recipe_name = recipe_name;
		this.ingredient1 = ingredient1;
		this.ingredient2 = ingredient2;
		this.recipe_value = recipe_value;
	}
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public AlchemistIngredients getIngredient1() {
		return ingredient1;
	}
	public void setIngredient1(AlchemistIngredients ingredient1) {
		this.ingredient1 = ingredient1;
	}
	public AlchemistIngredients getIngredient2() {
		return ingredient2;
	}
	public void setIngredient2(AlchemistIngredients ingredient2) {
		this.ingredient2 = ingredient2;
	}
	public int getRecipe_value() {
		return recipe_value;
	}
	public void setRecipe_value(int recipe_value) {
		this.recipe_value = recipe_value;
	}
	@Override
	public String toString() {
		return "AlchemistRecipe [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", ingredient1="
				+ ingredient1 + ", ingredient2=" + ingredient2 + ", recipe_value=" + recipe_value + "]";
	}

	
	
	
	
}
