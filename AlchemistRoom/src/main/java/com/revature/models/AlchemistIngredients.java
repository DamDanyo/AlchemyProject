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
@Table(name="ingredients")
@Component
public class AlchemistIngredients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ingredientId;
	
	@Column
	private String ingredientName;
	
	@ManyToOne
	@JoinColumn(name="typeId",nullable=false)
	private IngredientType typeFk;
	
	//Boilerplate-----------------------------
	public AlchemistIngredients() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlchemistIngredients(int ingredientId, String ingredientName, IngredientType typeFk) {
		super();
		this.ingredientId = ingredientId;
		this.ingredientName = ingredientName;
		this.typeFk = typeFk;
	}

	public AlchemistIngredients(String ingredientName, IngredientType typeFk) {
		super();
		this.ingredientName = ingredientName;
		this.typeFk = typeFk;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public IngredientType getTypeFk() {
		return typeFk;
	}

	public void setTypeFk(IngredientType typeFk) {
		this.typeFk = typeFk;
	}

	@Override
	public String toString() {
		return "AlchemistIngredients [ingredientId=" + ingredientId + ", ingredientName=" + ingredientName + ", typeFk="
				+ typeFk + "]";
	}

	
}
