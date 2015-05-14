package com.wizonsoft.xtesy.data;

/**
 * @author Wasiq B
 * @since 17-Jan-2015 9:12:08 pm
 */
public interface IDataRowIterator {
	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 9:13:47 pm
	 * @return
	 */
	IDataRow current ();

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 1:38:20 pm
	 * @param variableIndex
	 * @return
	 */
	<T> T getValue (int variableIndex);

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 1:41:17 pm
	 * @param variableName
	 * @return
	 */
	<T> T getValue (String variableName);

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 9:14:26 pm
	 * @return
	 */
	boolean hasNext ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 9:14:07 pm
	 */
	void next ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 9:13:58 pm
	 */
	void reset ();
}