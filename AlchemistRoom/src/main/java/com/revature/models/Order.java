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

import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Component;

@Entity
@Table(name="orders")
@Component
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name = "userid") //THIS is how you specify the PK that this FK is referring to
	//the name attribute MUST be equal to the name of the id in the Trainer class (trainerId)
	//IMPORTANT NOTE: we can't use @Column here, because @JoinColumn already makes it a column
	private AlchemistUser useridFK;
	
	@Column(nullable=false)
	private String orderaddress;
	
	@Column(nullable=false)
	private int ordertotal;
	
	@Column(name="items")
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> items;
	
	//The indices for this array will correspond to the ids in items array
	@Column(name="itemsquantity")
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> itemsquantity;
	
	
	//-------------------Constructors
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	//for getting
	public Order(int orderid, AlchemistUser useridFK, String orderaddress, int ordertotal, List<Integer> items, List<Integer> itemsquantity) {
		super();
		this.orderid = orderid;
		this.useridFK = useridFK;
		this.orderaddress = orderaddress;
		this.ordertotal = ordertotal;
		this.items = items;
	}
	//for inserting
	public Order(AlchemistUser useridFK, String orderaddress, int ordertotal, List<Integer> items, List<Integer> itemsquantity) {
		super();
		this.useridFK = useridFK;
		this.orderaddress = orderaddress;
		this.ordertotal = ordertotal;
		this.items = items;
		this.items = itemsquantity;
	}
	//-------------------Setters and Getters

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public AlchemistUser getUseridFK() {
		return useridFK;
	}

	public void setUseridFK(AlchemistUser useridFK) {
		this.useridFK = useridFK;
	}

	public String getOrderaddress() {
		return orderaddress;
	}

	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}

	public int getOrdertotal() {
		return ordertotal;
	}

	public void setOrdertotal(int ordertotal) {
		this.ordertotal = ordertotal;
	}

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}
	
	public List<Integer> getItemsquantity() {
		return itemsquantity;
	}
	
	public void setItemsquantity(List<Integer> itemsquantity) {
		this.itemsquantity = itemsquantity;
	}
	
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", useridFK=" + useridFK + ", orderaddress=" + orderaddress
				+ ", ordertotal=" + ordertotal + ", items=" + items + "]";
	}
	
	
	
	
}
