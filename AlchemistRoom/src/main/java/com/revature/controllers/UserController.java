package com.revature.controllers;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
		
	//This method will be used to login a user.
	//path is: POST - http://localhost:5555/data/user/login
	@PostMapping(value="/login")
	public ResponseEntity<AlchemistUser> login(@RequestBody LoginDTO lDTO, HttpServletResponse response) {
		
		
		
		
		System.out.println(lDTO.getUsername() + " " + lDTO.getPassword());
		
		Optional<AlchemistUser> user = uDAO.findByUsernameAndPassword(lDTO.getUsername(), lDTO.getPassword());
		
		System.out.println(user);
		
		if(user.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		}
		AlchemistUser u = user.get();
		Cookie cookie = new Cookie("userid", Integer.toString(u.getUserid()));
		cookie.setPath("/");
		cookie.setHttpOnly(false);
		response.addCookie(cookie);
//		Cookie cookie = new Cookie("whatevererere", Integer.toString(u.getUserid()));
//		cookie.setPath("/");
//		cookie.setHttpOnly(false);
//		response.addCookie(cookie);
		return ResponseEntity.accepted().body(u);
		
		
	}
	
	//This method will be used to add a new user. isadmin will have to be set to null on Angular side w/ JSON object
	//path is: POST - http://localhost:5555/data/user
	@PostMapping
	public ResponseEntity addUser(@RequestBody AlchemistUser user) {
		
		AlchemistUser newUser = uDAO.save(user);
		
		if(newUser == null ) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body(newUser);
	}
	
	//this method will be used to find a user by ID
	//path is GET - http://localhost:5555/data/user/byId/{id}
	@GetMapping(value =("/byId/{id}"))
	public ResponseEntity<AlchemistUser> findById(@PathVariable int id){
		
		Optional<AlchemistUser> userOptional = uDAO.findById(id);
		
		if(userOptional.isPresent()) {
			AlchemistUser user = userOptional.get();
			return ResponseEntity.ok(user);
		}
		
		return ResponseEntity.noContent().build();
		
	}
	
	//this method will be used to delete a user by their id in the path
	//path is DELETE - http://localhost:5555/data/user/deleteById/{id}
	@DeleteMapping(value=("deleteById/{id}"))
	public ResponseEntity<?> deleteById(@PathVariable int id){
		
		try{uDAO.deleteById(id);
		
		return new ResponseEntity<String>("User deleted: ", HttpStatus.OK);
		} catch(EmptyResultDataAccessException e) {
			return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
		}
		
	}
	
	//this method will be used to update user username and password
	//path is POST - http://localhost:5555/data/user/{id}/updateUser
	@PostMapping(value=("{id}/updateUser"))
	public ResponseEntity<AlchemistUser> updateUser(@PathVariable int id, @RequestBody AlchemistUser userDetails){
		Optional<AlchemistUser> userOptional = uDAO.findById(id);
		if(userOptional.isPresent()) {
			AlchemistUser user = userOptional.get();
			user.setUsername(userDetails.getUsername());
			user.setPassword(userDetails.getPassword());
			return ResponseEntity.ok(uDAO.save(user));
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	

}