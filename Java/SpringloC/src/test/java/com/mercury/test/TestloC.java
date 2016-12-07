package com.mercury.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mercury.beans.Address;
import com.mercury.beans.Employee;
import com.mercury.beans.Person;
import com.mercury.beans.User;
import com.mercury.beans.Wrapper;

public class TestloC {
	private ApplicationContext context;
	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext("resource/iocconfig.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test01() {
		User user = (User)context.getBean("user");
		assertEquals("Alice", user.getName());
		assertEquals("female", user.getSex());
		assertEquals(35, user.getAge());
		User user2 = (User)context.getBean("user");
		//assertSame(user, user2);
		assertNotSame(user, user2);
		assertSame(user.getName(), user2.getName());
	}
	@Test
	public void test02(){
		Person person = (Person)context.getBean("person");
		assertEquals("Bruce", person.getFirstName());
		assertEquals("Lee", person.getLastName());
	}
	@Test
	public void test03(){
		Wrapper wp = (Wrapper)context.getBean("wp");
		User user = wp.getUser();
		assertEquals("Alice", user.getName());
		assertEquals("female", user.getSex());
		assertEquals(35, user.getAge());
		Person person = wp.getP();
		assertEquals("Bruce", person.getFirstName());
		assertEquals("Lee", person.getLastName());
		User user2= (User)context.getBean("user");
		assertNotSame(user, user2);
		Person person2 = (Person)context.getBean("person");
		assertSame(person, person2);
	}
	@Test
	public void test04(){
		Wrapper wp2 = (Wrapper)context.getBean("wp2");
		assertFalse(wp2.getUser() == null);
		assertTrue(wp2.getP()==null);
		Wrapper wp3 = (Wrapper)context.getBean("wp3");
		assertFalse(wp3.getUser() == null);
		assertFalse(wp3.getP()==null);
	}
	@Test
	public void test05(){
		Employee emp = (Employee)context.getBean("emp");
		assertEquals("Bob", emp.getName());
		Address address = emp.getAddress();
		assertEquals("Princeton", address.getCity());
		assertEquals("NJ", address.getState());
	}

}
