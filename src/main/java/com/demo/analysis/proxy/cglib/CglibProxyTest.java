package com.demo.analysis.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyTest {

	public static void main(String[] args) {
		UserService userService = new UserService();
		
		Enhancer enhancer= new Enhancer();
		
		//为UserService(UserService未实现任何接口)生成代理类
		enhancer.setClassLoader(CglibProxyTest.class.getClassLoader());
		enhancer.setSuperclass(UserService.class);
		
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				System.out.println("--------proxy log begin---------");
				Object ret = method.invoke(userService, args);
				System.out.println("--------proxy log end---------");
				return ret;
			}
		});
		
		
		UserService userServicePorxy=(UserService) enhancer.create();
		userServicePorxy.login();
	}

}
