package com.revature.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.OrderDAO;
import com.revature.daos.PotionDAO;
import com.revature.daos.UserDAO;
import com.revature.models.AlchemistUser;
import com.revature.models.Order;
import com.revature.models.Potion;

@CrossOrigin
@RestController
@RequestMapping(value="/order")
public class OrderController {
	
	private OrderDAO oDAO;
	private UserDAO uDAO;
	
	@Autowired
	public OrderController(OrderDAO oDAO,UserDAO uDAO) {
		super();
		this.oDAO = oDAO;
		this.uDAO = uDAO;
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
	
	//Insert Order 
	@PostMapping(value="/insert")
	public ResponseEntity<Order> addOrder(@RequestBody Order o){
			
			//If total isn't provided
			if(o.getOrdertotal()==0) {
				int total =0;
				for(int i=0;i<o.getItems().size();i++) {
					total += (o.getItems().get(i) * o.getItemsquantity().get(i));
				}
				o.setOrdertotal(total);
			}

			Order newOrder = oDAO.save(o);			
				
			if(newOrder == null) {
				return ResponseEntity.badRequest().build();
				
			}		
			return ResponseEntity.accepted().body(newOrder);
	}
	
	//Backend Methods-----------------------------------	
	

}
