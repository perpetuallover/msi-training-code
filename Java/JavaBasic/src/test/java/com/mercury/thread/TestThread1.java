package com.mercury.thread;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestThread1 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalThreadStateException.class)
	public void test() {
		Thread t = new Thread1("thread1");
		t.start();
		t.start();
	}

}
