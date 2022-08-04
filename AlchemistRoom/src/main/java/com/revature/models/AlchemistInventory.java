package com.revature.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name="inventory")
@Component
public class AlchemistInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryid;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid") //THIS is how you specify the PK that this FK is referring to
	//the name attribute MUST be equal to the name of the id in the Trainer class (trainerId)
	//IMPORTANT NOTE: we can't use @Column here, because @JoinColumn already makes it a column
	private AlchemistUser useridFK;
		
	@Column(name="items")
	@ElementCollection(targetClass=Potion.class)
	private List<Potion> items;
	  
	//Boilerplate-----------------------------
	public AlchemistInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
