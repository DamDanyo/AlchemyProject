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
@Table(name="orders")
@Component
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid") //THIS is how you specify the PK that this FK is referring to
	//the name attribute MUST be equal to the name of the id in the Trainer class (trainerId)
	//IMPORTANT NOTE: we can't use @Column here, because @JoinColumn already makes it a column
	private AlchemistUser useridFK;
	
	@Column(nullable=false)
	private String orderaddress;
	
	@Column(nullable=false)
	private int ordertotal;
	
	@Column(name="items")
	@ElementCollection(targetClass=Potion.class)
	private List<Potion> items;
	
}
