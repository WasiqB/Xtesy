package com.wizonsoft.xtesy.internals.parsers;

import java.util.Map;

import com.wizonsoft.xtesy.core.internals.testng.TestCaseConstants;

/**
 * @author Wasiq B
 * @since 19-Nov-2014 10:03:37 pm
 */
public interface IExcelFileParser extends IFileParser {
	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 9:39:18 pm
	 * @param parserMap
	 */
	void setParserMap (final Map <String, Map <TestCaseConstants, int []>> parserMap);

	/**
	 * @author Wasiq B
	 * @since 21-Dec-2014 2:06:36 pm
	 * @param sheetName
	 */
	void setSuiteSheetName (final String sheetName);

	/**
	 * @author Wasiq B
	 * @since 21-Dec-2014 2:07:23 pm
	 * @param sheetName
	 */
	void setTestClassSheetName (String sheetName);

	/**
	 * @author Wasiq B
	 * @since 21-Dec-2014 2:06:57 pm
	 * @param sheetName
	 */
	void setTestSheetName (String sheetName);
}