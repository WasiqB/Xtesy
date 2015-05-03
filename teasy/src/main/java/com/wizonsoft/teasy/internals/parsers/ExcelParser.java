package com.wizonsoft.teasy.internals.parsers;

import java.util.*;

import org.testng.xml.XmlSuite;

import com.wizonsoft.teasy.internals.testng.TestCaseConstants;

/**
 * @author Wasiq B
 * @since 19-Nov-2014 10:03:08 pm
 */
public class ExcelParser implements IExcelFileParser {
	private Map <TestCaseConstants, int []>	parserMap;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.wizonsoft.teasy.internals.parsers.IFileParser#getXmlSuites(java.lang
	 * .String, boolean)
	 */
	public List <XmlSuite> getXmlSuites (final String filePath, final boolean loadClasses) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.wizonsoft.teasy.internals.parsers.IExcelFileParser#setParserMap(java
	 * .util.Map)
	 */
	public void setParserMap (final Map <String, Map <TestCaseConstants, int []>> parserMap) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.wizonsoft.teasy.internals.parsers.IExcelFileParser#setSuiteSheetName
	 * (java.lang.String)
	 */
	public void setSuiteSheetName (final String sheetName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.wizonsoft.teasy.internals.parsers.IExcelFileParser#setTestClassSheetName
	 * (java.lang.String)
	 */
	public void setTestClassSheetName (final String sheetName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.wizonsoft.teasy.internals.parsers.IExcelFileParser#setTestSheetName
	 * (java.lang.String)
	 */
	public void setTestSheetName (final String sheetName) {
		// TODO Auto-generated method stub

	}
}