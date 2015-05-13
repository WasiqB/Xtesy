package com.wizonsoft.xtesy.core.internals.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.core.data.IDataSet;
import com.wizonsoft.xtesy.core.data.IDataTable;
import com.wizonsoft.xtesy.core.data.IDataTableIterator;

/**
 * @author Wasiq B
 * @since 24-Jan-2015 3:28:33 pm
 */
public class DataTableIterator implements IDataTableIterator {
	private static Logger		log;
	private int					index;
	private final IDataTable []	tables;

	static {
		log = LogManager.getLogger (DataTableIterator.class);
	}

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 3:28:33 pm
	 */
	public DataTableIterator (final IDataSet ds) {
		log.entry ();
		reset ();
		this.tables = ds.getTables ();
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableIterator#current()
	 */
	@Override
	public IDataTable current () {
		log.entry ();
		return log.exit (this.tables [this.index]);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableIterator#hasNext()
	 */
	@Override
	public boolean hasNext () {
		log.entry ();
		return log.exit (this.index < this.tables.length - 1);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableIterator#next()
	 */
	@Override
	public void next () {
		log.entry ();
		this.index++;
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataTableIterator#reset()
	 */
	@Override
	public void reset () {
		log.entry ();
		this.index = 0;
		log.exit ();
	}
}