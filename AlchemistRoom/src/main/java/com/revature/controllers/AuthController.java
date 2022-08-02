package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {
	
	AuthService as = new AuthService();
	
	public static HttpSession sess;
	
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		
		User user = as.login(lDTO.getUsername(), lDTO.getPassword());
		
		if(user != null) {
			sess = ctx.req.getSession();
			
			String userJson = gson.toJson(user);
			
			ctx.result(userJson);
			ctx.status(202);
		}else {
			ctx.status(401);
		}
		
	};

}
