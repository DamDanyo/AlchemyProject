package com.revature.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="alchemist_inventory")
@Component
public class AlchemistInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventory_id;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private AlchemistUser user_idfk;
	
	@Column(columnDefinition = "integer default 500")
	private int user_gold;
	
	  @OneToMany
      @JoinTable(name = "alchemist_ingredients" , joinColumns = @JoinColumn(name = "ingredient_id"))
      private List<AlchemistIngredients> items;
	  
	//Boilerplate-----------------------------
	public AlchemistInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlchemistInventory(int inventory_id, AlchemistUser user_idfk, int user_gold,
			List<AlchemistIngredients> items) {
		super();
		this.inventory_id = inventory_id;
		this.user_idfk = user_idfk;
		this.user_gold = user_gold;
		this.items = items;
	}

	public AlchemistInventory(AlchemistUser user_idfk, int user_gold, List<AlchemistIngredients> items) {
		super();
		this.user_idfk = user_idfk;
		this.user_gold = user_gold;
		this.items = items;
	}
	
	//Getters and Setters
	public int getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}

	public AlchemistUser getUser_idfk() {
		return user_idfk;
	}

	public void setUser_idfk(AlchemistUser user_idfk) {
		this.user_idfk = user_idfk;
	}

	public int getUser_gold() {
		return user_gold;
	}

	public void setUser_gold(int user_gold) {
		this.user_gold = user_gold;
	}

	public List<AlchemistIngredients> getItems() {
		return items;
	}

	public void setItems(List<AlchemistIngredients> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "AlchemistInventory [inventory_id=" + inventory_id + ", user_idfk=" + user_idfk + ", user_gold="
				+ user_gold + ", items=" + items + "]";
	}



}
