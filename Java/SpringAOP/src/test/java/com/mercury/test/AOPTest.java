package com.mercury.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.TimeBookInterface;

public class AOPTest {
	public static void main(String[] args){		
		ApplicationContext context = new ClassPathXmlApplicationContext("aopconfig.xml");
		TimeBookInterface tb = (TimeBookInterface)context.getBean("logProxy");
		tb.doAudit("Alice");
		tb.doBreak("Bob");
		// (local) inner class with $ sign
		System.out.println(tb.getClass().getName());
	}
}
