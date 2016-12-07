package com.mercury.thread;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWaitNotify {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Add a = new Add(5, 2);
		Multiply m = new Multiply(5, 2);
		new Thread(a).start();
		new Thread(m).start();
		//synchronized
		double r = (a.getResult() + 0.0) / m.getResult(); //just 1 is wait main is block 2 cant wait at same time
		assertEquals(0.7, r, 0.0001);
	}

}
