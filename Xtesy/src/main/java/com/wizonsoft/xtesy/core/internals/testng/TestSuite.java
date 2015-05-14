package com.wizonsoft.xtesy.core.internals.testng;

import java.util.*;

import org.testng.xml.*;

/**
 * @author Wasiq B
 * @since 22-Nov-2014 8:30:23 pm
 */
public class TestSuite {
	private final String			name;
	private Map <String, String>	params;
	private List <TestCase>			testCases;

	/**
	 * @author Wasiq B
	 * @since 22-Nov-2014 8:32:11 pm
	 * @param name
	 */
	public TestSuite (final String name) {
		this.name = name;
		this.testCases = new ArrayList <TestCase> ();
		this.params = new HashMap <String, String> ();
	}

	/**
	 * @author Wasiq B
	 * @since 22-Nov-2014 8:37:11 pm
	 * @param name
	 * @param testCases
	 */
	public TestSuite (final String name, final List <TestCase> testCases) {
		this (name);
		this.testCases = testCases;
	}

	/**
	 * @author Wasiq B
	 * @since 21-Dec-2014 7:55:28 pm
	 * @param name
	 * @param testCases
	 * @param params
	 */
	public TestSuite (final String name, final List <TestCase> testCases,
			final Map <String, String> params) {
		this (name, testCases);
		this.params = params;
	}

	/**
	 * @author Wasiq B
	 * @since 21-Dec-2014 7:56:45 pm
	 * @param testCase
	 */
	public void addTestCase (final TestCase testCase) {
		if (!this.testCases.contains (testCase)) {
			this.testCases.add (testCase);
		}
	}

	/**
	 * @author Wasiq B
	 * @since 22-Nov-2014 8:40:22 pm
	 * @param loadClasses
	 * @return
	 */
	public XmlSuite getXmlSuite (final boolean loadClasses) {
		final XmlSuite suite = new XmlSuite ();
		suite.setName (this.name);
		if (this.params != null && this.params.size () > 0) {
			suite.setParameters (this.params);
		}
		final List <XmlTest> tests = new ArrayList <XmlTest> ();
		for (final TestCase testCase : this.testCases) {
			tests.add (testCase.getXmlTest (suite, loadClasses));
		}
		suite.setTests (tests);
		return suite;
	}

	/**
	 * @author Wasiq B
	 * @since 22-Nov-2014 8:42:22 pm
	 * @param params
	 *            the params to set
	 */
	public void setParams (final Map <String, String> params) {
		this.params = params;
	}

	/**
	 * @author Wasiq B
	 * @since 22-Nov-2014 8:48:52 pm
	 * @param testCases
	 *            the testCases to set
	 */
	public void setTestCases (final List <TestCase> testCases) {
		this.testCases = testCases;
	}
}