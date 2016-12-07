package com.mercury.code;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOuter {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test01() {
		Outer.A a = new Outer.A();
		assertEquals("foo in A", a.foo());		
	}
	@Test
	public void test02(){
		Outer outer = new Outer();
		Outer.B b = outer.new B(); //?
		assertEquals("foo in B", b.foo());
		assertEquals(10, b.getX());
	}
	
	@Test
	public void test03(){
		Outer outer = new Outer();
		assertEquals("Local", outer.hello());
		assertEquals("c", outer.c.toString());
		assertEquals("obj", outer.obj.toString());
		System.out.println(outer.c.getClass().getName()); // anonymous no name
		System.out.println(outer.obj.getClass().getName());
	}
	
	@Test
	public void test4(){
		Outer outer = new Outer();
		Foo foo = new Foo(outer);
		assertEquals("foo in B", foo.foo());
		assertEquals(10, foo.getX()); //?
	}
	
	

}
