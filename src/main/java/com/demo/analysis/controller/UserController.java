package com.demo.analysis.controller;

import com.demo.analysis.service.UserService;

public class UserController {
	private UserService userService;
	
	public void login() {
		userService.login();
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
