package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.OrderDAO;

@CrossOrigin
@RestController
@RequestMapping(value="/order")
public class OrderController {
	
	private OrderDAO oDAO;
	@Autowired
	public OrderController() {
		super();
		// TODO Auto-generated constructor stub
	}
	//MVC Methods to Handle HTTP Requests==================
	
	
	//Frontend Methods-----------------------------------
	//Backend Methods-----------------------------------	
	

}
