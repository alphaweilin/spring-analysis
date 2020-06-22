package com.demo.analysis.factory;

import com.demo.analysis.service.UserService;

public class Test {

	public static void main(String[] args) {
		UserService userService = (UserService) BeanFactory.getBean("userService");
		userService.login();
	}

}
