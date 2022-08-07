package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AlchemyApplication{

	public static void main(String[] args) {
		
		SpringApplication.run(AlchemyApplication.class, args);
		
		//HTTP calls===============----------================
		
		//==================================Potions
		//	get all potions: GET localhost:5555/data/potion/all
		//	get potion by id: GET localhost:5555/data/potion/byId/{id}
		//	insert potion: POST localhost:5555/data/potion   
		//	delete potion by id: DEL localhost:5555/data/potion/delete/{id}  
		//	delete potion(potion in request body): DEL localhost:5555/data/potion
		//Note: Remember to include json data in the body of the Post request
		//	update potion: POST localhost:5555/data/potion/update
	
		
		
		//Backend api requests
		//	update database with api potions: GET localhost:555/data/potion/api/update
		//	get Potion from api by id: GET localhost:5555/data/potion/api/{id}
		//	get all potions from api: GET localhost:5555/data/potion/api/all
		
	}

}
