package com.mercury.test;








import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.TimeBookInterface;

public class AspectJTest {
	public static void main(String[] args){
		try(ClassPathXmlApplicationContext actx = new ClassPathXmlApplicationContext("aspectjconfig.xml")){
			TimeBookInterface tb = (TimeBookInterface)actx.getBean("timeBook");
			System.out.println(tb.getClass().getName());
			tb.doAudit("Alice");
			tb.doBreak("Bob");
			try{
				tb.doCheck("Steven");
			}catch (Exception e){
				System.out.println(e);
			}
		} catch(Exception e){
			System.err.println(e);
		}
	}
}
