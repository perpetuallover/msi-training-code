package com.mercury.service;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.dao.HelloDao;
import com.mercury.impl.HelloDaoimpl01;
import com.mercury.impl.HelloDaoimpl02;

public class HelloService {
	private HelloDao hd;
	public HelloService(){
		if(hd == null){
			hd = new HelloDaoimpl02();
		}
		System.out.println("Create an instance of HelloService");
	}
	public String sayHello1(User user){
//		String hello;
//		hello = "<h2 style = 'color: blue'>" + "Hello " + user.getName() + ", your age is " + user.getAge() + "</h2>";
//		return hello;
		StringBuffer sb = new StringBuffer();
		sb.append("<h2 style = 'color: blue'>");
		sb.append("Hello " + user.getName() + ", your age is " + user.getAge());
		sb.append("</h2>");
		return sb.toString();
	}
	
	public String sayHello2(User user){
		return "Hello " + user.getName() + "(" + user.getAge() + "), welcome to JSP!";
	}
	
	public UserInfo process(User user){
		hd.save(user);
		UserInfo info = new UserInfo();
		info.setMsg(this.sayHello2(user));
		info.setUser(hd.queryAll());
		return info;
	}
}
