package com.revature.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name="inventory")
@Component
public class AlchemistInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId;
	
	@ManyToOne
	@JoinColumn(name="userId",nullable=false)
	private AlchemistUser userIdFk;
	
	@Column(columnDefinition = "integer default 500")
	private int inventoryGold;
	
	@Column(name="items")
	@ElementCollection(targetClass=AlchemistIngredients.class)
	private List<AlchemistIngredients> items;
	  
	//Boilerplate-----------------------------
	public AlchemistInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlchemistInventory(int inventoryId, AlchemistUser userIdFk, int inventoryGold,
			List<AlchemistIngredients> items) {
		super();
		this.inventoryId = inventoryId;
		this.userIdFk = userIdFk;
		this.inventoryGold = inventoryGold;
		this.items = items;
	}

	public AlchemistInventory(AlchemistUser userIdFk, int inventoryGold, List<AlchemistIngredients> items) {
		super();
		this.userIdFk = userIdFk;
		this.inventoryGold = inventoryGold;
		this.items = items;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public AlchemistUser getUserIdFk() {
		return userIdFk;
	}

	public void setUserIdFk(AlchemistUser userIdFk) {
		this.userIdFk = userIdFk;
	}

	public int getInventoryGold() {
		return inventoryGold;
	}

	public void setInventoryGold(int inventoryGold) {
		this.inventoryGold = inventoryGold;
	}

	public List<AlchemistIngredients> getItems() {
		return items;
	}

	public void setItems(List<AlchemistIngredients> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "AlchemistInventory [inventoryId=" + inventoryId + ", userIdFk=" + userIdFk + ", inventoryGold="
				+ inventoryGold + ", items=" + items + "]";
	}
	


}
