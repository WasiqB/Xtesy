package com.wizonsoft.xtesy.internals.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.data.IDataColumn;
import com.wizonsoft.xtesy.data.IDataRow;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 7:42:52 pm
 */
public class DataRow implements IDataRow {
	private static Logger				log;
	private final List <IDataColumn>	columns;

	static {
		log = LogManager.getLogger (DataRow.class);
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 7:42:52 pm
	 */
	public DataRow () {
		log.entry ();
		this.columns = new ArrayList <> ();
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 8:38:58 pm
	 * @param column
	 */
	@Override
	public void addColumn (final IDataColumn column) {
		log.entry ();
		this.columns.add (column);
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#clear()
	 */
	@Override
	public void clear () {
		log.entry ();
		this.columns.clear ();
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumn(int)
	 */
	@Override
	public IDataColumn getColumn (final int variableIndex) {
		log.entry ();
		IDataColumn col = null;
		for (final IDataColumn column : this.columns) {
			if (column.getVariable ().getIndex () == variableIndex) {
				col = column;
				break;
			}
		}
		return log.exit (col);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumn(java.lang.String)
	 */
	@Override
	public IDataColumn getColumn (final String variableName) {
		log.entry ();
		IDataColumn col = null;
		for (final IDataColumn column : this.columns) {
			if (column.getVariable ().getName ().equals (variableName)) {
				col = column;
				break;
			}
		}
		return log.exit (col);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumnCount()
	 */
	@Override
	public int getColumnCount () {
		log.entry ();
		return log.exit (this.columns.size ());
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumnIndex(java.lang.String)
	 */
	@Override
	public int getColumnIndex (final String variableName) {
		log.entry ();
		return log.exit (this.columns.indexOf (variableName) + 1);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRow#getColumns()
	 */
	@Override
	public IDataColumn [] getColumns () {
		log.entry ();
		final IDataColumn [] cols = new IDataColumn [getColumnCount ()];
		return log.exit (this.columns.toArray (cols));
	}
}