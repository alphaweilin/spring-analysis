package com.demo.analysis.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.demo.analysis.service.UserService;
import com.demo.analysis.service.UserServiceImpl;

public class JDKProxyTest {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		InvocationHandler handler = new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("--------proxy log start---------");
				Object ret = method.invoke(userService, args);
				System.out.println("--------proxy log end---------");
				return ret;
			}
		};
		

		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(),
				userService.getClass().getInterfaces(), handler);

		userServiceProxy.login();

	}

}
