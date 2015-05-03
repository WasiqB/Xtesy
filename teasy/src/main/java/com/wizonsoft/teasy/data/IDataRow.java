package com.wizonsoft.teasy.data;

/**
 * @author Wasiq B
 * @since 17-Jan-2015 7:52:50 pm
 */
public interface IDataRow {
	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 1:42:33 pm
	 * @param column
	 */
	void addColumn (final IDataColumn column);

	/**
	 * @author Wasiq B
	 * @since 25-Jan-2015 2:10:37 pm
	 */
	void clear ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 7:55:26 pm
	 * @param variableIndex
	 * @return
	 */
	IDataColumn getColumn (int variableIndex);

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 7:56:04 pm
	 * @param variableName
	 * @return
	 */
	IDataColumn getColumn (String variableName);

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 7:58:12 pm
	 * @return
	 */
	int getColumnCount ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:08:29 pm
	 * @param variableName
	 * @return
	 */
	int getColumnIndex (String variableName);

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:08:50 pm
	 * @return
	 */
	IDataColumn [] getColumns ();
}