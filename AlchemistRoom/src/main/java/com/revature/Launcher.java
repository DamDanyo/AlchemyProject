package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		
		AuthController ac = new AuthController();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("connection passed");
			
		}catch (SQLException e) {
			System.out.println("Connection failed :(");
			e.printStackTrace();
		}
		
		
		Javalin app = Javalin.create(
				config->{
					config.enableCorsForAllOrigins();
				}
				).start(3000);
		
		
		
		app.post("/login", ac.loginHandler);

	}

}
