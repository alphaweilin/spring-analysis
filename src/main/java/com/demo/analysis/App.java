package com.demo.analysis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.analysis.controller.UserController;
import com.demo.analysis.service.UserService;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		beanFactoryTest(ac);
	}
	
	public static void beanFactoryTest(ApplicationContext ac) {
//		System.out.println(ac.getBean("serviceBean"));
		UserService serviceBean = (UserService) ac.getBean("userService");
		serviceBean.login();
	}
	
	public static void iocTest(ApplicationContext ac) {
		UserController controllerBean = (UserController) ac.getBean("userController");
		controllerBean.login();
	}
	
	public static void aopTest(ApplicationContext ac) {
		UserService serviceBean = (UserService) ac.getBean("userService");
		serviceBean.login();
		serviceBean.register();
	}
}
