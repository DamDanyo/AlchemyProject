package com.revature;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.ResponseEntity;

import com.revature.controllers.UserController;
import com.revature.daos.UserDAO;
import com.revature.models.AlchemistUser;

public class UserControllerTest {
	
	private UserDAO uDAO;
	
	
	public UserControllerTest(UserDAO uDAO) {
		super();
		this.uDAO = uDAO;
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetUserGetsCalled() {
		UserController mockController = Mockito.spy(new UserController(uDAO));
		
		OngoingStubbing<OngoingStubbing<AlchemistUser>> u = Mockito.when(((OngoingStubbing<AlchemistUser>) mockController.findById((anyInt()))).thenReturn(new AlchemistUser("test","test",false)));
		
		assertNotNull(u);
	}


	@SuppressWarnings("unchecked")
	@Test
	public void testInsertUser(TestInfo test) throws ParameterResolutionException {
		
		AlchemistUser mockUser = Mockito.spy(new AlchemistUser("testUsertest","testPassword",false));
		UserController mockController = Mockito.spy(new UserController(uDAO));
		
		ResponseEntity<List<AlchemistUser>> mockList = Mockito.mock(ResponseEntity.class);
		
		mockList = mockController.getAllUsers();
		Mockito.verify(mockController).getAllUsers();
		
		int preInsert = ((List<AlchemistUser>) mockList).size();
		
		mockController.addUser(mockUser);
		Mockito.verify(mockController).addUser(mockUser);
		
		mockList = mockController.getAllUsers();
		
		int postInsert = ((List<AlchemistUser>) mockList).size();
		
		assertTrue(preInsert < postInsert);
		
	}
	
}
