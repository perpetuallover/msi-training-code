package com.mercury.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

import com.mercury.beans.User;

public class LogAdvice {
	@Around("execution(* com.mercury.dao.impl.HelloDaoBean01.save(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
		User user = (User)pjp.getArgs()[0];
		System.out.println("Start saving " + user.getName());
		Object obj = pjp.proceed();
		System.out.println("End saving " + user.getName());
		return obj;
	}
	
}
