package com.mercury.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;

public class Test03 {
	public static void showUsers(List<User> users){
		for(User user:users){
			System.out.println(user);
		}
	}
	public static void main(String[] args){
		try(ClassPathXmlApplicationContext actx = new ClassPathXmlApplicationContext("config.xml")){
			HelloDao hd = (HelloDao)actx.getBean("hdb03");
			//Save a user
			User user = new User("David", 78);
			hd.save(user);
			System.out.println("User is saved");
			//Show all user
			showUsers(hd.query());
			//Update the user
			user.setAge(72);
			hd.update(user);
			System.out.println("User is updated");
			showUsers(hd.query());
			//Delete the user
			hd.delete(user);
			System.out.println("User is deleted");
			showUsers(hd.query());
		}catch(Exception e){
			System.err.println(e);
		}
	}
}
