package com.wizonsoft.teasy.internals.testng;

import java.util.Map;

import org.testng.xml.XmlClass;

/**
 * @author Wasiq B
 * @since 13-Dec-2014 12:29:43 pm
 */
public class TestClass {
	private final String			className;
	private Map <String, String>	parameters;

	/**
	 * @author Wasiq B
	 * @since 14-Dec-2014 8:50:29 pm
	 * @param className
	 */
	public TestClass (final String className) {
		this.className = className;
	}

	/**
	 * @author Wasiq B
	 * @since 14-Dec-2014 8:48:22 pm
	 * @param loadClasses
	 * @return
	 */
	public XmlClass getXmlClass (final boolean loadClasses) {
		final XmlClass cls = new XmlClass (this.className, loadClasses);
		if (this.parameters != null) {
			cls.setParameters (this.parameters);
		}
		cls.setName (this.className);
		return cls;
	}

	/**
	 * @author Wasiq B
	 * @since 14-Dec-2014 8:51:56 pm
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters (final Map <String, String> parameters) {
		this.parameters = parameters;
	}
}