package com.wizonsoft.teasy.internals.testng;

/**
 * @author Wasiq B
 * @since 23-Nov-2014 8:33:12 pm
 */
public enum SuiteConstants {
	SUITE_NAME ("suiteName"),
	SUITE_PARAMS ("suiteParams");

	private final String	name;

	private SuiteConstants (final String name) {
		this.name = name;
	}

	/**
	 * @author Wasiq B
	 * @since 23-Nov-2014 8:38:29 pm
	 * @return the name
	 */
	public String getName () {
		return this.name;
	}
}