package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.PotionTypeDAO;
import com.revature.models.PotionType;

@RestController 
@RequestMapping(value="/type") 
public class PotionTypeController {

	private PotionTypeDAO tDAO;
	
	//constructor injection 
	@Autowired
	public PotionTypeController(PotionTypeDAO tDAO) {
		super();
		this.tDAO = tDAO;
	}

	//MVC Methods to handle HTTP Requests-----------------------------------
	
	//insert type - every POST request to /type will go here
	@PostMapping
	public ResponseEntity<PotionType> addPotionType(@RequestBody PotionType t) {
		
		//the save() method from our DAO is how we do INSERTs
		PotionType newType = tDAO.save(t);
		
		//if insert failed....
		if(newType == null) {
			return ResponseEntity.badRequest().build(); //send a bad request status code, and no data
		}
		
		//if insert succeeded...
		return ResponseEntity.accepted().body(newType); //send an accepted status code, and the new Pokemon
		
	}
	@GetMapping
	public ResponseEntity<List<PotionType>> getAllPotionTypes(){
		return ResponseEntity.ok(tDAO.findAll());
	}
}
	
		
		