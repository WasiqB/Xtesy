package com.wizonsoft.teasy.internals.data;

import java.sql.SQLException;
import java.util.*;

import com.wizonsoft.teasy.data.*;

/**
 * @author Wasiq B
 * @since 24-Jan-2015 1:54:05 pm
 */
public class DataSet implements IDataSet {
	private final List <IDataTable>	tables;

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 1:54:05 pm
	 */
	public DataSet () {
		this.tables = new ArrayList <IDataTable> ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#addTable(com.wizonsoft.teasy.data.
	 * IDataTable)
	 */
	@Override
	public void addTable (final IDataTable table) {
		this.tables.add (table);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#clear()
	 */
	@Override
	public void clear () {
		this.tables.clear ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#getTable(java.lang.String)
	 */
	@Override
	public IDataTable getTable (final String tableName) throws SQLException {
		for (final IDataTable table : this.tables)
			if (table.getTableName ().equals (tableName)) return table;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#getTableIterator()
	 */
	@Override
	public IDataTableIterator getTableIterator () {
		return new DataTableIterator (this);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#getTableNames()
	 */
	@Override
	public String [] getTableNames () throws SQLException {
		final String [] names = new String [this.tables.size ()];
		int index = 0;
		for (final IDataTable table : this.tables) {
			names [index++] = table.getTableName ();
		}
		return names;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataSet#getTables()
	 */
	@Override
	public IDataTable [] getTables () {
		final IDataTable [] t = new IDataTable [this.tables.size ()];
		return this.tables.toArray (t);
	}
}