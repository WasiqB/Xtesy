package com.wizonsoft.xtesy.internals.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.data.IDataColumn;
import com.wizonsoft.xtesy.data.IDataRow;
import com.wizonsoft.xtesy.data.IDataRowIterator;
import com.wizonsoft.xtesy.data.IDataTable;
import com.wizonsoft.xtesy.data.IDataVariable;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 7:36:33 pm
 */
public class DataTable implements IDataTable {
	private static Logger	log;
	private IDataRow []		rows;
	private final ResultSet	rs;

	static {
		log = LogManager.getLogger (DataTable.class);
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 7:39:49 pm
	 * @param tableName
	 * @throws SQLException
	 */
	public DataTable (final ResultSet rs) throws SQLException {
		log.entry ();
		this.rs = rs;
		loadRows ();
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @since 18-Jan-2015 7:58:35 pm
	 */
	private void loadRows () throws SQLException {
		log.entry ();
		int index = 0;
		while (!this.rs.next ()) {
			final IDataRow row = new DataRow ();
			final ResultSetMetaData rsmd = this.rs.getMetaData ();
			for (int col = 1; col <= rsmd.getColumnCount (); col++) {
				final IDataVariable var = new DataVariable (rsmd.getColumnName (col), col);
				final IDataColumn column = new DataColumn <> (var, this.rs.getObject (col));
				row.addColumn (column);
			}
			this.rows [index++] = row;
		}
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTable#getRow(int)
	 */
	@Override
	public IDataRow getRow (final int rowNumber) {
		log.entry ();
		if (rowNumber < 1) return null;
		return log.exit (this.rows [rowNumber - 1]);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTable#getRowCount()
	 */
	@Override
	public int getRowCount () {
		log.entry ();
		return log.exit (this.rows.length);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTable#getRowIterator()
	 */
	@Override
	public IDataRowIterator getRowIterator () {
		log.entry ();
		return log.exit (new DataRowIterator (this.rows));
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableMetaData#getTableName()
	 */
	@Override
	public String getTableName () throws SQLException {
		log.entry ();
		return log.exit (this.rs.getMetaData ().getTableName (1));
	}
}