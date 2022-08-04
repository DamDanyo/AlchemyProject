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
@Table(name="recipe")
@Component
public class AlchemistRecipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipeId;
	
	@Column(nullable=false)
	private String recipeName;
	
	@ManyToOne
	@MapsId("ingredient1fk")
	@JoinColumn(name="ingredientId")
	private AlchemistIngredients ingredient1;
	
	@ManyToOne
	@MapsId("ingredient2fk")
	@JoinColumn(name="ingredientId")
	private AlchemistIngredients ingredient2;
	
	@Column(nullable=false)
	private int recipeValue;
	
	public AlchemistRecipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlchemistRecipe(int recipeId, String recipeName, AlchemistIngredients ingredient1,
			AlchemistIngredients ingredient2, int recipeValue) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.ingredient1 = ingredient1;
		this.ingredient2 = ingredient2;
		this.recipeValue = recipeValue;
	}

	public AlchemistRecipe(String recipeName, AlchemistIngredients ingredient1, AlchemistIngredients ingredient2,
			int recipeValue) {
		super();
		this.recipeName = recipeName;
		this.ingredient1 = ingredient1;
		this.ingredient2 = ingredient2;
		this.recipeValue = recipeValue;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
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

	public int getRecipeValue() {
		return recipeValue;
	}

	public void setRecipeValue(int recipeValue) {
		this.recipeValue = recipeValue;
	}

	@Override
	public String toString() {
		return "AlchemistRecipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", ingredient1=" + ingredient1
				+ ", ingredient2=" + ingredient2 + ", recipeValue=" + recipeValue + "]";
	}	
	
	
	
}
