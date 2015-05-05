package com.wizonsoft.xtesy.internals.testng;

/**
 * @author Wasiq B
 * @since 20-Nov-2014 9:39:49 pm
 */
public enum TestCaseConstants {
	TEST_CLASS ("testClass"),
	TEST_DESCRIPTION ("testDescription"),
	TEST_EXECUTE ("testExecute"),
	TEST_ID ("testId"),
	TEST_NAME ("testName"),
	TEST_PARAMS ("testParams"),
	TEST_RUN_FROM ("testRunFrom"),
	TEST_RUN_TO ("testRunTo");

	private final String	column;

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 9:48:43 pm
	 * @param column
	 */
	private TestCaseConstants (final String column) {
		this.column = column;
	}

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 9:42:25 pm
	 * @return the column
	 */
	public String getName () {
		return this.column;
	}
}