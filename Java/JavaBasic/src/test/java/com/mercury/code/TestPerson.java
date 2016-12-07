package com.mercury.code;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPerson {
	private Person person;

	@Before // run 2 times
	public void setUp() throws Exception {
		person = new Person("Alice");
		System.out.println("Create an instance of Person");
	}

	@Test
	public void testGetName() {
		//fail("Not yet implemented");
		assertEquals("Alice", person.getName());
	}
	@Test
	public void testAddPrefix(){
		Person person2 = person.addProfix("Ms");
		assertEquals("Ms Alice", person2.getName());
		assertNotSame(person, person2);
	}

}
