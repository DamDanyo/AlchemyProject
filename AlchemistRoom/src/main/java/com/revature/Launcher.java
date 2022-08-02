package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("connection passed");
			
		}catch (SQLException e) {
			System.out.println("Connection failed :(");
			e.printStackTrace();
		}

	}

}
