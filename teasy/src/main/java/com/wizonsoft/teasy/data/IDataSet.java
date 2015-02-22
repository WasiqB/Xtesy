package com.wizonsoft.teasy.data;

import java.sql.SQLException;

/**
 * @author Wasiq B
 * @since 17-Jan-2015 8:42:17 pm
 */
public interface IDataSet {
	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 1:56:30 pm
	 * @param table
	 */
	void addTable (IDataTable table);

	/**
	 * @author Wasiq B
	 * @since 25-Jan-2015 1:57:34 pm
	 */
	void clear ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:43:09 pm
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	IDataTable getTable (String tableName) throws SQLException;

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 8:01:33 pm
	 * @return
	 */
	IDataTableIterator getTableIterator ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:43:31 pm
	 * @return
	 * @throws SQLException
	 */
	String [] getTableNames () throws SQLException;

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:43:50 pm
	 * @return
	 */
	IDataTable [] getTables ();
}