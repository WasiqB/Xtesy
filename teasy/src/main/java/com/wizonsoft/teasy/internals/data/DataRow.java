package com.wizonsoft.teasy.internals.data;

import java.util.*;

import com.wizonsoft.teasy.data.*;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 7:42:52 pm
 */
public class DataRow implements IDataRow {
	private final List <IDataColumn>	columns;

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 7:42:52 pm
	 */
	public DataRow () {
		this.columns = new ArrayList <> ();
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 8:38:58 pm
	 * @param column
	 */
	@Override
	public void addColumn (final IDataColumn column) {
		this.columns.add (column);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#clear()
	 */
	@Override
	public void clear () {
		this.columns.clear ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumn(int)
	 */
	@Override
	public IDataColumn getColumn (final int variableIndex) {
		for (final IDataColumn column : this.columns) {
			if (column.getVariable ().getIndex () == variableIndex) return column;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumn(java.lang.String)
	 */
	@Override
	public IDataColumn getColumn (final String variableName) {
		for (final IDataColumn column : this.columns) {
			if (column.getVariable ().getName ().equals (variableName)) return column;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumnCount()
	 */
	@Override
	public int getColumnCount () {
		return this.columns.size ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumnIndex(java.lang.String)
	 */
	@Override
	public int getColumnIndex (final String variableName) {
		return this.columns.indexOf (variableName) + 1;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumns()
	 */
	@Override
	public IDataColumn [] getColumns () {
		final IDataColumn [] cols = new IDataColumn [getColumnCount ()];
		return this.columns.toArray (cols);
	}
}