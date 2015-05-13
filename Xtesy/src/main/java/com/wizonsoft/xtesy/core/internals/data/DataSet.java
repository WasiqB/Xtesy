package com.wizonsoft.xtesy.core.internals.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.core.data.IDataSet;
import com.wizonsoft.xtesy.core.data.IDataTable;
import com.wizonsoft.xtesy.core.data.IDataTableIterator;

/**
 * @author Wasiq B
 * @since 24-Jan-2015 1:54:05 pm
 */
public class DataSet implements IDataSet {
	private static Logger			log;
	private final List <IDataTable>	tables;

	static {
		log = LogManager.getLogger (DataSet.class);
	}

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 1:54:05 pm
	 */
	public DataSet () {
		log.entry ();
		this.tables = new ArrayList <IDataTable> ();
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#addTable(com.wizonsoft.teasy.data.
	 * IDataTable)
	 */
	@Override
	public void addTable (final IDataTable table) {
		log.entry ();
		this.tables.add (table);
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#clear()
	 */
	@Override
	public void clear () {
		log.entry ();
		this.tables.clear ();
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#getTable(java.lang.String)
	 */
	@Override
	public IDataTable getTable (final String tableName) throws SQLException {
		log.entry ();
		IDataTable t = null;
		for (final IDataTable table : this.tables)
			if (table.getTableName ().equals (tableName)) {
				t = table;
			}
		return log.exit (t);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#getTableIterator()
	 */
	@Override
	public IDataTableIterator getTableIterator () {
		log.entry ();
		return log.exit (new DataTableIterator (this));
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#getTableNames()
	 */
	@Override
	public String [] getTableNames () throws SQLException {
		log.entry ();
		final String [] names = new String [this.tables.size ()];
		int index = 0;
		for (final IDataTable table : this.tables) {
			names [index++] = table.getTableName ();
		}
		return log.exit (names);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#getTables()
	 */
	@Override
	public IDataTable [] getTables () {
		log.entry ();
		final IDataTable [] t = new IDataTable [this.tables.size ()];
		return log.exit (this.tables.toArray (t));
	}
}