package com.wizonsoft.xtesy.core.internals.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.core.data.IDataColumn;
import com.wizonsoft.xtesy.core.data.IDataRow;
import com.wizonsoft.xtesy.core.data.IDataRowIterator;
import com.wizonsoft.xtesy.core.data.IDataTable;
import com.wizonsoft.xtesy.core.data.IDataTableExt;
import com.wizonsoft.xtesy.core.data.IDataVariable;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 7:36:33 pm
 */
public class DataTable implements IDataTable, IDataTableExt {
	private static Logger	log;
	private List <IDataRow>	rows;
	private ResultSet		rs;

	static {
		log = LogManager.getLogger (DataTable.class);
	}

	/**
	 * @author Wasiq B
	 * @since 12-May-2015 10:21:38 am
	 */
	public DataTable () {
		log.entry ();
		this.rows = new ArrayList <IDataRow> ();
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 7:39:49 pm
	 * @param tableName
	 * @throws SQLException
	 */
	public DataTable (final ResultSet rs) throws SQLException {
		this ();
		log.entry ();
		this.rs = rs;
		loadRows ();
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.wizonsoft.xtesy.core.data.IDataTableExt#addRow(com.wizonsoft.xtesy
	 * .core.data.IDataRow)
	 */
	@Override
	public void addRow (IDataRow row) {
		this.rows.add (row);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTable#getRow(int)
	 */
	@Override
	public IDataRow getRow (final int rowNumber) {
		log.entry ();
		if (rowNumber < 1)
			return null;
		return log.exit (this.rows.get (rowNumber - 1));
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTable#getRowCount()
	 */
	@Override
	public int getRowCount () {
		log.entry ();
		return log.exit (this.rows.size ());
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTable#getRowIterator()
	 */
	@Override
	public IDataRowIterator getRowIterator () {
		log.entry ();
		IDataRow [] rowArray = new IDataRow [getRowCount ()];
		this.rows.toArray (rowArray);
		return log.exit (new DataRowIterator (rowArray));
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

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @since 18-Jan-2015 7:58:35 pm
	 */
	private void loadRows () throws SQLException {
		log.entry ();
		while (!this.rs.next ()) {
			final IDataRow row = new DataRow ();
			final ResultSetMetaData rsmd = this.rs.getMetaData ();
			for (int col = 1; col <= rsmd.getColumnCount (); col++) {
				final IDataVariable var = new DataVariable (rsmd.getColumnName (col), col);
				final IDataColumn column = new DataColumn <> (var, this.rs.getObject (col));
				row.addColumn (column);
			}
			addRow (row);
		}
		log.exit ();
	}
}