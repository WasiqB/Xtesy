package com.wizonsoft.xtesy.core.internals.testng;

import static com.wizonsoft.xtesy.core.internals.testng.TestCaseConstants.*;
import static com.wizonsoft.xtesy.core.utils.Booleans.toStringFromBoolean;

import java.util.*;

import org.testng.xml.*;

/**
 * @author Wasiq B
 * @since 19-Nov-2014 10:11:56 pm
 */
public class TestCase {
	private boolean				execute;
	private List <TestClass>	testClass;
	private final String		testDescription;
	private final String		testId;
	private final String		testName;

	/**
	 * @author Wasiq B
	 * @since 19-Nov-2014 10:21:02 pm
	 * @param testId
	 * @param name
	 * @param description
	 */
	public TestCase (final String testId, final String name, final String description) {
		this.testId = testId;
		this.testName = name;
		this.testDescription = description;
	}

	/**
	 * @author Wasiq B
	 * @param loadClasses
	 * @since 22-Nov-2014 8:19:56 pm
	 * @return
	 */
	private List <XmlClass> getXmlClass (final boolean loadClasses) {
		final List <XmlClass> classes = new ArrayList <XmlClass> ();
		for (final TestClass xmlClass : this.testClass) {
			classes.add (xmlClass.getXmlClass (loadClasses));
		}
		return classes;
	}

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 10:00:00 pm
	 * @param suite
	 * @param loadClasses
	 * @return
	 */
	public XmlTest getXmlTest (final XmlSuite suite, final boolean loadClasses) {
		final XmlTest test = new XmlTest (suite);
		test.setName (this.testId + "." + this.testName);
		test.addParameter (TEST_DESCRIPTION.getName (), this.testDescription);
		test.addParameter (TEST_EXECUTE.getName (), toStringFromBoolean (this.execute));
		test.setXmlClasses (getXmlClass (loadClasses));
		return test;
	}

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 9:57:51 pm
	 * @param execute
	 *            the execute to set
	 */
	public void setExecute (final boolean execute) {
		this.execute = execute;
	}

	/**
	 * @author Wasiq B
	 * @since 14-Dec-2014 8:49:31 pm
	 * @param testClass
	 *            the testClass to set
	 */
	public void setTestClass (final List <TestClass> testClass) {
		this.testClass = testClass;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return "Test Case [" + this.testId + "] Name = " + this.testName + " Description = "
				+ this.testDescription;
	}
}