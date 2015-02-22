package com.wizonsoft.teasy.internals.data;

import java.sql.*;

import com.wizonsoft.teasy.data.*;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 7:36:33 pm
 */
public class DataTable implements IDataTable {
	private IDataRow []		rows;
	private final ResultSet	rs;

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 7:39:49 pm
	 * @param tableName
	 * @throws SQLException
	 */
	public DataTable (final ResultSet rs) throws SQLException {
		this.rs = rs;
		loadRows ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTable#getRow(int)
	 */
	@Override
	public IDataRow getRow (final int rowNumber) {
		if (rowNumber < 1)
			return null;
		return this.rows [rowNumber - 1];
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTable#getRowCount()
	 */
	@Override
	public int getRowCount () {
		return this.rows.length;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTable#getRowIterator()
	 */
	@Override
	public IDataRowIterator getRowIterator () {
		return new DataRowIterator (this.rows);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableMetaData#getTableName()
	 */
	@Override
	public String getTableName () throws SQLException {
		return this.rs.getMetaData ().getTableName (1);
	}

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @since 18-Jan-2015 7:58:35 pm
	 */
	private void loadRows () throws SQLException {
		int index = 0;
		while (!this.rs.next ()) {
			final IDataRow row = new DataRow ();
			final ResultSetMetaData rsmd = this.rs.getMetaData ();
			for (int col = 1; col <= rsmd.getColumnCount (); col++) {
				final IDataVariable var = new DataVariable (
						rsmd.getColumnName (col), col);
				final IDataColumn column = new DataColumn <> (var,
						this.rs.getObject (col));
				row.addColumn (column);
			}
			this.rows [index++] = row;
		}
	}
}