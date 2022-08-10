package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.OrderDAO;
import com.revature.models.Order;

@CrossOrigin
@RestController
@RequestMapping(value="/order")
public class OrderController {
	
	private OrderDAO oDAO;
	@Autowired
	public OrderController(OrderDAO oDAO) {
		super();
		this.oDAO = oDAO;
		// TODO Auto-generated constructor stub
	}
	//MVC Methods to Handle HTTP Requests==================
	
	
	//Frontend Methods-----------------------------------
	//Get all potions
	@GetMapping(value="/all")
	public ResponseEntity<List<Order>> getAllOrder(){
		return ResponseEntity.ok(oDAO.findAll());
	}
	
	//Get Potion by id
	@GetMapping(value="/byId/{id}")
	public ResponseEntity<Order> findById(@PathVariable int id){
		
		Optional<Order> optionalOrder = oDAO.findById(id);
		
		if (optionalOrder.isPresent()) {
			Order o = optionalOrder.get();
			return ResponseEntity.ok(o);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	//Backend Methods-----------------------------------	
	

}
