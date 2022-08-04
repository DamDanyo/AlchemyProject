package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="types")
@Component
public class IngredientType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;
	
	@Column
	private String typeName;
	
	//Boilerplate
	public IngredientType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IngredientType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public IngredientType(String typeName) {
		super();
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "IngredientType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
