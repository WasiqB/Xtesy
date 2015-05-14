package com.wizonsoft.xtesy.core.internals.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.core.data.IDataSet;
import com.wizonsoft.xtesy.core.data.IDataTable;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 7:20:55 pm
 */
public class ResultSetHelper {
	private static Logger	log;
	private final IDataSet	ds;

	static {
		log = LogManager.getLogger (ResultSetHelper.class);
	}

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @since 18-Jan-2015 7:20:55 pm
	 */
	public ResultSetHelper () {
		log.entry ();
		this.ds = new DataSet ();
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 2:05:14 pm
	 * @param rs
	 * @throws SQLException
	 */
	public void addResultSet (final ResultSet rs) throws SQLException {
		log.entry ();
		this.ds.addTable (new DataTable (rs));
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @since 10-Feb-2015 9:14:05 pm
	 * @return
	 */
	public IDataSet getDataSet () {
		log.entry ();
		return log.exit (this.ds);
	}

	/**
	 * @author Wasiq B
	 * @param tableName
	 * @since 24-Jan-2015 1:48:05 pm
	 * @return the table
	 * @throws SQLException
	 */
	public IDataTable getTable (final String tableName) throws SQLException {
		log.entry ();
		return log.exit (this.ds.getTable (tableName));
	}
}