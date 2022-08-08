package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.PotionDAO;
import com.revature.models.Potion;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value="/potion")
public class PotionController {
	
	private PotionDAO pDAO;
	
	@Autowired
	public PotionController(PotionDAO pDAO) {
		super();
		this.pDAO = pDAO;
	}
	
	//MVC Methods to Handle HTTP Requests==================
	
	
	//Frontend Methods-----------------------------------
	//Get all potions
	@GetMapping(value="all")
	public ResponseEntity<List<Potion>> getAllPotion(){
		return ResponseEntity.ok(pDAO.findAll());
	}
	//Get potion by id
	@GetMapping(value="/byId/{id}")
	public ResponseEntity<Potion> findById(@PathVariable int id){
		
		Optional<Potion> optionalPotion = pDAO.findById(id);
		if (optionalPotion.isPresent()) {
			Potion p = optionalPotion.get();
			return ResponseEntity.ok(p);
		}
		
		return ResponseEntity.noContent().build();
	}
	//Insert potion
	@PostMapping
	public ResponseEntity<Potion> addPotion(@RequestBody Potion p) {
		
		Potion newPotion = pDAO.save(p);
		if(newPotion == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.accepted().body(newPotion);
	}
	
	@PutMapping(value="update")
	public ResponseEntity<Potion> updatePotion(@RequestBody Potion p){
		Optional<Potion> upPotion = pDAO.findById(p.getId());
		if(upPotion.isPresent()){
			Potion updatePotion = pDAO.save(p);		
			return ResponseEntity.accepted().body(updatePotion);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	
	@DeleteMapping(value="delete/{id}")
	public ResponseEntity<Potion> deletePotionById(@PathVariable int id){
		Optional<Potion> delPotion = pDAO.findById(id);
		if (delPotion.isPresent()) {
			pDAO.deleteById(id);
			return ResponseEntity.accepted().body(null);
		}
		return ResponseEntity.badRequest().body(null);

	}
	
	@DeleteMapping
	public ResponseEntity<Potion> deletePotion(@RequestBody Potion p){

		Optional<Potion> delPotion = pDAO.findById(p.getId());
		if (delPotion.isPresent()) {		
			pDAO.delete(p);
			return ResponseEntity.accepted().body(null);
		}
		return ResponseEntity.badRequest().body(null);
	}
	//Backend Methods-----------------------------------------
	
	public RestTemplate rt = new RestTemplate(); //For Handling api
	
	//Get Potion by id from api
	@GetMapping(value="api/{id}")
	public ResponseEntity<Potion> getPotionFromApi(@PathVariable int id){

		String json = rt.getForObject("https://the-harry-potter-database.herokuapp.com/api/1/potions/"+id,String.class);
		//Remove [ ] from string
		String p1 = json.substring(1,json.length()-1);
        try {
        	//Map Json string to Potion
        	ObjectMapper objectMapper = new ObjectMapper();
            Potion p = objectMapper.readValue(p1, Potion.class);
            p.setPotionvalue(10);
            return ResponseEntity.ok(p);
        } catch (final IOException e) {
        	e.printStackTrace();
        }
        return ResponseEntity.badRequest().body(null);

	}
	
	//Get all potions from api
	@GetMapping(value="api/all")
	public ResponseEntity<Potion[]> getAllPotionFromApi(){

		ResponseEntity<Potion[]> response = rt.getForEntity("https://the-harry-potter-database.herokuapp.com/api/1/potions/all",Potion[].class);
		Potion[] potionList = response.getBody();
        return ResponseEntity.ok(potionList);
	}
	
	//update db using getAllPotionsFromApi
	@GetMapping(value="api/update")
	public ResponseEntity<List<Potion>> updatePotionFromApi(){
		
		Potion[] potionApi = getAllPotionFromApi().getBody(); //from api
		List<Potion> potionList = getAllPotion().getBody(); //from our db
		List<Potion> updates = new ArrayList<Potion>();
		for(Potion p:potionApi) {
			if(potionList.contains(p)==false) {

				p.setPotionquantity(0);
				p.setPotionvalue(10);
				if(p.getDescription()=="") {
					p.setDescription("Unknown");
				}
				addPotion(p);
				updates.add(p);
			}
		}

		return ResponseEntity.ok(updates);
		
	}
	
}
