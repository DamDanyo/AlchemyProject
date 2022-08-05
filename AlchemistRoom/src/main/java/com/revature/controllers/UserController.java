package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.UserDAO;
import com.revature.models.AlchemistUser;
import com.revature.models.LoginDTO;


@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	private UserDAO uDAO;
	
	

	@Autowired
	public UserController(UserDAO uDAO) {
		super();
		this.uDAO = uDAO;
	}
	
	
		
	@PostMapping(value="/login")
	public ResponseEntity<AlchemistUser> login(@RequestBody LoginDTO lDTO) {
		
		
		
		
		System.out.println(lDTO.getUsername() + " " + lDTO.getPassword());
		
		Optional<AlchemistUser> user = uDAO.findByUsernameAndPassword(lDTO.getUsername(), lDTO.getPassword());
		
		System.out.println(user);
		
		if(user.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		}
		AlchemistUser u = user.get();
		return ResponseEntity.accepted().body(u);
		
		
	}
	

}