package com.demo.analysis.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Around implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("--------spring proxy log start---------");
		Object ret = invocation.proceed();
		System.out.println("--------spring proxy log end---------");
		return ret;
	}

}
