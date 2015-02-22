package com.wizonsoft.teasy.internals.data;

import com.wizonsoft.teasy.data.*;

/**
 * @author Wasiq B
 * @since 24-Jan-2015 3:28:33 pm
 */
public class DataTableIterator implements IDataTableIterator {
	private int					index;
	private final IDataTable []	tables;

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 3:28:33 pm
	 */
	public DataTableIterator (final IDataSet ds) {
		reset ();
		this.tables = ds.getTables ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableIterator#current()
	 */
	@Override
	public IDataTable current () {
		return this.tables [this.index];
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableIterator#hasNext()
	 */
	@Override
	public boolean hasNext () {
		return this.index < this.tables.length - 1;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableIterator#next()
	 */
	@Override
	public void next () {
		this.index++;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableIterator#reset()
	 */
	@Override
	public void reset () {
		this.index = 0;
	}
}