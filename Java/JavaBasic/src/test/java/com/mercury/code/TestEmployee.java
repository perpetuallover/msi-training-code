package com.mercury.code;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEmployee {
	private Employee emp;
	@Before
	public void setUp() throws Exception {
		emp = new Employee("Alice");
	}

	//@Test(expected = CloneNotSupportedException.class)
	@Test
	public void test() throws CloneNotSupportedException{
		Employee emp2 = emp.clone();
		assertEquals(emp.getName(), emp2.getName());
		assertSame(emp.getName(), emp2.getName());
		assertNotSame(emp, emp2);
	}

}
