package com.wizonsoft.teasy.internals.data;

import java.sql.*;

import com.wizonsoft.teasy.data.*;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 7:20:55 pm
 */
public class ResultSetHelper {
	private final IDataSet	ds;

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @since 18-Jan-2015 7:20:55 pm
	 */
	public ResultSetHelper () {
		this.ds = new DataSet ();
	}

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 2:05:14 pm
	 * @param rs
	 * @throws SQLException
	 */
	public void addResultSet (final ResultSet rs) throws SQLException {
		this.ds.addTable (new DataTable (rs));
	}

	/**
	 * @author Wasiq B
	 * @since 10-Feb-2015 9:14:05 pm
	 * @return
	 */
	public IDataSet getDataSet () {
		return this.ds;
	}

	/**
	 * @author Wasiq B
	 * @param tableName
	 * @since 24-Jan-2015 1:48:05 pm
	 * @return the table
	 * @throws SQLException
	 */
	public IDataTable getTable (final String tableName) throws SQLException {
		return this.ds.getTable (tableName);
	}
}