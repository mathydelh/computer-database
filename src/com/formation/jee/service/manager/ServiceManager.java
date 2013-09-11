package com.formation.jee.service.manager;

import com.formation.jee.service.UserService;
import com.formation.jee.service.impl.UserServiceImpl;

public enum ServiceManager {
	INSTANCE;
	
	private UserService userService;
	
	private ServiceManager(){
		userService=new UserServiceImpl();
	}
	
	public UserService getUserService(){
		return userService;
	}
}
