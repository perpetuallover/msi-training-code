package com.mercury.code;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMySingle {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		MySingle ms1 = MySingle.getIntance();
		MySingle ms2 = MySingle.getIntance();
		assertSame(ms1, ms2);
	}

}
