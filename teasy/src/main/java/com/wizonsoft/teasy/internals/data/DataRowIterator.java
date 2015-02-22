package com.wizonsoft.teasy.internals.data;

import com.wizonsoft.teasy.data.*;

/**
 * @author Wasiq B
 * @since 24-Jan-2015 7:53:45 pm
 */
public class DataRowIterator implements IDataRowIterator {
	private int					index;
	private final IDataRow []	rows;

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 7:53:45 pm
	 */
	public DataRowIterator (final IDataRow [] rows) {
		this.rows = rows;
		reset ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#current()
	 */
	@Override
	public IDataRow current () {
		return this.rows [this.index];
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#getValue(int)
	 */
	@Override
	public <T> T getValue (final int variableIndex) {
		return current ().getColumn (variableIndex).getValue ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#getValue(java.lang.String)
	 */
	@Override
	public <T> T getValue (final String variableName) {
		return current ().getColumn (variableName).getValue ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#hasNext()
	 */
	@Override
	public boolean hasNext () {
		return this.index < this.rows.length - 1;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#next()
	 */
	@Override
	public void next () {
		this.index++;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#reset()
	 */
	@Override
	public void reset () {
		this.index = 0;
	}
}