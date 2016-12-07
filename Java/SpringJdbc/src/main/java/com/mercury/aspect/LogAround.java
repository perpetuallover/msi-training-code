package com.mercury.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		String name = (String)mi.getArguments()[0];
		System.out.println(name + " around before...");
		Object obj = mi.proceed();
		System.out.println(name + " around after...");
		return obj;
	}
}
