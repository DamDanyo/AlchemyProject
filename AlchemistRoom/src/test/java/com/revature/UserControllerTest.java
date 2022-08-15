package com.revature;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.RegisterExtension;

import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.revature.controllers.UserController;
import com.revature.daos.UserDAO;
import com.revature.models.AlchemistUser;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;



	public class UserControllerTest{
	
	private UserDAO uDAO;
	
	
	@Autowired
	public UserControllerTest(UserDAO uDAO) {
		super();
		this.uDAO = uDAO;
	}
	
	
	
	
	//@SuppressWarnings("unchecked")
	//@Test
	//public void testGetUserGetsCalled() throws ParameterResolutionException{
		//UserController mockController = Mockito.spy(new UserController(uDAO));
		
		//OngoingStubbing<OngoingStubbing<AlchemistUser>> u = Mockito.when(((OngoingStubbing<AlchemistUser>) mockController.findById((anyInt()))).thenReturn(new AlchemistUser("test","test",false)));
		
		//assertNotNull(u);
	//}


	
	
	@Test
	void testInsertUser() throws ParameterResolutionException {
		
		AlchemistUser mockUser = Mockito.spy(new AlchemistUser("testets","testpass",false));
		UserController mockController = Mockito.spy(new UserController(uDAO));
		
		@SuppressWarnings("unchecked")
		List<AlchemistUser> mockList = Mockito.mock(ArrayList.class);
		
		mockList = mockController.getAllUsers();
		Mockito.verify(mockController).getAllUsers();
		
		int preInsert = ((List<AlchemistUser>) mockList).size();
		
		mockController.addUser(mockUser);
		Mockito.verify(mockController).addUser(mockUser);
		
		mockList = mockController.getAllUsers();
		
		int postInsert = ((List<AlchemistUser>) mockList).size();
		
		assertTrue(preInsert<postInsert);
	}

	
	
}
