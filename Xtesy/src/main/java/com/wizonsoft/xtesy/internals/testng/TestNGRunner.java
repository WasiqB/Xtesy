package com.wizonsoft.xtesy.internals.testng;

import org.testng.TestNG;

/**
 * @author Wasiq B
 * @since 25-Dec-2014 2:33:13 pm
 */
public class TestNGRunner {
	private final TestNG	testNg;

	public TestNGRunner () {
		this.testNg = new TestNG (false);
		this.testNg.run ();
	}
}