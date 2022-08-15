package com.revature;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import com.revature.daos.UserDAO;


public class UserControllerParameterResolver implements ParameterResolver {
	
private UserDAO uDAO;
	
	
	
	public UserControllerParameterResolver(UserDAO uDAO) {
		super();
		this.uDAO = uDAO;
	}

	
	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return parameterContext.getParameter().getType() == UserControllerTest.class;
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return new UserControllerTest(uDAO);
	}

}
