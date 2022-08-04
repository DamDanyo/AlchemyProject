package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="alchemistclass")
@Component
public class AlchemistClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	
	@Column(nullable=false)
	private String className;
	
	//Boilerplate--------------
	public AlchemistClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlchemistClass(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public AlchemistClass(String className) {
		super();
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "AlchemistClass [classId=" + classId + ", className=" + className + "]";
	}

}
