package com.demo.analysis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.analysis.controller.UserController;
import com.demo.analysis.service.UserService;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		System.out.println(ac.getBean("serviceBean"));
		UserService serviceBean = (UserService) ac.getBean("userService");
		serviceBean.login();
		serviceBean.register();
		
//		UserController controllerBean = (UserController) ac.getBean("userController");
//		controllerBean.login();
	}
}
