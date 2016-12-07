package com.mercury.thread;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWait {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalMonitorStateException.class)
	public void test01() throws Exception {
		wait();
	}
	@Test(expected = IllegalMonitorStateException.class)
	public void test02() throws Exception {
		notifyAll();
	}
	@Test(expected = IllegalMonitorStateException.class)
	public void test03() throws Exception {
		notify();
	}

}
