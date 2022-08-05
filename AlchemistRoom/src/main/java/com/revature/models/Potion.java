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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int potionid;
	
	@Column
	private String potionname;
	
	@Column
	private String potiondescription;
	
	@Column
	private int potionvalue;
	
	@Column
	private int potionquantity;
	
	//-------------------Constructors
	public Potion() {
		super();
		// TODO Auto-generated constructor stub
	}
	//For getting
	public Potion(int potionid, String potionname, String potiondescription, int potionvalue, int potionquantity) {
		super();
		this.potionid = potionid;
		this.potionname = potionname;
		this.potiondescription = potiondescription;
		this.potionvalue = potionvalue;
		this.potionquantity = potionquantity;
	}
	//For inserting
	public Potion(String potionname, String potiondescription, int potionvalue, int potionquantity) {
		super();
		this.potionname = potionname;
		this.potiondescription = potiondescription;
		this.potionvalue = potionvalue;
		this.potionquantity = potionquantity;
	}
	
	//-------------------Setters and Getters
	public int getPotionid() {
		return potionid;
	}
	public void setPotionid(int potionid) {
		this.potionid = potionid;
	}
	public String getPotionname() {
		return potionname;
	}
	public void setPotionname(String potionname) {
		this.potionname = potionname;
	}
	public String getPotiondescription() {
		return potiondescription;
	}
	public void setPotiondescription(String potiondescription) {
		this.potiondescription = potiondescription;
	}
	public int getPotionvalue() {
		return potionvalue;
	}
	public void setPotionvalue(int potionvalue) {
		this.potionvalue = potionvalue;
	}
	public int getPotionquantity() {
		return potionquantity;
	}
	public void setPotionquantity(int potionquantity) {
		this.potionquantity = potionquantity;
	}
	@Override
	public String toString() {
		return "Potion [potionid=" + potionid + ", potionname=" + potionname + ", potiondescription="
				+ potiondescription + ", potionvalue=" + potionvalue + ", potionquantity=" + potionquantity + "]";
	}
	
	
	
	

}
