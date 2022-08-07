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
	
	//has to match api
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column(name="description",columnDefinition = "varchar(500) default 'Unknown'" )
	private String description;
	
	@Column
	private int potionvalue;
	
	@Column
	private int potionquantity;
	
	//-------------------Constructors
	public Potion() {
		super();
		// TODO Auto-generated constructor stub
	}
	//For getting on front end
	public Potion(int id, String name, String description, int potionvalue, int potionquantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.potionvalue = potionvalue;
		this.potionquantity = potionquantity;
	}
	//For inserting
	public Potion(String name, String description, int potionvalue, int potionquantity) {
		super();
		this.name = name;
		this.description = description;
		this.potionvalue = potionvalue;
		this.potionquantity = potionquantity;
	}
	//For getting from api
		public Potion(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
		
	//-------------------Setters and Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPotionvalue() {
		return potionvalue;
	}
	public void setPotionvalue(int potionvalue) {
		this.potionvalue = potionvalue*this.id;
	}
	public int getPotionquantity() {
		return potionquantity;
	}
	public void setPotionquantity(int potionquantity) {
		this.potionquantity = potionquantity;
	}
	@Override
	public String toString() {
		return "Potion [id=" + id + ", name=" + name + ", description="
				+ description + ", potionvalue=" + potionvalue + ", potionquantity=" + potionquantity + "]";
	}
	
	
	
	

}
