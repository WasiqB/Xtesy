package com.wizonsoft.xtesy.internals.parsers;

import java.util.List;

import org.testng.xml.XmlSuite;

/**
 * @author Wasiq B
 * @since 23-Nov-2014 9:13:26 pm
 */
public interface IFileParser {
	/**
	 * @author Wasiq B
	 * @since 19-Nov-2014 10:04:45 pm
	 * @param filePath
	 * @param loadClasses
	 * @return
	 */
	List <XmlSuite> getXmlSuites (String filePath, boolean loadClasses);
}