package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping(value="{id}/updateOrder")
	public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order orderDetails){
		Optional<Order> orderOptional = oDAO.findById(id);
		if(orderOptional.isPresent()) {
			Order order = new Order();
			order.setOrderaddress(orderDetails.getOrderaddress());
			order.setOrdertotal(orderDetails.getOrdertotal());
			return ResponseEntity.ok(oDAO.save(order));
		}
		return ResponseEntity.badRequest().build();
	}
	//Backend Methods-----------------------------------	
	

}
